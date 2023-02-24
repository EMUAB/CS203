import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public interface Box {
    /**
     * Sets up an empty ArrayList<ArrayList<Flashcard>> so it has 5 empty boxes
     *
     * @param deck 2D ArrayList containing 5 boxes
     * @return deck
     */
    static ArrayList<ArrayList<Flashcard>> setupBoxes(ArrayList<ArrayList<Flashcard>> deck) {
        for (int i = 0; i < 5; i++) {
            deck.add(new ArrayList<Flashcard>());
        }
        return deck;
    }

    /**
     * Adds a card to the first box in a given deck
     *
     * @param deck 2D ArrayList containing 5 boxes
     * @param card Flashcard
     * @return deck
     */
    static ArrayList<ArrayList<Flashcard>> addNewCard(ArrayList<ArrayList<Flashcard>> deck, Flashcard card) {
        deck.get(0).add(card);
        return deck;
    }

    /**
     * Removes a given card from a given deck
     *
     * @param deck 2D ArrayList containing 5 boxes
     * @param card Flashcard
     * @return deck
     */
    static ArrayList<ArrayList<Flashcard>> removeCard(ArrayList<ArrayList<Flashcard>> deck, Flashcard card) {
        for (int j = 0; j < 5; j++) {
            deck.get(j).removeIf(i -> card == i);
        }
        return deck;
    }

    /**
     * Chooses a card from the given deck semi-randomly, weighted according to the boxes
     *
     * @param deck 2D ArrayList containing 5 boxes
     * @return deck
     */
    static Flashcard chooseCard(ArrayList<ArrayList<Flashcard>> deck) {
        Random rand = new Random();
        int chosenBox = 0;
        boolean boxEmpty = true;
        while (boxEmpty) {
            double random = (double) (rand.nextInt(501)) / 1000;
            for (int i = 1; i<=6 ; i++) {
                if (Math.pow(0.5, i) < random) {
                    chosenBox = i - 2;
                    if (deck.get(chosenBox).size() > 0) {
                        boxEmpty = false;
                        break;
                    }
                }
            }
        }
        int chosenCard = rand.nextInt(deck.get(chosenBox).size());
        return deck.get(chosenBox).get(chosenCard);
    }

    /**
     * Checks if the given deck contains no cards
     *
     * @param deck 2D ArrayList containing 5 boxes
     * @return deck
     */
    static boolean isEmpty(ArrayList<ArrayList<Flashcard>> deck) {
        boolean empty = false;
        for (ArrayList<Flashcard> i : deck) {
            if (i.size() == 0) {
                empty = true;
            } else {
                empty = false;
                break;
            }
        }
        return empty;
    }

    /**
     * Checks if a given card is in the given deck
     *
     * @param deck 2D ArrayList containing 5 boxes
     * @param card Flashcard
     * @return deck
     */
    static boolean isInDeck(ArrayList<ArrayList<Flashcard>> deck, Flashcard card) {
        boolean exists = false;
        search:
        for (ArrayList<Flashcard> i : deck) {
            for (Flashcard j : i) {
                if (Objects.equals(j.getFront(), card.getFront()) && Objects.equals(j.getBack(), card.getBack())) {
                    exists = true;
                    break search;
                }
            }
        }
        return exists;
    }

    /**
     * Checks if the given card is in the given box in the given deck
     *
     * @param deck 2D ArrayList containing 5 boxes
     * @param box  Int of desired box
     * @param card Flashcard
     * @return deck
     */
    static boolean isInBox(ArrayList<ArrayList<Flashcard>> deck, int box, Flashcard card) {
        boolean exists = false;
        for (Flashcard j : deck.get(box)) {
            if (Objects.equals(j.getFront(), card.getFront()) && Objects.equals(j.getBack(), card.getBack())) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    /**
     * Moves the given card in the given deck to the next box, so long as it is not in the final box
     *
     * @param deck 2D ArrayList containing 5 boxes
     * @param card Flashcard
     * @return deck
     */
    static ArrayList<ArrayList<Flashcard>> advanceCard(ArrayList<ArrayList<Flashcard>> deck, Flashcard card) {
        full:
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < deck.get(i).size(); j++) {
                if (isInBox(deck, i, card)) {
                    removeCard(deck, card);
                    deck.get(i + 1).add(card);
                    break full;
                }
            }
        }
        return deck;
    }

    /**
     * Moves the given card to the first box in the given deck
     *
     * @param deck 2D ArrayList containing 5 boxes
     * @param card Flashcard
     * @return deck
     */
    static ArrayList<ArrayList<Flashcard>> resetCard(ArrayList<ArrayList<Flashcard>> deck, Flashcard card) {
        removeCard(deck, card);
        addNewCard(deck, card);
        return deck;
    }

    /**
     * Takes a String containing cards in text format and adds them to the given deck
     *
     * @param deck     2D ArrayList containing 5 boxes
     * @param stringIn String to convert
     * @return deck
     */
    static ArrayList<ArrayList<Flashcard>> importText(ArrayList<ArrayList<Flashcard>> deck, String stringIn) {
        String front, back;
        String[] fullArray = stringIn.split("\n");
        String[] tempArray;
        for (String i : fullArray) {
            tempArray = i.split("\\|");
            front = tempArray[0];
            back = tempArray[1];
            deck.get(0).add(new Flashcard(front, back));
        }
        return deck;
    }

    /**
     * Converts a given deck into text format "front|back"
     *
     * @param deck 2D ArrayList containing 5 boxes
     * @return String
     */
    static String exportAsString(ArrayList<ArrayList<Flashcard>> deck) {
        StringBuilder s = new StringBuilder();
        for (ArrayList<Flashcard> i : deck) {
            for (Flashcard j : i) {
                s.append(j.getFront() + "|" + j.getBack() + "\n");
            }
        }
        return s.toString();
    }
}


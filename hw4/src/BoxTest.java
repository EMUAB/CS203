import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BoxTest {
    ArrayList<ArrayList<Flashcard>> deck = new ArrayList<>(5);
    Flashcard f1 = new Flashcard("fr1", "br1");
    Flashcard f2 = new Flashcard("fr2", "br2");
    Flashcard f3 = new Flashcard("fr3", "br3");
    Flashcard f4 = new Flashcard("fr4", "br4");
    Flashcard f5 = new Flashcard("fr5", "br5");
    Flashcard f6 = new Flashcard("fr6", "br6");

    @Before
    public void setupDeck() {
        Box.setupBoxes(deck);
        Box.addNewCard(deck, f1);
        deck.get(1).add(f2);
        deck.get(2).add(f3);
        deck.get(3).add(f4);
        deck.get(4).add(f5);
    }

    @Test
    public void testAddCard() {
        Box.addNewCard(deck, f6);
        assertTrue(Box.isInDeck(deck, f6));
    }

    @Test
    public void testRemoveCard() {
        Box.removeCard(deck, f3);
        assertFalse(Box.isInDeck(deck, f3));
    }

    @Test
    public void testChooseCard() {
        double b1 = 0, b2 = 0, b3 = 0, b4 = 0, b5 = 0;
        for (int i = 0; i<=1000 ; i++) {
            Flashcard chosen = Box.chooseCard(deck);
            for (int j =0 ; j<5 ; j++) {
                if (Box.isInBox(deck, j, chosen)) {
                    switch (j) {
                        case 0: b1++; break;
                        case 1: b2++; break;
                        case 2: b3++; break;
                        case 3: b4++; break;
                        case 4: b5++; break;
                    }
                }
            }
        }
        System.out.println("Box 1: " + b1/10 + "% Box 2: " + b2/10 + "% Box 3: " + b3/10 + "% Box 4: " + b4/10 + "% Box 5: " + b5/10 + "%");
        assertEquals(50, b1/10, 2.5);
        assertEquals(3, b5/10, 2.5);
    }

    @Test
    public void testIsInDeck() {
        assertTrue(Box.isInDeck(deck, f2));
    }

    @Test
    public void testIsInBox() {
        assertTrue(Box.isInBox(deck, 0, f2));
    }

    @Test
    public void testAdvanceCard() {
        Box.advanceCard(deck, f2);
        Box.advanceCard(deck, f2);
        assertTrue(Box.isInBox(deck, 2, f2));
    }

    @Test
    public void testResetCard() {
        Box.advanceCard(deck, f1);
        Box.resetCard(deck, f1);
        assertTrue(Box.isInBox(deck, 0, f1));
    }
}
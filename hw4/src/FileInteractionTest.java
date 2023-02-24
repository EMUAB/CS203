import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class FileInteractionTest {
    //SaveInteraction saver;
    File data, save;
    ArrayList<ArrayList<Flashcard>> deck;

    @Before
    public void setUp() {
        data = new File("deckFiles\\savedDeck.txt");
        save = new File("deckFiles\\save.txt");
        deck = Box.setupBoxes(new ArrayList<>(5));
        deck.get(2).add(new Flashcard("dwweib", "poeli"));
        deck.get(0).add(new Flashcard("poop", "pee..."));
        deck.get(4).add(new Flashcard("plinko", "pachinko"));
    }

    @Test
    public void testParseSave() {
        //System.out.println(saver.parseSave(data).get(0).get(0).getFront());
        assertEquals("pee...", FileInteraction.parseSave(save).get(0).get(0).getBack());
    }

    @Test
    public void testSaveToFile() {
        FileInteraction.saveToFile(deck, "save");
    }

    @Test
    public void testExportAsString() {
        System.out.println(Box.exportAsString(deck));
    }
}
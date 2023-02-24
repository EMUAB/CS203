import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlashcardTest {
    Flashcard testCard;

    /*
     * Creates a Flashcard for testing
     */
    @Before
    public void setUp() {
        testCard = new Flashcard("frontT", "backT");
    }

    /*
     * Tests getting the front of a card
     */
    @Test
    public void testGetFront() {
        assertEquals(testCard.getFront(), "frontT");
    }

    /*
     * Tests setting the front of a card
     */
    @Test
    public void testSetFront() {
        testCard.setFront("frontNew");
        assertEquals(testCard.getFront(), "frontNew");
    }

    /*
     * Tests getting the back of a card
     */
    @Test
    public void testGetBack() {
        assertEquals(testCard.getBack(), "backT");
    }

    /*
     * Tests setting the back of a card
     */
    @Test
    public void testSetBack() {
        testCard.setBack("backNew");
        assertEquals(testCard.getBack(), "backNew");
    }
}
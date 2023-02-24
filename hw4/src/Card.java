public interface Card {
    /**
     * Gets the front text of this Card
     *
     * @return String value of Front
     */
    String getFront();

    /**
     * Sets the value of the front text of this Card
     *
     * @param front String to set
     */
    void setFront(String front);

    /**
     * Gets the front text of this Card
     *
     * @return String value of Back
     */
    String getBack();

    /**
     * Sets the back text of this Card
     *
     * @param back String value to set
     */
    void setBack(String back);

    /**
     * Converts the card to a String array containing two elements, the front and back
     *
     * @return String array of 2
     */
    String[] toArray();
}

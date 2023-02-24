public class Flashcard implements Card {
    private String front, back;

    public Flashcard(String front, String back) {
        this.front = front;
        this.back = back;
    }

    public String getFront() {
        return front;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public String toString() {
        return "Front: " + front + " Back: " + back;
    }

    public String[] toArray() {
        return new String[]{front, back};
    }
}

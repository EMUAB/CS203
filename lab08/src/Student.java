
public class Student {
    private String name;
    private int exam1, exam2, finalExam;
    private double finalGrade;
    private String letterGrade;

    public Student(String name, int exam1, int exam2, int finalExam) {
        this.name = name;
        this.exam1 = exam1;
        this.exam2 = exam2;
        this.finalExam = finalExam;
        finalGrade = (getExam1() * 0.25) + (getExam2() * 0.25) + (getFinalExam() * 0.5);
        if (getFinalGrade() >= 90) {
            letterGrade = "A";
        } else if (getFinalGrade() >= 80) {
            letterGrade = "B";
        } else if (getFinalGrade() >= 70) {
            letterGrade = "C";
        } else {
            letterGrade = "F";
        }
    }

    public int getExam1() {
        return exam1;
    }

    public int getExam2() {
        return exam2;
    }

    public int getFinalExam() {
        return finalExam;
    }

    public double getFinalGrade() {
        return finalGrade;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public String getName() {
        return name;
    }
}

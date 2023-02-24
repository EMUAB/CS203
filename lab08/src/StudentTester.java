import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentTester {
    public static void main(String[] args) {
        String name;
        int exam1, exam2, examFinal;
        ArrayList<Student> students = new ArrayList<>();
        try {
            PrintWriter out = new PrintWriter("studentGrades.txt");
            File input = new File("studentList.txt");
            Scanner scan = new Scanner(input).useDelimiter("[,\\r\\n]");
            while (scan.hasNext()) {
                name = scan.next();
                exam1 = Integer.parseInt(scan.next());
                exam2 = Integer.parseInt(scan.next());
                examFinal = Integer.parseInt(scan.next());
                students.add(new Student(name, exam1, exam2, examFinal));
            }
            for (Student i : students) {
                out.println(i.getName() + " received a grade of " + i.getFinalGrade() + ": " + i.getLetterGrade());
            }
            out.close();
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
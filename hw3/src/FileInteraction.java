import employees.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileInteraction {
    public FileInteraction() {
    }

    /**Converts the data of the uabEmployee text file to an Employee ArrayList
     * @param dataIn
     *
     * @return ArrayList {@code <Employee>}
     */
    public ArrayList<Employee> parseDatabase(File dataIn) { // Reads the uabEmployee file
        ArrayList<Employee> employees = new ArrayList<>();
        String name, specific, bool;
        int blazerId, patients;
        try {
            Scanner scanner = new Scanner(dataIn);
            while (scanner.hasNext()) {
                switch (scanner.next()) {
                    case "E" -> {
                        name = scanner.next();
                        blazerId = Integer.parseInt(scanner.next());
                        employees.add(new Employee(name, blazerId));
                    }
                    case "D" -> {
                        name = scanner.next();
                        blazerId = Integer.parseInt(scanner.next());
                        specific = scanner.next();
                        employees.add(new Doctor(name, blazerId, specific));
                    }
                    case "S" -> {
                        name = scanner.next();
                        blazerId = Integer.parseInt(scanner.next());
                        specific = scanner.next();
                        bool = scanner.next().toUpperCase();
                        employees.add(new Surgeon(name, blazerId, specific, bool));
                    }
                    case "N" -> {
                        name = scanner.next();
                        blazerId = Integer.parseInt(scanner.next());
                        patients = Integer.parseInt(scanner.next());
                        employees.add(new Nurse(name, blazerId, patients));
                    }
                    case "A" -> {
                        name = scanner.next();
                        blazerId = Integer.parseInt(scanner.next());
                        specific = scanner.next();
                        employees.add(new Admin(name, blazerId, specific));
                    }
                    case "R" -> {
                        name = scanner.next();
                        blazerId = Integer.parseInt(scanner.next());
                        specific = scanner.next();
                        bool = scanner.next().toUpperCase();
                        employees.add(new Receptionist(name, blazerId, specific, bool));
                    }
                    case "J" -> {
                        name = scanner.next();
                        blazerId = Integer.parseInt(scanner.next());
                        specific = scanner.next();
                        bool = scanner.next().toUpperCase();
                        employees.add(new Janitor(name, blazerId, specific, bool));
                    }
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return employees;
    }

    /**Updates the uabEmployee text file to represent the given Employee ArrayList
     * @param employees
     */
    public void updateDatabase(ArrayList<Employee> employees) {
        String empInfo = "";
        for (Employee emp : employees) {
            if (emp instanceof Doctor) {
                if (emp instanceof Surgeon) {
                    empInfo += ("S " + emp.getName() + " " + emp.getBlazerID() + " " + ((Surgeon) emp).getSpecialty() + " " + ((Surgeon) emp).isOperating() + "\n");
                } else {
                    empInfo += ("D " + emp.getName() + " " + emp.getBlazerID() + " " + ((Doctor) emp).getSpecialty() + "\n");
                }
            } else if (emp instanceof Admin) {
                if (emp instanceof Receptionist) {
                    empInfo += ("R " + emp.getName() + " " + emp.getBlazerID() + " " + ((Receptionist) emp).getDepartment() + " " + ((Receptionist) emp).isAnswering() + "\n");
                } else if (emp instanceof Janitor) {
                    empInfo += ("J " + emp.getName() + " " + emp.getBlazerID() + " " + ((Janitor) emp).getDepartment() + " " + ((Janitor) emp).isSweeping() + "\n");
                } else {
                    empInfo += ("A " + emp.getName() + " " + emp.getBlazerID() + " " + ((Admin) emp).getDepartment() + "\n");
                }
            } else if (emp instanceof Nurse) {
                empInfo += ("N " + emp.getName() + " " + emp.getBlazerID() + " " + ((Nurse) emp).getPatients() + "\n");
            } else {
                empInfo += "E " + emp.getName() + " " + emp.getBlazerID() + "\n";
            }
        }
        try {
            PrintWriter writer = new PrintWriter("uabEmployee.txt");
            writer.print(empInfo);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

import addMenus.*;
import employees.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class HospitalMenu {
    public static void main(String[] args) {
        File database = new File("uabEmployee.txt");
        ArrayList<Employee> employeeList = new ArrayList<>(new FileInteraction().parseDatabase(database));
        Scanner in = new Scanner(System.in);
        while (true) { // Ensures the user always returns to the main menu after finishing an action in a submenu
            System.out.println("Please enter a number [1-5] to select the respective option.\n1. Display the employee list\t2. Add employee\t\t3. Update the database\t\t4. Delete employee\t\t5. Exit Application");
            int menuChosen = in.nextInt();
            switch (menuChosen) {
                case 1 -> {// Display employee list
                    System.out.println(new EmployeeDisplay().printList(employeeList));
                }
                case 2 -> {//Add employee
                    System.out.println("Please enter the letter according to the role of employee:\nE. Hospital Employee\tD. Doctor\tS. Surgeon\t N. Nurse\tA. Administrator\tR. Receptionist\t\tJ. Janitor");
                    String roleChosen = in.next().toUpperCase();
                    switch (roleChosen) { // Adds a new employee to the ArrayList based on the role chosen
                        case "E" -> {
                            EmployeeMenu cEmployee = new EmployeeMenu(in);
                            employeeList.add(new Employee(cEmployee.getName(), cEmployee.getBlazerId()));
                            System.out.println("Hospital Employee " + cEmployee.getName() + " with BlazerID " + cEmployee.getBlazerId() + " has been added.");
                        }
                        case "D" -> {
                            DoctorMenu cDoctor = new DoctorMenu(in);
                            employeeList.add(new Doctor(cDoctor.getName(), cDoctor.getBlazerId(), cDoctor.getSpecialty()));
                            System.out.println("Doctor " + cDoctor.getName() + " with BlazerID " + cDoctor.getBlazerId() + " of the specialty " + cDoctor.getSpecialty() + " has been added.");
                        }
                        case "S" -> {
                            SurgeonMenu cSurgeon = new SurgeonMenu(in);
                            employeeList.add(new Surgeon(cSurgeon.getName(), cSurgeon.getBlazerId(), cSurgeon.getSpecialty(), cSurgeon.isOperating()));
                            System.out.println("Surgeon " + cSurgeon.getName() + " with BlazerID " + cSurgeon.getBlazerId() + " of the specialty " + cSurgeon.getSpecialty() + "and is operating: " + cSurgeon.isOperating() + " has been added.");
                        }
                        case "N" -> {
                            NurseMenu cNurse = new NurseMenu(in);
                            employeeList.add(new Nurse(cNurse.getName(), cNurse.getBlazerId(), cNurse.getPatients()));
                            System.out.println("Nurse " + cNurse.getName() + " with BlazerID " + cNurse.getBlazerId() + " and " + cNurse.getPatients() + " patients has been added.");
                        }
                        case "A" -> {
                            AdminMenu cAdmin = new AdminMenu(in);
                            employeeList.add(new Admin(cAdmin.getName(), cAdmin.getBlazerId(), cAdmin.getDepartment()));
                            System.out.println("Administrator " + cAdmin.getName() + " with BlazerID " + cAdmin.getBlazerId() + " in the department " + cAdmin.getDepartment() + " has been added.");
                        }
                        case "R" -> {
                            ReceptionistMenu cReceptionist = new ReceptionistMenu(in);
                            employeeList.add(new Receptionist(cReceptionist.getName(), cReceptionist.getBlazerId(), cReceptionist.getDepartment(), cReceptionist.isAnswering()));
                            System.out.println("Receptionist " + cReceptionist.getName() + " with BlazerID " + cReceptionist.getBlazerId() + " in the department " + cReceptionist.getDepartment() + " and is answering: " + cReceptionist.isAnswering() + " has been added.");
                        }
                        case "J" -> {
                            JanitorMenu cJanitor = new JanitorMenu(in);
                            employeeList.add(new Janitor(cJanitor.getName(), cJanitor.getBlazerId(), cJanitor.getDepartment(), cJanitor.isSweeping()));
                            System.out.println("Janitor " + cJanitor.getName() + " with BlazerID " + cJanitor.getBlazerId() + " in the department " + cJanitor.getDepartment() + "and is sweeping: " + cJanitor.isSweeping() + " has been added.");
                        }
                        default -> {
                            System.out.println("That option is not available");
                        }
                    }
                } // Add employees
                case 3 -> {//Update Database
                    new FileInteraction().updateDatabase(employeeList);
                    System.out.println("Updated the database.");
                } // Update the database
                case 4 -> {//Delete Employee
                    String name = "";
                    int BlazerId;
                    boolean foundId = false;
                    System.out.println("What is the BlazerId of the employee you would like to delete?");
                    BlazerId = in.nextInt();
                    for (Employee i : employeeList) { // Only needs BlazerId since they all are unique
                        if (i.getBlazerID()==BlazerId) {
                            name = i.getClass().toString().replace("class employees.", "") +" " + i.getName();
                            employeeList.remove(i);
                            foundId = true;
                            break;
                        }
                    }
                    if (!foundId) {
                        System.out.println("No employee with BlazerId [" + BlazerId + "] could be found.");
                        break;
                    }
                    System.out.println(name + " has been removed.");
                } // Remove an employee
                case 5 -> {//Exit application
                    System.out.println("Any changes that have not been committed to the database will be lost, continue? (y/n)");
                    if (in.next().equalsIgnoreCase("y")) {
                        in.close();
                        System.exit(0);
                    }

                }
                default -> {
                    System.out.println("That option is not available.");
                }
            }
            try {
                Thread.sleep(1500); //Added for clarity about the result of actions
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
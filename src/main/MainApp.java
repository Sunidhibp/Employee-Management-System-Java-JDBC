package main;

import dao.EmployeeDAO;
import model.Employee;
import java.util.Scanner;


public class MainApp {

    public static void main(String[] args) {

        EmployeeDAO dao = new EmployeeDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Salary");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    String name = readNonEmptyString(sc, "Name");
                    String department = readNonEmptyString(sc, "Department");
                    double salary = readPositiveDouble(sc, "Salary");

                    Employee emp = new Employee(name, department, salary);
                    dao.addEmployee(emp);
                    break;


                case 2:
                    System.out.println("\n📋 Employee List:");
                    dao.getAllEmployees().forEach(e ->
                            System.out.println(
                                    e.getEmpId() + " | " +
                                            e.getName() + " | " +
                                            e.getDepartment() + " | " +
                                            e.getSalary()
                            )
                    );
                    break;

                case 3:
                    System.out.print("Employee ID: ");
                    int id = sc.nextInt();

                    System.out.print("New Salary: ");
                    double newSalary = sc.nextDouble();

                    dao.updateEmployeeSalary(id, newSalary);
                    break;
/*
                case 4:
                    System.out.print("Employee ID to delete: ");
                    int delId = sc.nextInt();
                    sc.nextLine(); // consume newline

                    System.out.print("Are you sure you want to delete? (yes/no): ");
                    String confirm = sc.nextLine();

                    if (confirm.equalsIgnoreCase("yes")) {
                        dao.deleteEmployee(delId);
                    } else {
                        System.out.println("❌ Delete cancelled");
                    }
                    break;
*/


                case 5:
                    System.out.println("Exiting application...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static String readNonEmptyString(Scanner sc, String fieldName) {
        String input;
        do {
            System.out.print("Enter " + fieldName + ": ");
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("❌ " + fieldName + " cannot be empty.");
            }
        } while (input.isEmpty());
        return input;
    }

    private static double readPositiveDouble(Scanner sc, String fieldName) {
        double value = -1;
        while (value <= 0) {
            System.out.print("Enter " + fieldName + ": ");
            try {
                value = Double.parseDouble(sc.nextLine());
                if (value <= 0) {
                    System.out.println("❌ " + fieldName + " must be greater than 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Please enter a valid number.");
            }
        }
        return value;
    }


}

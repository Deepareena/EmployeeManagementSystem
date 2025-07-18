import java.util.Scanner;

public class EmployeeManagementSystem {
    private static final int MAX = 100;
    private static Employee[] employees = new Employee[MAX];
    private static int count = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Delete Employee by ID");
            System.out.println("5. Update Employee");
            System.out.println("6. Total Employees");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> viewEmployees();
                case 3 -> searchById();
                case 4 -> deleteById();
                case 5 -> updateEmployee();
                case 6 -> System.out.println("Total Employees: " + count);
                case 7 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 7);
    }

    private static void addEmployee() {
        if (count >= MAX) {
            System.out.println("Cannot add more employees. Limit reached.");
            return;
        }

        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Department: ");
        String dept = scanner.nextLine();

        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();

        employees[count++] = new Employee(id, name, dept, salary);
        System.out.println("? Employee added.");
    }

    private static void viewEmployees() {
        if (count == 0) {
            System.out.println("No employees to display.");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    private static void searchById() {
        System.out.print("Enter ID to search: ");
        int id = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            if (employees[i].getId() == id) {
                System.out.println(employees[i]);
                return;
            }
        }

        System.out.println("? Employee not found.");
    }

    private static void deleteById() {
        System.out.print("Enter ID to delete: ");
        int id = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            if (employees[i].getId() == id) {
                // Shift remaining employees left
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                System.out.println("? Employee deleted.");
                return;
            }
        }

        System.out.println("? Employee not found.");
    }

    private static void updateEmployee() {
        System.out.print("Enter ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < count; i++) {
            if (employees[i].getId() == id) {
                System.out.print("Enter new Name: ");
                String name = scanner.nextLine();

                System.out.print("Enter new Department: ");
                String dept = scanner.nextLine();

                System.out.print("Enter new Salary: ");
                double salary = scanner.nextDouble();

                employees[i].setName(name);
                employees[i].setDepartment(dept);
                employees[i].setSalary(salary);

                System.out.println("? Employee updated.");
                return;
            }
        }

        System.out.println("? Employee not found.");
    }
}
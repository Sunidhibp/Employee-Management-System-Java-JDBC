package dao;

import model.Employee;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    // INSERT employee
    public void addEmployee(Employee emp) {
        String sql = "INSERT INTO employee (name, department, salary) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, emp.getName());
            stmt.setString(2, emp.getDepartment());
            stmt.setDouble(3, emp.getSalary());

            stmt.executeUpdate();
            System.out.println("✅ Employee added successfully");

        } catch (SQLException e) {
            System.out.println("❌ Failed to add employee");
            e.printStackTrace();
        }
    }

    public void updateEmployeeSalary(int empId, double newSalary) {

        String sql = "UPDATE employee SET salary = ? WHERE emp_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, newSalary);
            stmt.setInt(2, empId);

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println("✅ Salary updated successfully");
            } else {
                System.out.println("⚠️ Employee ID not found");
            }

        } catch (SQLException e) {
            System.out.println("❌ Failed to update salary");
            e.printStackTrace();
        }
    }


    // READ all employees
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employee";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Employee emp = new Employee(
                        rs.getInt("emp_id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getDouble("salary")
                );
                list.add(emp);
            }

        } catch (SQLException e) {
            System.out.println("❌ Failed to fetch employees");
            e.printStackTrace();
        }

        return list;
    }
    // DELETE employee
    public void deleteEmployee(int empId) {
        String sql = "DELETE FROM employee WHERE emp_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, empId);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Employee deleted");
            } else {
                System.out.println("⚠ Employee not found");
            }

        } catch (SQLException e) {
            System.out.println("❌ Failed to delete employee");
            e.printStackTrace();
        }
    }

}

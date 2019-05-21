package services.implementations;

import models.Department;
import services.interfaces.DAO;

import java.sql.*;
import java.util.LinkedList;

public class DepartmentDAO implements DAO<Department> {

    public static LinkedList<Department> getAllDepartments() {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        LinkedList<Department> result = new LinkedList<>();
        String query = "select * from department";

        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                Department dep = new Department(rs.getString("id"), rs.getString("name"));
                result.add(dep);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
        return result;
    }

    public static String findDepartmentNameById(String depId) {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        String name = "Error";
        String query = "select * from department where id=" + depId;
        ResultSet result = null;
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                name = rs.getString("name");
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }
        }

        return name;
    }

    public static boolean addDepartment(Department department) {

        Connection con = null;
        Statement stmt = null;

        boolean addedSuccesfully = true;
        String query = String.format("INSERT INTO department (name)  VALUES ( '%s' )", department.getName());

        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException sqlEx) {
            addedSuccesfully = false;
            sqlEx.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) {
                addedSuccesfully = false;
            }
            try {
                stmt.close();
            } catch (SQLException se) {
                addedSuccesfully = false;
            }
        }

        return addedSuccesfully;

    }

    public static boolean deleteDepartmentByName(String depName){
        Connection con = null;
        Statement stmt = null;

        boolean deletedSuccesfully = true;
        String query = String.format("DELETE FROM department WHERE name= '%s' ", depName);

        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException sqlEx) {
            deletedSuccesfully = false;
            sqlEx.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) {
                deletedSuccesfully = false;
            }
            try {
                stmt.close();
            } catch (SQLException se) {
                deletedSuccesfully = false;
            }
        }

        return deletedSuccesfully;
    }

}

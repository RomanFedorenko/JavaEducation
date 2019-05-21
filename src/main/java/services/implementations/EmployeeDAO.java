package services.implementations;

import models.Employee;
import services.interfaces.DAO;

import java.sql.*;
import java.util.LinkedList;

public class EmployeeDAO implements DAO<Employee> {


    private static LinkedList<Employee> executeSelectQuery(String sqlQuery){

        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;

        LinkedList<Employee> result = new LinkedList<>();

        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(sqlQuery);
            while(rs.next()){
                Employee dep = new Employee(rs.getString("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("birth_date"),
                        rs.getString("phone_number"),
                        rs.getString("salary"),
                        rs.getString("dep_id")
                );
                result.add(dep);

            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
        return result;

    }

    public static LinkedList<Employee> getAllEmployess() {

        return executeSelectQuery( "select * from employee");
    }

    public static LinkedList<Employee> getEmployeesByDepId(String depId) {

        return executeSelectQuery( "select * from employee where dep_id="+depId);
    }
  }

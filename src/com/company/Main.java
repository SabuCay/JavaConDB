package com.company;

import java.sql.*;

public class Main {

    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/ap";
    public static Connection con;
    /**   we want to use JDBC protocol, mysql DBMS , the local host with
     the database ap */

    public static void main(String[] args) throws SQLException {
            try {
                // in the url we have to tell which account and password to use
                con = DriverManager.getConnection(DATABASE_URL,"root","11Sabum");

                //*** now that the connection is established we do the query
                Statement s = con.createStatement();
                ResultSet rs = s.executeQuery("SELECT vendor_name,  vendor_city  from vendors where default_account_number > '500'");

                // if the resultset is not empty, we position to first row and display first field
                if (rs != null)
                    while (rs.next()) {
                        System.out.println("Data for name: " + rs.getString("vendor_name"));
                        System.out.printf("\n%s  %s\n ","Data for City: ",rs.getString("vendor_city"));
                    }
                s.close();
                con.close();
            }catch (SQLException sqlex) {
                System.out.println(sqlex.getMessage());
                System.exit(1);  // terminate program
            }
    }
}


package Selenium_WebDriver_ARichardson.exploration.minus2;

import java.sql.*;

class MySQLConnectionTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String dbURL = "jdbc:mysql://localhost:3306/emp?useUnicode=true&useJDBCCompliantTimezoneShift=true&" +
                "useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
        String username = "Iidwuurliik";
        String password = "123456";
        String mySQLquery = "SELECT * FROM emp.contacts";
        Class.forName("com.mysql.cj.jdbc.Driver"); // why ? load my sql driver?
        Connection connection = DriverManager.getConnection(dbURL, username, password);
        Statement statement = connection.createStatement();
        ResultSet employeeList = statement.executeQuery(mySQLquery);
        while (employeeList.next()) {
            String employeeID = employeeList.getString(1);
            String employeeName = employeeList.getString(2);
            String employeeAge = employeeList.getString(3);
            String employeePhone = employeeList.getString(4);
            String employeeEmail = employeeList.getString(5);

            System.out.println("Name : " + employeeName + "'s" + " email to spam with ads  ->: " + employeeEmail);
        }
        // close DB
        connection.close();


    }

}

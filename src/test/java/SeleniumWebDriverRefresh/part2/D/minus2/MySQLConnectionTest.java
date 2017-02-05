package SeleniumWebDriverRefresh.part2.D.minus2;

import java.sql.*;

class MySQLConnectionTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String dbURL = "jdbc:mysql://localhost:3306/emp?useUnicode=true&useJDBCCompliantTimezoneShift=true&" +
                "useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
        String username = "Iidwuurliik";
        String password = "123456";
        String mySQLquery = "SELECT * FROM emp.indusgandon";
        Class.forName("com.mysql.cj.jdbc.Driver"); // why ? load my sql driver?
        Connection connection = DriverManager.getConnection(dbURL, username, password);
        Statement statement = connection.createStatement();
        ResultSet employeeList = statement.executeQuery(mySQLquery);
        while (employeeList.next()) {
            String employeeName = employeeList.getString(1);
            String employeeAge = employeeList.getString(2);

            System.out.println("Name : " + employeeName + " Age :" + employeeAge);
        }
        // close DB
        connection.close();


    }

}

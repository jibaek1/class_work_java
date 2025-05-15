package ch02;

import java.sql.*;

public class JDBCExample2 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/employees?severTimezone=Asia/seoul";
        String user = "root";
        String password = "asd1234";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

         try {

             connection = DriverManager.getConnection(url,user,password);
             System.out.println("MySQL 데이터베이스에 성공적으로 연결 되었습니다.");

             statement = connection.createStatement();

             resultSet = statement.executeQuery("select * from dept_emp ");

             while(resultSet.next()){
                 int eno = resultSet.getInt("emp_no");
                 String dno = resultSet.getString("dept_no");
                 String fDate = resultSet.getString("from_date");
                 String tDate = resultSet.getString("to_date");
                 System.out.println("no : " + eno + "\t");
                 System.out.println("dno : " + dno + "\t");
                 System.out.println("fDate : " + fDate + "\t");
                 System.out.println("tDate : " + tDate + "\t");

             }

        } catch (Exception e) {

             e.printStackTrace();
         } finally {


         } try {
             resultSet.close();
             statement.close();
             connection.close();
        } catch (SQLException e){
            System.out.println("자원 해제 중 오류 발생 : " + e.getMessage());
        }

    }
}

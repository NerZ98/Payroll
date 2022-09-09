package payroll;

import java.sql.*;

public class conn {
    Connection conn;
    Statement s;
    public conn(){
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("Jdbc:mysql://localhost:3306/payroll", "root", "MithilKashid");
            s = conn.createStatement();
            if (conn.isClosed()) {
                System.out.println("Connection Closed");
            } else {
                System.out.println("Connection Created");
            }
        }
            catch(Exception e)
            {
             e.printStackTrace();
            }
        }
        public static void main(String args[]){
            new conn();
        }
}


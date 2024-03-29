package payroll;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TakeAttendance extends JFrame implements ActionListener{
    JLabel l1,l2,l8;
    JButton b1,b2;
    Choice c2,fh,sh;

    TakeAttendance(){

        setLayout(new GridLayout(4,2,50,50));
        c2 = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while(rs.next()){
                c2.add(rs.getString("id"));
            }


        }catch(Exception e){ }

        l8=new JLabel("Select Employee number");
        l8.setForeground(Color.WHITE);
        add(l8);
        c2.setBackground(Color.BLACK);
        c2.setForeground(Color.WHITE);

        add(c2);

        l1 = new JLabel("First Half");
        l1.setForeground(Color.WHITE);

        fh = new Choice();
        fh.add("Present");
        fh.add("Absent");
        fh.add("Leave");
        fh.setBackground(Color.BLACK);
        fh.setForeground(Color.WHITE);


        add(l1);
        add(fh);

        l2 = new JLabel("Second Half");
        l2.setForeground(Color.WHITE);

        sh = new Choice();
        sh.add("Present");
        sh.add("Absent");
        sh.add("Leave");
        sh.setBackground(Color.BLACK);
        sh.setForeground(Color.WHITE);

        add(l2);
        add(sh);

        b1 =new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2 = new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        add(b1);
        add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        getContentPane().setBackground(Color.BLACK);

        setSize(400,450);
        setLocation(600,200);

    }

    @Override
    public void actionPerformed(ActionEvent ae){

        String f = fh.getSelectedItem();
        String s = sh.getSelectedItem();
        String dt = new java.util.Date().toString();
        String id= c2.getSelectedItem();
        String qry = "insert into attendence values("+ id +",'"+dt+"','"+f+"','"+s+"')";

        try{
            conn c1 = new conn();
            c1.s.executeUpdate(qry);
            JOptionPane.showMessageDialog(null,"Attendence confirmed");
            this.setVisible(false);
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }

    public static void main(String s[]){
        new TakeAttendance().setVisible(true) ;
    }
}

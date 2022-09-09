package payroll;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Salary extends JFrame implements ActionListener{
    JLabel l1,l3,l4,l5,l6,l8;
    JTextField t1,t3,t4,t5,t6;
    JButton b1,b2;
    Choice c2;

    public Salary(){

        super("Set Salary");

        setLayout(new GridLayout(8,2,20,20));
        c2 = new Choice();
        c2.setBackground(Color.BLACK);
        c2.setForeground(Color.WHITE);

        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from employee");

            while(rs.next()){
                c2.add(rs.getString("id"));
            }
        }catch(Exception e){ }

        l8=new JLabel("Select Empno");
        l8.setForeground(Color.WHITE);
        add(l8);
        add(c2);

        l1 = new JLabel("HRA");
        l1.setForeground(Color.WHITE);

        t1 = new JTextField(15);
        t1.setBackground(Color.BLACK);
        t1.setForeground(Color.WHITE);

        add(l1);
        add(t1);

        l3 = new JLabel("DA");
        l3.setForeground(Color.WHITE);


        t3 = new JTextField(15);
        t3.setBackground(Color.BLACK);
        t3.setForeground(Color.WHITE);


        add(l3);
        add(t3);

        l4 = new JLabel("MED");
        l4.setForeground(Color.WHITE);

        t4 = new JTextField(15);
        t4.setBackground(Color.BLACK);
        t4.setForeground(Color.WHITE);

        add(l4);
        add(t4);

        l5 = new JLabel("PF");
        l5.setForeground(Color.WHITE);

        t5 = new JTextField(15);
        t5.setBackground(Color.BLACK);
        t5.setForeground(Color.WHITE);

        add(l5);
        add(t5);

        l6 = new JLabel("Basic Salary");
        l6.setForeground(Color.WHITE);

        t6 = new JTextField(15);
        t6.setBackground(Color.BLACK);
        t6.setForeground(Color.WHITE);
        add(l6);
        add(t6);

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


        setSize(450,550);
        setLocation(500,200);

        getContentPane().setBackground(Color.BLACK);

    }

    @Override
    public void actionPerformed(ActionEvent ae){
        JButton b = (JButton) ae.getSource();
        Double hra = Double.parseDouble(t1.getText());
        Double id = Double.parseDouble(c2.getSelectedItem());
        Double da = Double.parseDouble(t3.getText());
        Double med= Double.parseDouble(t4.getText());
        Double pf = Double.parseDouble(t5.getText());
        Double basic = Double.parseDouble(t6.getText());
        String qry = "insert into salary values('"+ id+"','"+hra+"','"+da+"','"+med+"','"+pf+"','"+basic+"')";

        try{
            conn c1 = new conn();
            c1.s.executeUpdate(qry);
            if(b == b1){
                JOptionPane.showMessageDialog(null,"Salary updated");
                this.setVisible(false);
            } else{
                JOptionPane.showMessageDialog(null, "Cancelled");
                this.setVisible(false);
            }
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Salary().setVisible(true);
    }
}

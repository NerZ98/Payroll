package payroll;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Update_salary extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5;
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2;
    Choice c2;

    Update_salary(){

        setLayout(null);
        c2 = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from salary");
            while(rs.next()){
                c2.add(rs.getString("id"));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        JLabel emp = new JLabel("Select Empno");
        emp.setBackground(Color.BLACK);
        emp.setForeground(Color.WHITE);


        emp.setBounds(20,20,100,20);
        add(emp);

        c2.setBounds(120,20,200,20);
        c2.setBackground(Color.BLACK);
        c2.setForeground(Color.WHITE);

        add(c2);

        l1 = new JLabel("Hra");
        l1.setBackground(Color.BLACK);
        l1.setForeground(Color.WHITE);

        t1 = new JTextField(15);
        t1.setBackground(Color.BLACK);
        t1.setForeground(Color.WHITE);

        l1.setBounds(20,60,100,20);
        t1.setBounds(120,60,200,20);
        add(l1);
        add(t1);

        l2 = new JLabel("Da");
        l2.setBackground(Color.BLACK);
        l2.setForeground(Color.WHITE);

        t2 = new JTextField(15);
        t2.setBackground(Color.BLACK);
        t2.setForeground(Color.WHITE);

        l2.setBounds(20,100,100,20);
        t2.setBounds(120,100,200,20);
        add(l2);
        add(t2);

        l3 = new JLabel("Med");
        l3.setBackground(Color.BLACK);
        l3.setForeground(Color.WHITE);

        t3 = new JTextField(15);
        t3.setBackground(Color.BLACK);
        t3.setForeground(Color.WHITE);

        l3.setBounds(20,140,100,20);
        t3.setBounds(120,140,200,20);
        add(l3);
        add(t3);

        l4 = new JLabel("Pf");
        l4.setBackground(Color.BLACK);
        l4.setForeground(Color.WHITE);

        t4 = new JTextField(15);
        t4.setBackground(Color.BLACK);
        t4.setForeground(Color.WHITE);

        l4.setBounds(20,180,100,20);
        t4.setBounds(120,180,200,20);
        add(l4);
        add(t4);

        l5 = new JLabel("basic_salary");
        l5.setBackground(Color.BLACK);
        l5.setForeground(Color.WHITE);


        t5 = new JTextField(15);
        t5.setBackground(Color.BLACK);
        t5.setForeground(Color.WHITE);

        l5.setBounds(20,220,100,20);
        t5.setBounds(120,220,200,20);
        add(l5);
        add(t5);

        b1 =new JButton("Update");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2 = new JButton("Delete");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        b1.setBounds(40,280,100,20);
        b2.setBounds(200,280,100,20);
        add(b1);
        add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        getContentPane().setBackground(Color.BLACK) ;

        setVisible(true);
        setSize(400,450);
        setLocation(600,200);
    }

    @Override
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b1){
            Double hra = Double.parseDouble(t1.getText());
            Double da = Double.parseDouble(t2.getText());
            Double med = Double.parseDouble(t3.getText());
            Double pf = Double.parseDouble(t4.getText());
            Double basic = Double.parseDouble(t5.getText());

            String qry = "update salary set hra="+hra+",da="+da+",med="+med+",pf="+pf+",basic_salary="+basic+"  where id="+c2.getSelectedItem();

            try{
                conn c1 = new conn();
                c1.s.executeUpdate(qry);
                JOptionPane.showMessageDialog(null,"Salary Updated");
                this.setVisible(false);
            }catch(Exception ee){
                ee.printStackTrace();
            }
        }

        if(ae.getSource()==b2){

            try{
                conn c1 = new conn();
                c1.s.executeUpdate("delete from salary where id="+c2.getSelectedItem());
                JOptionPane.showMessageDialog(null,"Salary Deleted");
                this.setVisible(false);
            }catch(Exception ee){
                ee.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        new Update_salary();
    }

}

package payroll;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class login extends JFrame implements ActionListener {
    JTextField t1;
    JPasswordField t2;
    JButton b1, b2, b3;
    JFrame frame;
    JLabel p1,p2;

    public login(){
        ImageIcon myIcon = new ImageIcon(this.getClass().getResource("images/login.png"));
        JLabel myLabel = new JLabel(myIcon);
        myLabel.setSize(650,450);

        b1 = new JButton("Submit");
        b1.setBounds(356,252,214,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setOpaque(false);
        myLabel.add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(470,296,100,30);
        b2.setBackground(Color.WHITE);
        b2.setForeground(Color.BLACK);
        myLabel.add(b2);

        b3 = new JButton("Forgot Password");
        b3.setBounds(356,296,100,30);
        b3.setBackground(Color.WHITE);
        b3.setForeground(Color.BLACK);
        myLabel.add(b3);

        p1 = new JLabel("User Name  ");
        p1.setBounds(370,75,100,30);
        p1.setForeground(Color.WHITE);
        myLabel.add(p1);

        p2 = new JLabel("Password  ");
        p2.setBounds(373,163,100,30);
        p2.setForeground(Color.WHITE);
        myLabel.add(p2);

        t1 = new JTextField(10);
        t1.setBounds(356,120,214,30);
        t1.setBackground(Color.WHITE);
        t1.setForeground(Color.BLACK);
        myLabel.add(t1);

        t2 = new JPasswordField(10);
        t2.setBounds(356,208,214,30);
        t2.setBackground(Color.WHITE);
        t2.setForeground(Color.BLACK);
        myLabel.add(t2);

        frame = new JFrame("Login");
        frame.add(myLabel);
        frame.setSize(650,450);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        JButton b = (JButton) e.getSource();
        try {
            conn c1 = new conn();
            String u = t1.getText();
            String v = t2.getText();
            String q = "select * from login where username='" + u + "'and password='" + v + "'";
            ResultSet rs = c1.s.executeQuery(q); // query execute
            if (rs.next()) {
                new project().setVisible(true);
                frame.setVisible(false);
            } else if (b == b3) {
                new password().setVisible(true);
                frame.setVisible(false);
            } else {
                throw new customexception();
            }
        } catch (SQLException ee) {
            ee.printStackTrace();
        } catch (customexception ex) {
            ex.printStackTrace();
        }
    }


    public static void main(String[] args){
        new login();
    }
}

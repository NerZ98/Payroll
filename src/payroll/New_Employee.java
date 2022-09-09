package payroll;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class New_Employee extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6, l7;
    JTextField t1, t3, t4, t5, t6, t7;
    JButton b1, b2;
    Choice c1;

    New_Employee() {

        super("New Employee");
        setSize(600, 650);
        setLocation(600, 20);

        JPanel p1 = new JPanel();
        p1.setBackground(Color.BLACK);

        p1.setLayout(new GridLayout(8, 2, 10, 40));

        l1 = new JLabel("Name");
        l1.setForeground(Color.WHITE);
        t1 = new JTextField(15);
        /*t1.setBackground(Color.BLACK);
        t1.setForeground(Color.RED);*/
        p1.add(l1);
        p1.add(t1);

        c1 = new Choice();
        c1.add("Male");
        c1.add("Female");
        c1.add("Others");
        c1.setBackground(Color.WHITE);
        c1.setForeground(Color.BLACK);

        l2 = new JLabel("Gender");
        l2.setForeground(Color.white);
        p1.add(l2);
        p1.add(c1);

        l3 = new JLabel("Address");
        l3.setForeground(Color.WHITE);
        t3 = new JTextField(15);
        p1.add(l3);
        p1.add(t3);

        l4 = new JLabel("State");
        l4.setForeground(Color.WHITE);
        t4 = new JTextField(15);
        p1.add(l4);
        p1.add(t4);

        l5 = new JLabel("City");
        l5.setForeground(Color.white);
        t5 = new JTextField(15);
        p1.add(l5);
        p1.add(t5);

        l6 = new JLabel("Email");
        l6.setForeground(Color.WHITE);
        t6 = new JTextField(15);
        p1.add(l6);
        p1.add(t6);

        l7 = new JLabel("Phone");
        l7.setForeground(Color.WHITE);
        t7 = new JTextField(15);
        p1.add(l7);
        p1.add(t7);

        b1 = new JButton("Submit");
        b2 = new JButton("Cancel");
        p1.add(b1);
        p1.add(b2);

        b1.addActionListener(this);
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b2.addActionListener(this);
        b2.setBackground(Color.WHITE);
        b2.setForeground(Color.BLACK);
        add(p1);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        JButton b = (JButton) ae.getSource();
        String n = t1.getText();
        String g = c1.getSelectedItem();
        String a = t3.getText();
        String s = t4.getText();
        String c = t5.getText();
        String e = t6.getText();
        String p = t7.getText();

        String qry = "insert into employee values(null,'"+n+"','"+g+"','"+a+"','"+s+"','"+c+"','"+e+"','"+p+"')";

        try{
            conn c1 = new conn();
            c1.s.executeUpdate(qry);
            if (b == b1) {
                JOptionPane.showMessageDialog(null,"Employee Created");
                this.setVisible(false);
            } else {
                this.setVisible(false);
            }

        }
        catch(Exception ee){
                ee.printStackTrace();
        }
    }

    public static void main(String s[])
    {
        new New_Employee().setVisible(true);
    }
}

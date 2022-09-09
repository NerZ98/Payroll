package payroll;

import javax.swing.*;

class customexception extends Exception
{

    public customexception() {
        JOptionPane.showMessageDialog(null,"Invalid login");

    }
}

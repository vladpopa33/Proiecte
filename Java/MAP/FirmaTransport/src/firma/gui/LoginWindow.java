package firma.gui;

import firma.ctrl.FirmaCtrl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import static firma.gui.UtileGUI.*;
import firma.FirmaException;

/**
 * Created by IntelliJ IDEA.
 * User: grigo
 * Date: Nov 17, 2011
 * Time: 12:42:05 AM
 */
public class LoginWindow extends JFrame {
    private JTextField user;
    private JPasswordField passwd;
    private JButton login, cancel;
    private FirmaCtrl firma;
   public LoginWindow(String title, FirmaCtrl firma) {
        super(title);
        this.firma = firma;
        add(creeazaLogin());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private JPanel creeazaLogin() {
       JPanel pan=new JPanel();
        pan.setLayout(new GridLayout(3,2));
        pan.add(putInPanel(new JLabel("Utilizator:")));
        pan.add(putInPanel(user=new JTextField(10)));
        pan.add(putInPanel(new JLabel("Parola:")));
        pan.add(putInPanel(passwd=new JPasswordField(10)));
        passwd.setEchoChar('*');
        pan.add(putInPanel(login=new JButton("Login")));
        pan.add(putInPanel(cancel=new JButton("Cancel")));
        ActionListener al=new ButoaneListener();
        login.addActionListener(al);
        cancel.addActionListener(al);
        return pan;
    }

    private class ButoaneListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==login){
                String userId=user.getText();
                char[] parola=passwd.getPassword();
                try{
                    firma.login(userId,parola);
                    LoginWindow.this.dispose();
                }catch(FirmaException ex){
                    JOptionPane.showMessageDialog(LoginWindow.this,ex.getMessage()+"!","Eroare login", JOptionPane.ERROR_MESSAGE);
                    passwd.setText("");
                }
                return;
            }
            //s-a ales cancel
            System.exit(0);

        }
    }
}

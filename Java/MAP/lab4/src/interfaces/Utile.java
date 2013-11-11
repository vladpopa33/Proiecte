package interfaces;
import javax.swing.*;
public class Utile{
    public static JPanel putInPanel(JComponent c){
        JPanel pan=new JPanel();
        pan.add(c);
        return pan;
    }
}
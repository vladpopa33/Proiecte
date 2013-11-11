package interfaces;
import javax.swing.*;
import domain.*;
import java.awt.*;
public class Meniu extends JFrame{
	public Meniu(Produse l){
	super("Produse:");
	JPanel window = new JPanel();
	JPanel panou=new JPanel(new GridLayout(l.length(),1));
	panou.setPreferredSize(new Dimension(250,30*l.length()));
	//window.setSize(400, 300);
	//panou.setSize(400, 300);
	JRadioButton[] buton=new JRadioButton[l.length()];
	for(int i=0;i<l.length();i++)
		panou.add(buton[i]=new JRadioButton(l.get_nume(i)));
	panou.setBorder(BorderFactory.createTitledBorder("Produse:"));
	//for(int i=0;i<l.length();i++)
	//	if(buton[i].isSelected()){
			//buton[i].	
			//JTextField user;
			/*JPanel window1 = new JPanel();
			JPanel panou1=new JPanel(new GridLayout(3,1));
			panou.setPreferredSize(new Dimension(250,30*l.length()));
			//JPanel panou1=new JPanel();
			//panou1.setLayout(new GridLayout(3,2));
			panou1.add(new JLabel("User:"));
			panou1.add(Utile.putInPanel(new JTextField(10)));
			panou1.add(Utile.putInPanel(new JButton("Login")));
			panou1.add(Utile.putInPanel(new JButton("Cancel")));
			window1.add(panou1);
			getContentPane().add(window1);
			window1.setSize(300,45*l.length());
	        window1.setLocation(300,100);
	        window1.setVisible(true);*/
		}
			
			
	//window.add(panou);
	//getContentPane().add(window);
	//setDefaultCloseOperation(EXIT_ON_CLOSE);
	//setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	
	
	}
		
//}

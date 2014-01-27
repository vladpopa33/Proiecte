package examen;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Users {
	private ArrayList<User> lista=new ArrayList<User>();
	Connection con;
	
	public Users(){
		String Driver="com.mysql.jdbc.Driver";
		try{
			Class.forName(Driver).newInstance();
			con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/pw","root", "");
			Statement simpleStatement=(Statement) con.createStatement();
			ResultSet rs=simpleStatement.executeQuery("SELECT * FROM pw.members");			
			while(rs.next()){
				User u=new User(rs.getString("username"),rs.getString("password"));
				lista.add(u);
			}
			lista.add(null);
		}catch(Exception e){
			System.err.println(e);
		}
	}
	
	public boolean exists(String u, String p){
		boolean ok=false;
		for(int i=0;i<lista.size()-1;i++)
			if(lista.get(i).nume.equals(u)&&lista.get(i).parola.equals(p))
				ok=true;
		return ok;
	}
	/*public void add_form(User c){
		lista.add(lista.size()-1, c);
		try {
			PreparedStatement preparedStatement=(PreparedStatement) con.prepareStatement("INSERT INTO pw.utilizatori VALUES(?,?,?)");
			preparedStatement.setString(1, c.nume);
			preparedStatement.setString(2, c.mail);
			preparedStatement.setString(3, c.mesaj);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
		}
	}
	public void validate_form(int i, User c){
		lista.set(i, c);
		try {
			PreparedStatement preparedStatement=(PreparedStatement) con.prepareStatement("");
			preparedStatement.setString(1, c.nume);
			preparedStatement.setString(2, c.mail);
			preparedStatement.setString(3, c.mesaj);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
		}
	}
	
	public boolean delete_form(String mesaj){
		int ok=-1;
		for(int i=0;i<lista.size()-1;i++)
			if(lista.get(i).mesaj.equals(mesaj))
				ok=i;
		if(ok>-1){
			lista.remove(ok);
			try {
				PreparedStatement preparedStatement=(PreparedStatement) con.prepareStatement("DELETE FROM pw.utilizatori WHERE nume=?");
				preparedStatement.setString(1, mesaj);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				System.err.println(e);
			}
			return true;
		}
		return false;
	}
	*/
	public int length(){
		return lista.size()-1;
	}
	public User get_nume(int i){
		return lista.get(i);
	}
	public String toString(){
		String af="";
		for(int i=0;i<lista.size()-1;i++)
			af=af+lista.get(i).nume+"\n";
		return af;
			
	}
	
}

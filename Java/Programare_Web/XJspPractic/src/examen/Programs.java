package examen;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Programs {
	private ArrayList<Program> lista=new ArrayList<Program>();
	Connection con;
	public Programs(){
		String Driver="com.mysql.jdbc.Driver";
		try{
			Class.forName(Driver).newInstance();
			con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/pw","root", "");
			Statement simpleStatement=(Statement) con.createStatement();
			ResultSet rs=simpleStatement.executeQuery("SELECT * FROM pw.calendar");			
			while(rs.next()){
				Program p=new Program(rs.getString("user"),rs.getString("data"),rs.getString("ora"),rs.getString("durata"),rs.getString("descriere"));
				lista.add(p);
			}
			lista.add(null);
		}catch(Exception e){
			System.err.println(e);
		}

	}

	public void add(String n,String d, String o, String du, String de){
		Program p=new Program(n,d,o,du,de);
		lista.add(lista.size()-1, p);
		try {
			PreparedStatement preparedStatement=(PreparedStatement) con.prepareStatement("INSERT INTO pw.calendar VALUES(?,?,?,?,?)");
			preparedStatement.setString(1, n);
			preparedStatement.setString(2, p.data);
			preparedStatement.setString(3, p.ora);
			preparedStatement.setString(4, p.durata);
			preparedStatement.setString(5, p.descriere);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
		}
	}
	
	public void edit(int i,String n,String d, String o, String du, String de){
		Program p=new Program(n,d,o,du,de);
		lista.set(i, p);
		try {
			PreparedStatement preparedStatement=(PreparedStatement) con.prepareStatement("UPDATE pw.calendar SET durata=?, descriere=? WHERE user=? AND data=? AND ora=?");
			preparedStatement.setString(3, n);
			preparedStatement.setString(4, p.data);
			preparedStatement.setString(5, p.ora);
			preparedStatement.setString(1, p.durata);
			preparedStatement.setString(2, p.descriere);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
		}
	}
	
	public void delete(int i, String n){
		try {
			lista.remove(i);
			Statement simpleStatement=(Statement) con.createStatement();
			ResultSet rs=simpleStatement.executeQuery("SELECT * FROM pw.calendar");	
			int j=0;
			String data="",ora="";
			while(rs.next()){
				if(j==i){
					data=rs.getString("data");
					ora=rs.getString("ora");
				}
				j++;
			}
			PreparedStatement preparedStatement=(PreparedStatement) con.prepareStatement("DELETE FROM pw.calendar WHERE user=? AND data=? AND ora=?");		
			preparedStatement.setString(1, n);
			preparedStatement.setString(2, data);
			preparedStatement.setString(3, ora);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
		}
	}
	
	public String get(String username){
		String x="<table><tr><th>   </th><th>Data</th><th>Ora de inceput</th><th>Durata</th><th>Descriere</th></tr>";
		for(int i=0;i<lista.size()-1;i++)
			if(lista.get(i).nume.equals(username))
				x=x+"<tr onclick='functie("+i+")'><td>"+i+".</td><td><input type='text' name='data"+i+"' value='"+lista.get(i).data+"' readonly></td><td><input type='text' name='ora"+i+"' value='"+lista.get(i).ora+"' readonly></td><td><input type='text' name='durata"+i+"' value='"+lista.get(i).durata+"'></td><td><input type='text' name='descriere"+i+"' value='"+lista.get(i).descriere+"'></td></tr>";
		return x+"</table>";
		
	}
}

package pdpj;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

//import controller.Controller;

public class Masini {
	private ArrayList<Masina> lista=new ArrayList<Masina>();
	Connection con;
	public Masini(){
		
		String driver="com.mysql.jdbc.Driver";
		//String url="jdbc:mysql://localhost:3306/mysql”,”root”, “mclarenf1”";
		try{
			Class.forName(driver).newInstance();
			con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/PDPJ","root", "mclarenf1");
			Statement simpleStatement=(Statement) con.createStatement();
			//PreparedStatement preparedStatement("");
			ResultSet rs=simpleStatement.executeQuery("SELECT * FROM PDPJ.Masini");
			while(rs.next()){
				Masina m=new Masina(rs.getString("marca"),rs.getString("culoare"),rs.getString("motor"),rs.getString("viteza_maxima"),rs.getString("pret"),rs.getString("imagine"));
				lista.add(m);
			}
			lista.add(null);
		}catch(Exception e){
			System.err.println(e);
		}
	}
	public void add_car(Masina c){
		lista.add(lista.size()-1, c);
		try {
			PreparedStatement preparedStatement=(PreparedStatement) con.prepareStatement("INSERT INTO PDPJ.Masini VALUES(?,?,?,?,?,?)");
			preparedStatement.setString(1, c.marca);
			preparedStatement.setString(2, c.culoare);
			preparedStatement.setString(3, c.motor);
			preparedStatement.setString(4, c.viteza_maxima);
			preparedStatement.setString(5, c.pret);
			preparedStatement.setString(6, c.imagine);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
		}
	}
	public void edit_car(int i, Masina c){
		lista.set(i, c);
		try {
			PreparedStatement preparedStatement=(PreparedStatement) con.prepareStatement("UPDATE PDPJ.Masini SET marca=?, culoare=?, pret=? WHERE imagine=?;");
			preparedStatement.setString(1, c.marca);
			preparedStatement.setString(2, c.culoare);
			preparedStatement.setString(3, c.motor);
			preparedStatement.setString(4, c.imagine);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
		}
	}
	public boolean delete_car(String marca){
		int ok=-1;
		for(int i=0;i<lista.size()-1;i++)
			if(lista.get(i).marca.equals(marca))
				ok=i;
		if(ok>-1){
			lista.remove(ok);
			//LOG.debug(c.toString());
			try {
				PreparedStatement preparedStatement=(PreparedStatement) con.prepareStatement("DELETE FROM PDPJ.Masini WHERE marca=?");
				preparedStatement.setString(1, marca);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.println(e);
			}
			return true;
		}
		return false;
	}
	public int length(){
		return lista.size()-1;
	}
	public Masina get_car(int i){
		return lista.get(i);
	}
	public String toString(){
		String af="";
		for(int i=0;i<lista.size()-1;i++)
			af=af+lista.get(i).marca+"\n";
		return af;
			
	}
	
}

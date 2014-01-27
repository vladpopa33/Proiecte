package model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Oferte {
	Logger LOG = Logger.getLogger(server.ServerOperator.class);
	private ArrayList<Oferta> lista=new ArrayList<Oferta>();
	Connection con;
	public Oferte(){
		String driver="com.mysql.jdbc.Driver";
		//String url="jdbc:mysql://localhost:3306/mysql”,”root”, “mclarenf1”";
		try{
			Class.forName(driver).newInstance();
			con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/PDPJ","root", "mclarenf1");
			Statement simpleStatement=(Statement) con.createStatement();
			//PreparedStatement preparedStatement("");
			ResultSet rs=simpleStatement.executeQuery("SELECT * FROM PDPJ.Oferte");
			LOG.debug("Reading from database...");
			while(rs.next()){
				Oferta m=new Oferta(rs.getString("tara"),rs.getString("pret"),rs.getString("transport"));
				lista.add(m);
				LOG.debug(m.toString());
			}
			lista.add(null);
			LOG.debug("Done!");
		}catch(Exception e){
			LOG.debug(e);
		}
	}
	public void add_oferta(Oferta c){
		lista.add(lista.size()-1, c);
		try {
			PreparedStatement preparedStatement=(PreparedStatement) con.prepareStatement("INSERT INTO PDPJ.Oferte VALUES(?,?,?)");
			preparedStatement.setString(1, c.destinatie);
			preparedStatement.setString(2, c.pret);
			preparedStatement.setString(3, c.transport);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LOG.debug(e);
		}
	}
	public int length(){
		return lista.size();
	}
	public Oferta get_oferta(int i){
		return lista.get(i);
	}
}

package repository;
//package Serialize;

import java.io.*;

import domain.Lista;
public class Serialize<T> implements Serializable{
	private static final long serialVersionUID = 1L;
	public void printSerializabil(Lista<T> l, String numefis){
		ObjectOutputStream out=null;
		try{
			out=new ObjectOutputStream(new FileOutputStream(numefis));
			out.writeObject(l);
		} catch (IOException e) {
			System.err.println("Eroare serializare "+e );
		} finally {
			if (out!=null)
				try {
					out.close();
				} catch (IOException e) {
					System.err.println("Eroare "+e);
				}
		}
	}
	@SuppressWarnings("unchecked")
	public Lista<T> citesteSerializabil(String numefis){
		Lista<T> rez=null;
		ObjectInputStream in=null;
		try{
			in=new ObjectInputStream(new FileInputStream(numefis));
			rez=(Lista<T>)in.readObject();
		} catch (IOException e) {
			System.err.println("Eroare deserializare"+e);
		} catch (ClassNotFoundException e) {
			System.err.println("Eroare deserializare "+e);
		}finally{
			if (in!=null)
				try {
					in.close();
				}catch (IOException e) {System.err.println("Eroare "+e); }
		}
		return rez;
	}
}

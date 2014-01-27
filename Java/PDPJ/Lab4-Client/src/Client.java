import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Client {

	/**
	 * @param args
	 */
	private static final Logger LOG = Logger.getLogger(Client.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicConfigurator.configure();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
			System.out.println("Alege una din urmatoarele optiuni:");
			String op="";
			while(op.equals("3")){
				System.out.println("Alege una din urmatoarele optiuni:");
			}
			DatagramSocket datagramSocket=new DatagramSocket(4566);
			InetAddress address=InetAddress.getByName("127.0.0.1");
			String raspuns="";
			String msg="START";
			DatagramPacket packet=new DatagramPacket(msg.getBytes(),msg.length(),address,1234);
			LOG.info("Trimit mesaj"+msg);
			datagramSocket.send(packet);
			byte[] buffer=new byte[5000];
			packet=new DatagramPacket(buffer,buffer.length);
			datagramSocket.receive(packet);
			ByteArrayInputStream bais=new ByteArrayInputStream(buffer);
			ObjectInputStream ois=new ObjectInputStream(bais);
			raspuns=(String) ois.readObject();
			LOG.info(raspuns);
			bais.close();
			ois.close();
			///////
			msg="VIEW";
			packet=new DatagramPacket(msg.getBytes(),msg.length(),address,1234);
			LOG.info("Trimit mesaj"+msg);
			datagramSocket.send(packet);
			buffer=new byte[5000];
			packet=new DatagramPacket(buffer,buffer.length);
			datagramSocket.receive(packet);
			bais=new ByteArrayInputStream(buffer);
			ois=new ObjectInputStream(bais);
			raspuns=(String) ois.readObject();//deserializare
			LOG.info(raspuns);
			bais.close();
			ois.close();
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOG.error("",e);
		}
	}

}

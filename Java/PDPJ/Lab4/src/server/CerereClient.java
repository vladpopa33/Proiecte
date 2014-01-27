package server;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

import org.apache.log4j.Logger;

import controller.Controller;

public class CerereClient implements Runnable{
	private static final Logger LOG = Logger.getLogger(ServerOperator.class);
	private DatagramPacket packet;
	private Controller ctrl;
	public CerereClient(DatagramPacket d,Controller ctrl){
		this.packet=d;
		this.ctrl=ctrl;
	}
	public void run(){
		try {
			byte[] b=new byte[5000];
			DatagramSocket datagramSocket=new DatagramSocket();
			InetAddress address=packet.getAddress();
			String data="";
			if(!data.equals("EXIT")){
				data=new String(packet.getData()).trim();
				LOG.debug(data);
				ByteArrayOutputStream baos=new ByteArrayOutputStream();
				ObjectOutputStream oos=new ObjectOutputStream(baos);
				String message="";
				if(data.equals("START"))
					message="Bine ati venit! Dati comanda!";
				if(data.equals("VIEW"))
					message=ctrl.getoferte();
				oos.writeObject(message);//serializare
				oos.flush();
				//byte[] bytes=baos.toByteArray();
				byte[] bytes=baos.toByteArray();
				packet=new DatagramPacket(bytes,bytes.length,address,4566);
				datagramSocket.send(packet);
				LOG.info(message);
				baos.close();
				oos.close();
			}
			closeStreams(datagramSocket);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOG.error("",e);
		}
	}
	private void closeStreams(DatagramSocket ds){
		try {
			if(ds!=null)
				ds.close();
	;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				LOG.error(e);
			}
		
	}
}

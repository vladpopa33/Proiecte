package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;

import model.Oferte;

import org.apache.log4j.Logger;

import controller.Controller;

public class ServerClient extends Thread{
	private static final Logger LOG = Logger.getLogger(ServerClient.class);
	private DatagramSocket svsk;
	private Controller ctrl;
	int port;
	public ServerClient(int port,Controller ctrl){
		this.port=port;
		this.ctrl=ctrl;
	}
	public void run(){
		try {
			svsk=new DatagramSocket(this.port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOG.error(e);
		}
		LOG.debug("Serverul a pornit la portul "+this.port);
		while(true){
			try {
				byte[] buffer=new byte[5000];
				DatagramPacket packet=new DatagramPacket(buffer,buffer.length);
			    svsk.receive(packet);
				LOG.debug("S-a conectat un client");
				new Thread(new CerereClient(packet,this.ctrl)).start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				LOG.error(e);
			}
		}
	}
}


package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;

import controller.Controller;

public class ServerOperator extends Thread{
	private static final Logger LOG = Logger.getLogger(ServerOperator.class);
	private ServerSocket svsk;
	private Controller ctrl;
	int port;
	public ServerOperator(int port,Controller ctrl){
		this.port=port;
		this.ctrl=ctrl;
	}
	public void run(){
		try {
			svsk=new ServerSocket(this.port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOG.error(e);
		}
		LOG.debug("Serverul a pornit la portul "+this.port);
		while(true){
			try {
				Socket socket=svsk.accept();
				LOG.debug("S-a conectat un client");
				new Thread(new CerereOperator(socket,this.ctrl)).start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				LOG.error(e);
			}
		}
	}
}

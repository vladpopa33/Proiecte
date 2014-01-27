package server;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

import controller.Controller;

public class CerereOperator implements Runnable{
	private static final Logger LOG = Logger.getLogger(ServerOperator.class);
	private Socket skt;
	private Controller ctrl;
	public CerereOperator(Socket s,Controller ctrl){
		this.skt=s;
		this.ctrl=ctrl;
	}
	public void run(){
		try {
			BufferedReader in=new BufferedReader(new InputStreamReader(skt.getInputStream()));
			ObjectOutputStream out=new ObjectOutputStream(skt.getOutputStream());
			LOG.debug("Sunt procesata!");
			String tara=in.readLine();
			LOG.debug("Am primit tara!"+tara);
			String pret=in.readLine();
			LOG.debug("Am primit pret!"+pret);
			String transport=in.readLine();
			LOG.debug("Am primit transport!"+transport);
			out.writeObject("Oferta a fost adaugata!");
			ctrl.addoferta(tara, pret, transport);
			closeStreams(in,out);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOG.error(e);
		}
	}
	private void closeStreams(Closeable in,Closeable out){
		try {
			if(in!=null)
				in.close();
			if(out!=null)
				out.close();
			if(skt!=null)
				skt.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				LOG.error(e);
			}
		
	}
}

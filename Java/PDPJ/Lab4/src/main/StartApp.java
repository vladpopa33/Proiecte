package main;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import controller.Controller;

import server.ServerOperator;

//import controller.Controller;
public class StartApp {

	/**
	 * @param args
	 */
	private static final Logger LOG = Logger.getLogger(StartApp.class);
	public static void main(String[] args) {
		BasicConfigurator.configure();
		LOG.info("lol");
		Controller ctrl=new Controller();
		//ServerOperator o=new ServerOperator(4568);
		/*o.start();
		try {
			o.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		// TODO Auto-generated method stub
		
	}

}

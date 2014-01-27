//import model.Masini;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import controller.Controller;


public class start {

	/**
	 * @param args
	 */
	private static final Logger LOG = Logger.getLogger(Controller.class);
	public static void main(String[] args) {
		BasicConfigurator.configure();
		LOG.debug("Start");
		Controller ctrl=new Controller();
		ctrl.start();
		try {
			ctrl.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			LOG.debug(e1);
		}
		
		// TODO Auto-generated method stub
		//System.out.println("Hello world!");
		try {
			/*view window = new view();
			window.open();*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

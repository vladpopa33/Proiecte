import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import static java.util.concurrent.TimeUnit.*;

public class Lab2 {

	private static final TimeUnit SECONDS = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("asd");
		final threaddaemon d=new threaddaemon(Integer.parseInt(args[0]));
		d.start();
		try {
			
			/*ScheduledExecutorService scheduler=Executors.newScheduledThreadPool(7);
			scheduler.schedule(new Runnable() {
			       public void run() {System.exit(0);}}, 1, SECONDS);*/
			d.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 /*
		ScheduledExecutorService scheduler=Executors.newScheduledThreadPool(1);
		final ScheduledFuture<?> timeout =
			       scheduler.schedule(new Runnable() {
				       public void run() {d.start();}},10, 10, SECONDS);
		scheduler.schedule(new Runnable() {
		       public void run() {timeout.cancel(true);}}, 3, SECONDS);
		*/
		/*ExecutorService executor = Executors.newSingleThreadExecutor();
		try {
			d.join();
			synchronized (executor) {
			executor.wait(100);
			}
			System.exit(0);
			//executor.wait(1000);
			executor.shutdown();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		 /*class BeeperControl {
			   private final ScheduledExecutorService scheduler =
			     Executors.newScheduledThreadPool(1);
	
			   public void beepForAnHour() {
			     final Runnable beeper = new Runnable() {
			       public void run() { System.out.println("beep"); }
			     };
			     final ScheduledFuture<?> beeperHandle =
			       scheduler.scheduleAtFixedRate(beeper, 10, 10, SECONDS);
			     scheduler.schedule(new Runnable() {
			       public void run() { beeperHandle.cancel(true); }
			     }, 60 * 60, SECONDS);
			   }
			 }*/
	}

}

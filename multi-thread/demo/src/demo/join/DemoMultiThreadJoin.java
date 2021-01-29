package demo.join;

public class DemoMultiThreadJoin {
	
	public static void main(String[] args) {
		
		CountingThread countingThread = new CountingThread();
		SumNumberThread sumNumberThread = new SumNumberThread();
		
		try {
			countingThread.start();
			sumNumberThread.start();
			
			countingThread.join();
		}
		catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.err.println("Main down");
	}
}

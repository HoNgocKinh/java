package demo.join;

import demo.common.CustomThread;

public class SumNumberThread extends CustomThread {
	
	public SumNumberThread() {
		
		Runnable runnable = () -> {
			long sum = 0;
			try {
				for (int i = 0; i < 10; i++) {
					sum += i;
					System.out.println("SumNumnerThread: " + sum);
					Thread.sleep(600);
				}
				System.out.println("SumNumberThread down!");
			}
			catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		};
		super.runnable = runnable;
	}
}

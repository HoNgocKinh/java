package demo.join;

import demo.common.CustomThread;

public class CountingThread extends CustomThread {
	
	public CountingThread() {
		
		Runnable runnable = () -> {
			
			try {
				for (int i = 0; i < 13; i++) {
					System.out.println("CountingThead: " + i);
					Thread.sleep(2000);
				}
				System.out.println("CountingThread down!");
			}
			catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		};
		
		super.runnable = runnable;
	}
}


package demo.common;

import java.util.Map;

public class CustomThread extends Thread {
	
	protected Map<String, Object> data;
	protected Runnable runnable;
	
	public CustomThread() {
		
	}
	
	public CustomThread(Runnable runnable) {
		this.runnable = runnable;
	}
	
	public Map<String, Object> getData() {
		return data;
	}
	
	@Override
	public void run() {
		this.runnable.run();
	}
}

package creational.objectpools.taxi_agent_manager;

public class TaxiNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public TaxiNotFoundException(String message) {
		System.out.println(message);
	}
}

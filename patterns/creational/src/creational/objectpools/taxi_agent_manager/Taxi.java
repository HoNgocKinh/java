package creational.objectpools.taxi_agent_manager;

public class Taxi {
	
	private String name;
	
	public Taxi(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Taxi [name=" + name + "]";
	}
}

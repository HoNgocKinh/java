import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class Client {

	public static void main(String[] args) {
		
		try {
			// local variables args... 0 => host, 1 => port, 2 => nameFn, 3 => fnValue
			int port = Integer.parseInt(args[1]);
			String host = args[0];
			String functionName = args[2];
			String functionValue = "";
			
			Registry registry = LocateRegistry.getRegistry(host, port);
			
			Exercise04 stub = (Exercise04) registry.lookup("Exercise04");
//			System.out.println(stub);
			
			switch (functionName) {
				case("-findbyfirstname"): 
					functionValue = args[3];
					boolean isFoundFirstName = stub.findByFirstName(functionValue);
					System.out.println("FirstName " + functionValue + "is found - " + isFoundFirstName);
				break;
				
				case("-countbylastname"):
					functionValue = args[3];
					int countLastName = stub.countByLastName(functionValue);
					System.out.println("LastName " + functionValue + "is counted: " + countLastName);
					break;
					
				case("-findbyid"):
					functionValue = args[3];
					boolean isFoundId = stub.findById(functionValue);
					System.out.println("Id " + functionValue + "is found - " + isFoundId);
				break;
					
				case("-getMeanAge"):
					float meanAge = stub.getMeanAge();
					System.out.println("Mean Age: " + meanAge);
				break;
					
				case("-getMinBD"):
					int minBD = stub.getMinBD();
					System.out.println("Min BirthYear: " + minBD);
				break;
				
				case("-getMaxBD"):
					int maxBD = stub.getMaxBD();
					System.out.println("Max BirthYear: " + maxBD);
				break;
				
				case("-countbygender"):
					functionValue = args[3];
					int countGender = stub.countByGender(functionValue);
					System.out.println("Gender " + functionValue + " counted: " + countGender);
				break;
				
				case("-getInfo"):
					functionValue = args[3];
					List<Person> persons = stub.getInfo(functionValue);
					System.out.println("Address " + functionValue + " have/has: " + persons);
				break;
				
				case("-countbystate"):
					functionValue = args[3];
					int countPersonsInState = stub.countByState(functionValue);
					System.out.println("State " + functionValue + " have/has : " + countPersonsInState + " persons");
				default:
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
}

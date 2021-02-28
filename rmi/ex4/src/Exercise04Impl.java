import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Exercise04Impl implements Exercise04 {

	private List<Person> persons = new ArrayList<Person>();
	
	public Exercise04Impl() {
		// import data.csv file
		importDataFile();
	}
	
	private void importDataFile() {
		
		try (BufferedReader br = new BufferedReader(new FileReader(new File("data.csv")))) {
			String[] lines = br.lines().toArray(String[]::new);
			for (int i = 1; i < lines.length; i++) {
				
				String address = lines[i].split("\"")[1];
				String[] personInfos = lines[i].split("\\,\"")[0].split(",");
				
				Person person = new Person();
				person.setAddress(address);
				person.setFullName(personInfos[0]);
				person.setId(personInfos[1]);
				person.setGender(personInfos[2]);
				person.setBirthYear(personInfos[3]);
				
				persons.add(person);
			}
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public boolean findByFirstName(String firstname) throws RemoteException {
		return persons.stream().parallel().anyMatch(p -> p.getFullName().indexOf(firstname) != -1);
	}

	@Override
	public int countByLastName(String lastname) throws RemoteException {
		return (int) persons.stream().parallel().filter(p -> p.getFullName().indexOf(lastname) != -1).count();
	}

	@Override
	public boolean findById(String id) throws RemoteException {
		return persons.stream().parallel().anyMatch(p -> p.getId().equals(id));
	}

	@Override
	public float getMeanAge() throws RemoteException {
		return (float) persons.stream().parallel()
				.mapToInt(p -> Integer.parseInt(p.getBirthYear()))
				.average()
				.getAsDouble();
	}

	@Override
	public int getMinBD() throws RemoteException {
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public int getMaxBD() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(persons);
		return 0;
	}

	@Override
	public int countByGender(String gender) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(persons);
		return 0;
	}

	@Override
	public List<Person> getInfo(String address) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(persons);
		return null;
	}

	@Override
	public int countByState(String stateName) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(persons);
		return 0;
	}
	
}

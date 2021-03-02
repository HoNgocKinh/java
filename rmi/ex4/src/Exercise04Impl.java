import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Exercise04Impl implements Exercise04 {

	private List<Person> persons = new ArrayList<Person>();
	
	public Exercise04Impl() {
		// import data.csv file
		importDataFile();
	}
	
	private void importDataFile() {
		
		try (BufferedReader br = new BufferedReader(new FileReader(new File("src\\data.csv")))) {
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
		return persons.stream().parallel()
				.mapToInt(p -> Integer.parseInt(p.getBirthYear()))
				.min()
				.getAsInt();
	}

	@Override
	public int getMaxBD() throws RemoteException {
		// TODO Auto-generated method stub
		return persons.stream().parallel()
				.mapToInt(p -> Integer.parseInt(p.getBirthYear()))
				.max()
				.getAsInt();
	}

	@Override
	public int countByGender(String gender) throws RemoteException {
		// TODO Auto-generated method stub
		return (int) persons.stream().parallel()
				.filter(p -> p.getGender().equals(gender))
				.count();
	}

	@Override
	public List<Person> getInfo(String address) throws RemoteException {
		// TODO Auto-generated method stub
		return persons.stream().parallel().filter(p -> p.getAddress().equals(address)).collect(Collectors.toList());
	}

	@Override
	public int countByState(String stateName) throws RemoteException {
		// TODO Auto-generated method stub
		 return (int)persons.stream().parallel().peek(p -> System.out.println(getState(p.getAddress()))).filter(p -> mapperState(getState(p.getAddress())) == mapperState(stateName)).count();
	}
	private String getState(String address) {
		String[] parts =  address.split(",")[1].trim().split("\s+");
		return parts[parts.length - 2];
	}
	
	private int mapperState(String state) {
		
		switch (state) {
			case("United States of America"): case("US"):
				return 0;
			case("Alabama"): case("AL"):
				return 1;
			case("Alaska"): case("AK"):
				return 2;	
			case("Arizona"): case("AZ"):
				return 3;
			case("Arkansas"): case("AR"):
				return 4;
			case("California"): case("CA"):
				return 5;
			case("Colorado"): case("CO"):
				return 6;
			case("Connecticut"): case("CT"):
				return 7;
			case("Delaware"): case("DE"):
				return 8;
			case("District of Columbia"): case("DC"):
				return 9;
			case("Florida"): case("FL"):
				return 10;
			case("Georgia"): case("GA"):
				return 11;
			case("Hawaii"): case("HI"):
				return 12;
			case("Idaho"): case("ID"):
				return 13;
			case("Illinois"): case("IL"):
				return 14;
			case("Indiana"): case("IN"):
				return 15;
			case("Iowa"): case("IA"):
				return 16;
			case("Kansas"): case("KS"):
				return 17;
			case("Kentucky"): case("KY"):
				return 18;
			case("Louisiana"): case("LA"):
				return 19;
			case("Maine"): case("ME"):
				return 20;
			case("Maryland"): case("MD"):
				return 21;
			case("Massachusetts"): case("MA"):
				return 22;
			case("Michigan"): case("MI"):
				return 23;
			case("Minnesota"): case("MN"):
				return 24;
			case("Mississippi"): case("MS"):
				return 25;
			case("Missouri"): case("MO"):
				return 26;
			case("Montana"): case("MT"):
				return 27;
			case("Nebraska"): case("NE"):
				return 28;
			case("Nevada"): case("NV"):
				return 29;
			case("New Hampshire"): case("NH"):
				return 30;
			case("New Jersey"): case("NJ"):
				return 31;
			case("New Mexico"): case("NM"):
				return 32;
			case("New York"): case("NY"):
				return 33;
			case("North Carolina"): case("NC"):
				return 34;
			case("North Dakota"): case("ND"):
				return 35;
			case("Ohio"): case("OH"):
				return 36;
			case("Oklahoma"): case("OK"):
				return 37;
			case("Oregon"): case("OR"):
				return 38;
			case("Pennsylvania"): case("PA"):
				return 39;
			case("Rhode Island"): case("RI"):
				return 40;
			case("South Carolina"): case("SC"):
				return 41;
			case("South Dakota"): case("SD"):
				return 42;
			case("Tennessee"): case("TN"):
				return 43;
			case("Texas"): case("TX"):
				return 44;
			case("Utah"): case("UT"):
				return 45;
			case("Vermont"): case("VT"):
				return 46;
			case("Virginia"): case("VA"):
				return 47;
			case("Washington"): case("WA"):
				return 48;
			case("West Virginia"): case("WV"):
				return 49;
			case("Wisconsin"): case("WI"):
				return 50;
			case("Wyoming"): case("WY"):
				return 51;
			case("American Samoa"): case("AS"):
				return 52;
			case("Guam"): case("GU"):
				return 53;
			case("Northern Mariana Islands"): case("MP"):
				return 54;
			case("Puerto Rico"): case("PR"):
				return 55;
			case("U.S. Virgin Islands"): case("VI"):
				return 56;
			case("Baker Island"): case("XB"):
				return 57;
			case("Howland Island"): case("XH"):
				return 58;
			case("Jarvis Island"): case("XQ"):
				return 59;
			case("Johnston Atoll"): case("XU"):
				return 60;
			case("Kingman Reef"): case("XM"):
				return 61;
			case("Midway Islands"): case("QM"):
				return 62;
			case("Navassa Island"): case("XV"):
				return 63;
			case("Palmyra Atoll[c]"): case("XL"):
				return 64;
			case("Wake Island"): case("QW"):
				return 65;
			case("Micronesia"): case("FM"): 
				return 66;
			case("Marshall Islands"): case("MH"):
				return 67;
			case("Palau"): case("PW"): 
				return 68;
			case("U.S. Armed Forces – Americas"): case("AA"): 
				return 69;
			case("U.S. Armed Forces – Europe"): case("AE"): 
				return 70;
			case("U.S. Armed Forces – Pacific"): case("AP"): 
				return 71;
			default: 
				return -1;
		}
		
	}
	
}

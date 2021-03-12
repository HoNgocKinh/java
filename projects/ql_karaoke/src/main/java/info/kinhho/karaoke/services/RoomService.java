package info.kinhho.karaoke.services;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import info.kinhho.karaoke.assistants.DateType;
import info.kinhho.karaoke.entity.BillDetail;
import info.kinhho.karaoke.entity.Room;
import info.kinhho.karaoke.entity.RoomPrice;
import info.kinhho.karaoke.repository.RoomPriceRepository;
import info.kinhho.karaoke.repository.RoomRepository;

@Service
public class RoomService {
	
	private RoomRepository repository;
	private RoomPriceRepository roomPriceRepository;
	
	public RoomService(RoomRepository repository, RoomPriceRepository roomPriceRepository) {
		this.roomPriceRepository = roomPriceRepository;
		this.repository = repository;
	}
	
	public void createSeedRoomData() {
		
		Room roomf10 = new Room("F000","NORMAL", "EMPTY", 1);
		Room roomf11 = new Room("F001","NORMAL", "EMPTY", 1);
		Room roomf12 = new Room("F002","NORMAL", "EMPTY", 1);
		Room roomf13 = new Room("F003","NORMAL", "EMPTY", 1);
		Room roomf14 = new Room("F004","NORMAL", "EMPTY", 1);
		Room roomf15 = new Room("F005","NORMAL", "EMPTY", 1);
		Room roomf16 = new Room("F006","VIP", "EMPTY", 1);
		Room roomf17 = new Room("F007","VIP", "EMPTY", 1);
		Room roomf18 = new Room("F008","VIP", "EMPTY", 1);
		Room roomf19 = new Room("F009","VIP", "EMPTY", 1);
		
		Room roomf20 = new Room("F010","NORMAL", "EMPTY", 2);
		Room roomf21 = new Room("F011","NORMAL", "EMPTY", 2);
		Room roomf22 = new Room("F012","NORMAL", "EMPTY", 2);
		Room roomf23 = new Room("F013","NORMAL", "EMPTY", 2);
		Room roomf24 = new Room("F014","NORMAL", "EMPTY", 2);
		Room roomf25 = new Room("F015","NORMAL", "EMPTY", 2);
		Room roomf26 = new Room("F016","VIP", "EMPTY", 2);
		Room roomf27 = new Room("F017","VIP", "EMPTY", 2);
		Room roomf28 = new Room("F018","VIP", "EMPTY", 2);
		Room roomf29 = new Room("F019","VIP", "EMPTY", 2);
		
		Room roomf30 = new Room("F020","NORMAL", "EMPTY", 3);
		Room roomf31 = new Room("F021","NORMAL", "EMPTY", 3);
		Room roomf32 = new Room("F022","NORMAL", "EMPTY", 3);
		Room roomf33 = new Room("F023","NORMAL", "EMPTY", 3);
		Room roomf34 = new Room("F024","NORMAL", "EMPTY", 3);
		Room roomf35 = new Room("F025","VIP", "EMPTY", 3);
		Room roomf36 = new Room("F026","VIP", "EMPTY", 3);
		Room roomf37 = new Room("F027","VIP", "EMPTY", 3);
		Room roomf38 = new Room("F028","VIP", "EMPTY", 3);
		Room roomf39 = new Room("F029","VIP", "EMPTY", 3);
		
		repository.save(roomf10);
		repository.save(roomf11);
		repository.save(roomf12);
		repository.save(roomf13);
		repository.save(roomf14);
		repository.save(roomf15);
		repository.save(roomf16);
		repository.save(roomf17);
		repository.save(roomf18);
		repository.save(roomf19);
		
		repository.save(roomf20);
		repository.save(roomf21);
		repository.save(roomf22);
		repository.save(roomf23);
		repository.save(roomf24);
		repository.save(roomf25);
		repository.save(roomf26);
		repository.save(roomf27);
		repository.save(roomf28);
		repository.save(roomf29);
		
		repository.save(roomf30);
		repository.save(roomf31);
		repository.save(roomf32);
		repository.save(roomf33);
		repository.save(roomf34);
		repository.save(roomf35);
		repository.save(roomf36);
		repository.save(roomf37);
		repository.save(roomf38);
		repository.save(roomf39);	
	}
	
	public void createSeedPriceData() {
		
		RoomPrice roomPrice1 = new RoomPrice("NORMAL", 200000, 0, 5, "WEEKEND");
		RoomPrice roomPrice2 = new RoomPrice("NORMAL", 250000, 5, 10, "WEEKEND");
		RoomPrice roomPrice3 = new RoomPrice("NORMAL", 80000, 10, 18, "WEEKEND");
		RoomPrice roomPrice4 = new RoomPrice("NORMAL", 100000, 18, 24, "WEEKEND");
		
		RoomPrice roomPrice5 = new RoomPrice("NORMAL", 220000, 0, 5, "HOLIDAY");
		RoomPrice roomPrice6 = new RoomPrice("NORMAL", 250000, 5, 10, "HOLIDAY");
		RoomPrice roomPrice7 = new RoomPrice("NORMAL", 120000, 10, 18, "HOLIDAY");
		RoomPrice roomPrice8 = new RoomPrice("NORMAL", 150000, 18, 24, "HOLIDAY");
		
		RoomPrice roomPrice9 = new RoomPrice("NORMAL", 200000, 0, 5, "DAILY");
		RoomPrice roomPrice10 = new RoomPrice("NORMAL", 220000, 5, 10, "DAILY");
		RoomPrice roomPrice11 = new RoomPrice("NORMAL", 70000, 10, 18, "DAILY");
		RoomPrice roomPrice12 = new RoomPrice("NORMAL", 80000, 18, 24, "DAILY");
		
		
		RoomPrice roomPrice13 = new RoomPrice("VIP", 250000, 0, 5, "WEEKEND");
		RoomPrice roomPrice14 = new RoomPrice("VIP", 270000, 5, 10, "WEEKEND");
		RoomPrice roomPrice15 = new RoomPrice("VIP", 160000, 10, 18, "WEEKEND");
		RoomPrice roomPrice16 = new RoomPrice("VIP", 180000, 18, 24, "WEEKEND");
		
		RoomPrice roomPrice17 = new RoomPrice("VIP", 250000, 0, 5, "HOLIDAY");
		RoomPrice roomPrice18 = new RoomPrice("VIP", 300000, 5, 10, "HOLIDAY");
		RoomPrice roomPrice19 = new RoomPrice("VIP", 200000, 10, 18, "HOLIDAY");
		RoomPrice roomPrice20 = new RoomPrice("VIP", 220000, 18, 24, "HOLIDAY");
		
		RoomPrice roomPrice21 = new RoomPrice("VIP", 230000, 0, 5, "DAILY");
		RoomPrice roomPrice22 = new RoomPrice("VIP", 250000, 5, 10, "DAILY");
		RoomPrice roomPrice23 = new RoomPrice("VIP", 150000, 10, 18, "DAILY");
		RoomPrice roomPrice24 = new RoomPrice("VIP", 160000, 18, 24, "DAILY");
		
		roomPriceRepository.save(roomPrice1);
		roomPriceRepository.save(roomPrice2);
		roomPriceRepository.save(roomPrice3);
		roomPriceRepository.save(roomPrice4);
		roomPriceRepository.save(roomPrice5);
		roomPriceRepository.save(roomPrice6);
		roomPriceRepository.save(roomPrice7);
		roomPriceRepository.save(roomPrice8);
		roomPriceRepository.save(roomPrice9);
		roomPriceRepository.save(roomPrice10);
		roomPriceRepository.save(roomPrice11);
		roomPriceRepository.save(roomPrice12);
		roomPriceRepository.save(roomPrice13);
		roomPriceRepository.save(roomPrice14);
		roomPriceRepository.save(roomPrice15);
		roomPriceRepository.save(roomPrice16);
		roomPriceRepository.save(roomPrice17);
		roomPriceRepository.save(roomPrice18);
		roomPriceRepository.save(roomPrice19);
		roomPriceRepository.save(roomPrice20);
		roomPriceRepository.save(roomPrice21);
		roomPriceRepository.save(roomPrice22);
		roomPriceRepository.save(roomPrice23);
		roomPriceRepository.save(roomPrice24);
	}
	
	public Iterable<RoomPrice> getPrices() {
		
		return this.roomPriceRepository.findAll();
	}
	
	public Iterable<Room> getRooms() {
		
		return this.repository.findAll();
	}
	
	public RoomPrice getPrice(Long id) {
		return this.roomPriceRepository.findById(id).get();
	}
	
	public Room getRoom(Long id) {
		
		return this.repository.findById(id).get();
	}
	
	
	public Room get(String name) {
		return this.repository.findByName(name);
	}
	
	public void savePrice(RoomPrice room) {
		this.roomPriceRepository.save(room);
	}
	
	public void updatePrice(RoomPrice room) {
		this.roomPriceRepository.deleteById(room.getId());
		this.roomPriceRepository.save(room);
	}
	
	public void deletePrice(String id) {
		this.roomPriceRepository.deleteById(Long.parseLong(id));
	}
	
	public Iterable<Room> getUsed() {
		return this.repository.getUsed();
	}
	
	public Iterable<Room> getUnused() {
		
		return this.repository.getUnused();
	}
	
	public void setDefaultRoom(Room room) {
		
		room.setCustomerPhone("EMPTY");
		room.setStatus("EMPTY");
		room.setCheckIn(null);
		
		this.repository.save(room);
	}
			
	public double calculatePriceRoom(Room room, BillDetail detail) {
			
		System.out.println(this.roomPriceRepository.findAll());
		
		List<RoomPrice> prices = this.roomPriceRepository.get();
		
		int hourStart = detail.getCheckIn().getHours();
		
		long totalTime = detail.getCheckOut().getTime() - detail.getCheckIn().getTime();
		
		String typeDay = DateType.getDateType(detail.getCheckOut());
		
		Predicate<RoomPrice> sameTypeDay = (r) -> {
			return r.getTypeDay().equals(typeDay);
		};
		Predicate<RoomPrice> sameTypeRoom = r -> {
			return r.getTypeRoom().equals(room.getType());
		};
		
		Predicate<RoomPrice> betweenHour = r -> {
			return r.getCheckIn() <= hourStart && hourStart < r.getCheckOut();
		};
		
		double price = prices.stream().filter(sameTypeDay.and(sameTypeRoom).and(betweenHour)).findFirst().get().getPrice();
		
		System.out.println("Price: " + price);
		return 0;
	}
}

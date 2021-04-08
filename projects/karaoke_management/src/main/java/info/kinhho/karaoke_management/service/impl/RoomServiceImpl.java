package info.kinhho.karaoke_management.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import info.kinhho.karaoke_management.assistants.DateType;
import info.kinhho.karaoke_management.entities.BillDetail;
import info.kinhho.karaoke_management.entities.Room;
import info.kinhho.karaoke_management.entities.RoomPrice;
import info.kinhho.karaoke_management.repository.RoomPriceRepository;
import info.kinhho.karaoke_management.repository.RoomRepository;
import info.kinhho.karaoke_management.service.RoomService;

@Service
public class RoomServiceImpl extends BaseServiceImpl<Room, RoomRepository> implements RoomService {

	private RoomPriceRepository roomPriceRepository;

	public RoomServiceImpl(RoomRepository repository, RoomPriceRepository roomPriceRepository) {
		super(repository);
		this.roomPriceRepository = roomPriceRepository;
	}

	public void createSeedData() {
		
		RoomPrice roomPrice01 = new RoomPrice("VIP", 100000, 0, 6, "DAILY", 10);
		RoomPrice roomPrice02 = new RoomPrice("VIP", 70000, 6, 18, "DAILY", 10);
		RoomPrice roomPrice03 = new RoomPrice("VIP", 80000, 18, 24, "DAILY", 10);

		RoomPrice roomPrice04 = new RoomPrice("VIP", 130000, 0, 6, "DAILY", 15);
		RoomPrice roomPrice05 = new RoomPrice("VIP", 80000, 6, 18, "DAILY", 15);
		RoomPrice roomPrice06 = new RoomPrice("VIP", 90000, 18, 24, "DAILY", 15);
		
		RoomPrice roomPrice07 = new RoomPrice("VIP", 150000, 0, 6, "DAILY", 20);
		RoomPrice roomPrice08 = new RoomPrice("VIP", 90000, 6, 18, "DAILY", 20);
		RoomPrice roomPrice09 = new RoomPrice("VIP", 100000, 18, 24, "DAILY", 20);
		
		//==========================================================================//
		
		RoomPrice roomPrice10 = new RoomPrice("VIP", 200000, 0, 6, "WEEKEND", 10);
		RoomPrice roomPrice11 = new RoomPrice("VIP", 110000, 6, 18, "WEEKEND", 10);
		RoomPrice roomPrice12 = new RoomPrice("VIP", 130000, 18, 24, "WEEKEND", 10);
		
		RoomPrice roomPrice13 = new RoomPrice("VIP", 230000, 0, 6, "WEEKEND", 15);
		RoomPrice roomPrice14 = new RoomPrice("VIP", 120000, 6, 18, "WEEKEND", 15);
		RoomPrice roomPrice15 = new RoomPrice("VIP", 130000, 18, 24, "WEEKEND", 15);
		
		RoomPrice roomPrice16 =  new RoomPrice("VIP", 250000, 0, 6, "WEEKEND", 20);
		RoomPrice roomPrice17 = new RoomPrice("VIP", 130000, 6, 18, "WEEKEND", 20);
		RoomPrice roomPrice18 = new RoomPrice("VIP", 140000, 18, 24, "WEEKEND", 20);
		
		// ============================================================================//
		
		RoomPrice roomPrice19 = new RoomPrice("VIP", 220000, 0, 6, "HOLIDAY", 10);
		RoomPrice roomPrice20 = new RoomPrice("VIP", 130000, 6, 18, "HOLIDAY", 10);
		RoomPrice roomPrice21 = new RoomPrice("VIP", 170000, 18, 24, "HOLIDAY", 10);
		
		RoomPrice roomPrice22 = new RoomPrice("VIP", 260000, 0, 6, "HOLIDAY", 15);
		RoomPrice roomPrice23 = new RoomPrice("VIP", 150000, 6, 18, "HOLIDAY", 15);
		RoomPrice roomPrice24 = new RoomPrice("VIP", 180000, 18, 24, "HOLIDAY", 15);
		
		RoomPrice roomPrice25 = new RoomPrice("VIP", 280000, 0, 6, "HOLIDAY", 20);
		RoomPrice roomPrice26 = new RoomPrice("VIP", 180000, 6, 18, "HOLIDAY", 20);
		RoomPrice roomPrice27 = new RoomPrice("VIP", 200000, 18, 24, "HOLIDAY", 20);

		//============================================================================//
		
		RoomPrice roomPrice28 = new RoomPrice("SUPERVIP", 350000, 0, 6, "DAILY", 15);
		RoomPrice roomPrice29 = new RoomPrice("SUPERVIP", 150000, 6, 18, "DAILY", 15);
		RoomPrice roomPrice30 = new RoomPrice("SUPERVIP", 160000, 18, 24, "DAILY", 15);

		RoomPrice roomPrice31 = new RoomPrice("SUPERVIP", 380000, 0, 6, "DAILY", 20);
		RoomPrice roomPrice32 = new RoomPrice("SUPERVIP", 200000, 6, 18, "DAILY", 20);
		RoomPrice roomPrice33 = new RoomPrice("SUPERVIP", 230000, 18, 24, "DAILY", 20);

		//============================================================================//
		
		RoomPrice roomPrice34 = new RoomPrice("SUPERVIP", 400000, 0, 6, "WEEKEND", 15);
		RoomPrice roomPrice35 = new RoomPrice("SUPERVIP", 250000, 6, 18, "WEEKEND", 15);
		RoomPrice roomPrice36 = new RoomPrice("SUPERVIP", 300000, 18, 24, "WEEKEND", 15);
		
		RoomPrice roomPrice37 = new RoomPrice("SUPERVIP", 420000, 0, 6, "WEEKEND", 20);
		RoomPrice roomPrice38 = new RoomPrice("SUPERVIP", 270000, 6, 18, "WEEKEND", 20);
		RoomPrice roomPrice39 = new RoomPrice("SUPERVIP", 320000, 18, 24, "WEEKEND", 20);		

		//============================================================================//
		
		RoomPrice roomPrice40 = new RoomPrice("SUPERVIP", 430000, 0, 6, "HOLIDAY", 15);
		RoomPrice roomPrice41 = new RoomPrice("SUPERVIP", 280000, 6, 18, "HOLIDAY", 15);
		RoomPrice roomPrice42 = new RoomPrice("SUPERVIP", 340000, 18, 24, "HOLIDAY", 15);
		
		RoomPrice roomPrice43 = new RoomPrice("SUPERVIP", 450000, 0, 6, "HOLIDAY", 20);
		RoomPrice roomPrice44 = new RoomPrice("SUPERVIP", 300000, 6, 18, "HOLIDAY", 20);
		RoomPrice roomPrice45 = new RoomPrice("SUPERVIP", 350000, 18, 24, "HOLIDAY", 20);
		
		//============================================================================//
		
		List<RoomPrice> roomPriceVipHas10Capacity = Arrays.asList(roomPrice01, roomPrice02, roomPrice03, roomPrice10, roomPrice11, roomPrice12, roomPrice19, roomPrice20, roomPrice21);
		List<RoomPrice> roomPriceVipHas15Capacity = Arrays.asList(roomPrice04, roomPrice05, roomPrice06, roomPrice13, roomPrice14, roomPrice15, roomPrice22, roomPrice23, roomPrice24);
		List<RoomPrice> roomPriceVipHas20Capacity = Arrays.asList(roomPrice07, roomPrice08, roomPrice09, roomPrice16, roomPrice17, roomPrice18, roomPrice25, roomPrice26, roomPrice27);
		List<RoomPrice> roomPriceSuperVipHas15Capacity = Arrays.asList(roomPrice28, roomPrice29, roomPrice30, roomPrice34, roomPrice35, roomPrice36, roomPrice40, roomPrice41, roomPrice42);
		List<RoomPrice> roomPriceSuperVipHas20Capacity = Arrays.asList(roomPrice31, roomPrice32, roomPrice33, roomPrice37, roomPrice38, roomPrice39, roomPrice43, roomPrice44, roomPrice45);
		
		Room roomf10 = new Room("F000", "VIP", "READY", 1, 10);
		roomf10.setRoomPrices(roomPriceVipHas10Capacity);
		
		Room roomf11 = new Room("F001", "VIP", "READY", 1, 10);
		roomf11.setRoomPrices(roomPriceVipHas10Capacity);
		
		Room roomf12 = new Room("F002", "VIP", "READY", 1, 10);
		roomf12.setRoomPrices(roomPriceVipHas10Capacity);
		
		Room roomf13 = new Room("F003", "VIP", "READY", 1, 10);
		roomf13.setRoomPrices(roomPriceVipHas10Capacity);
		
		Room roomf14 = new Room("F004", "VIP", "READY", 1, 15);
		roomf14.setRoomPrices(roomPriceVipHas15Capacity);
		
		Room roomf15 = new Room("F005", "VIP", "READY", 1, 20);
		roomf15.setRoomPrices(roomPriceVipHas20Capacity);
		
		Room roomf16 = new Room("F006", "SUPERVIP", "READY", 1, 15);
		roomf16.setRoomPrices(roomPriceSuperVipHas15Capacity);
		
		Room roomf17 = new Room("F007", "SUPERVIP", "READY", 1, 15);
		roomf17.setRoomPrices(roomPriceSuperVipHas15Capacity);
		
		Room roomf18 = new Room("F008", "SUPERVIP", "READY", 1, 20);
		roomf18.setRoomPrices(roomPriceSuperVipHas20Capacity);
		
		Room roomf19 = new Room("F009", "SUPERVIP", "READY", 1, 20);
		roomf19.setRoomPrices(roomPriceSuperVipHas20Capacity);
		
		Room roomf20 = new Room("F010", "VIP", "READY", 2, 10);
		roomf20.setRoomPrices(roomPriceVipHas10Capacity);
		
		Room roomf21 = new Room("F011", "VIP", "READY", 2, 10);
		roomf21.setRoomPrices(roomPriceVipHas10Capacity);
		
		Room roomf22 = new Room("F012", "VIP", "READY", 2, 10);
		roomf22.setRoomPrices(roomPriceVipHas10Capacity);
		
		Room roomf23 = new Room("F013", "VIP", "READY", 2, 10);
		roomf23.setRoomPrices(roomPriceVipHas10Capacity);
		
		Room roomf24 = new Room("F014", "VIP", "READY", 2, 15);
		roomf24.setRoomPrices(roomPriceVipHas15Capacity);
		
		Room roomf25 = new Room("F015", "VIP", "READY", 2, 20);
		roomf25.setRoomPrices(roomPriceVipHas20Capacity);
		
		Room roomf26 = new Room("F016", "SUPERVIP", "READY", 2, 15);
		roomf26.setRoomPrices(roomPriceSuperVipHas15Capacity);
		
		Room roomf27 = new Room("F017", "SUPERVIP", "READY", 2, 15);
		roomf27.setRoomPrices(roomPriceSuperVipHas15Capacity);
		
		Room roomf28 = new Room("F018", "SUPERVIP", "READY", 2, 20);
		roomf28.setRoomPrices(roomPriceSuperVipHas20Capacity);
		
		Room roomf29 = new Room("F019", "SUPERVIP", "READY", 2, 20);
		roomf29.setRoomPrices(roomPriceSuperVipHas20Capacity);

		Room roomf30 = new Room("F020", "VIP", "READY", 3, 10);
		roomf30.setRoomPrices(roomPriceVipHas10Capacity);
		
		Room roomf31 = new Room("F021", "VIP", "READY", 3, 10);
		roomf31.setRoomPrices(roomPriceVipHas10Capacity);
		
		Room roomf32 = new Room("F022", "VIP", "READY", 3, 10);
		roomf32.setRoomPrices(roomPriceVipHas10Capacity);
		
		Room roomf33 = new Room("F023", "VIP", "READY", 3, 15);
		roomf33.setRoomPrices(roomPriceVipHas15Capacity);
		
		Room roomf34 = new Room("F024", "VIP", "READY", 3, 20);
		roomf34.setRoomPrices(roomPriceVipHas20Capacity);
		
		Room roomf35 = new Room("F025", "VIP", "READY", 3, 20);
		roomf35.setRoomPrices(roomPriceVipHas20Capacity);
		
		Room roomf36 = new Room("F026", "SUPERVIP", "READY", 3, 15);
		roomf36.setRoomPrices(roomPriceSuperVipHas15Capacity);
		
		Room roomf37 = new Room("F027", "SUPERVIP", "READY", 3, 15);
		roomf37.setRoomPrices(roomPriceSuperVipHas15Capacity);
		
		Room roomf38 = new Room("F028", "SUPERVIP", "READY", 3, 20);
		roomf38.setRoomPrices(roomPriceSuperVipHas20Capacity);
		
		Room roomf39 = new Room("F029", "SUPERVIP", "READY", 3, 20);
		roomf39.setRoomPrices(roomPriceSuperVipHas20Capacity);

		roomPriceRepository.save(roomPrice01);
		roomPriceRepository.save(roomPrice02);
		roomPriceRepository.save(roomPrice03);
		roomPriceRepository.save(roomPrice04);
		roomPriceRepository.save(roomPrice05);
		roomPriceRepository.save(roomPrice06);
		roomPriceRepository.save(roomPrice07);
		roomPriceRepository.save(roomPrice08);
		roomPriceRepository.save(roomPrice09);
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
		roomPriceRepository.save(roomPrice25);
		roomPriceRepository.save(roomPrice26);
		roomPriceRepository.save(roomPrice27);
		roomPriceRepository.save(roomPrice28);
		roomPriceRepository.save(roomPrice29);
		roomPriceRepository.save(roomPrice30);
		roomPriceRepository.save(roomPrice31);
		roomPriceRepository.save(roomPrice32);
		roomPriceRepository.save(roomPrice33);
		roomPriceRepository.save(roomPrice34);
		roomPriceRepository.save(roomPrice35);
		roomPriceRepository.save(roomPrice36);
		roomPriceRepository.save(roomPrice37);
		roomPriceRepository.save(roomPrice38);
		roomPriceRepository.save(roomPrice39);
		roomPriceRepository.save(roomPrice40);
		roomPriceRepository.save(roomPrice41);
		roomPriceRepository.save(roomPrice42);
		roomPriceRepository.save(roomPrice43);
		roomPriceRepository.save(roomPrice44);
		roomPriceRepository.save(roomPrice45);
		
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

		double price = prices.stream().filter(sameTypeDay.and(sameTypeRoom).and(betweenHour)).findFirst().get()
				.getPrice();

		System.out.println("Price: " + price);
		return 0;
	}

	@Override
	public void unactive(Long id) {
		// TODO Auto-generated method stub
	}
	
}

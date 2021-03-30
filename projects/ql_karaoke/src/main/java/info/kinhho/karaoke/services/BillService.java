package info.kinhho.karaoke.services;

import java.util.Date;

import org.springframework.stereotype.Service;

import info.kinhho.karaoke.entity.Bill;
import info.kinhho.karaoke.entity.BillDetail;
import info.kinhho.karaoke.entity.Room;
import info.kinhho.karaoke.repository.BillDetailRepository;
import info.kinhho.karaoke.repository.BillRepository;
import info.kinhho.karaoke.repository.RoomPriceRepository;
import info.kinhho.karaoke.repository.RoomRepository;


@Service
public class BillService {
	
	private BillRepository billRepository;
	private BillDetailRepository billDetailRepository;
	private RoomRepository roomRepository;
	
	public BillService(
			BillRepository billRepository,
			RoomRepository roomRepository, 
			BillDetailRepository billDetailRepository,
			RoomPriceRepository roomPriceRepository
	) {
		this.billRepository = billRepository;
		this.roomRepository = roomRepository;
		this.billDetailRepository = billDetailRepository;
	}
	
	public void save(Bill bill) {
		this.billRepository.save(bill);
	}
	
	public void save(BillDetail billDetail) {
		this.billDetailRepository.save(billDetail);
	}
	
	public void setOrderForRoom(Bill bill) {
		
		int size = bill.getBillDetails().size();
		
		BillDetail billDetail = bill.getBillDetails().get(size - 1);
		
		Room room = billDetail.getRoom();
		room.setCustomPhone(bill.getCustomerPhone());
		room.setState("ORDERED");
		
		this.roomRepository.save(room);
	}
	 
	public void setUseRoom(Integer id) {
			
		BillDetail billDetail = this.billDetailRepository.getByRoomId(id, "NOT");
		Bill bill = billDetail.getBill();
		
		Room room = billDetail.getRoom(); 
		
		room.setTimeStart(new Date());
		billDetail.setCheckIn(new Date());
		room.setState("USED");
		
		this.billRepository.save(bill);
		this.roomRepository.save(room);
			
	}
	
	public Bill getBillFromRoomId(Integer id) {
		
		BillDetail detail = this.billDetailRepository.getByRoomId(id, "NOT");
		return detail.getBill();		
	}
	
	public void swapRoom(Room from, Room to) {
		
		BillDetail detailFrom = this.billDetailRepository.getByRoomId(from.getId(), "NOT");
		detailFrom.setCheckOut(new Date());
		detailFrom.setState("PAID");
				
		Bill bill = detailFrom.getBill();
		
		to.setCustomPhone(from.getCustomPhone());
		to.setState( from.getState() );
		to.setTimeStart( new Date());
		
		
		
		bill.createBillDetail(to);
	}
	
	public BillDetail getBillDetailFromRoomId(Room room) {
		
		return this.billDetailRepository.getByRoomId(room.getId(), "NOT");
	}
	
	public void setCheckOutForOldDetail(BillDetail detail) {
		
		detail.setCheckOut(new Date());
	}

	public void createNewBillDetail(BillDetail detail, Room room) {
		
		Bill bill = detail.getBill();
		
		room.setState("USED");
		room.setTimeStart(new Date());
		BillDetail detailNew = bill.createBillDetail(room);
		detailNew.setCheckIn(new Date());
		
		this.billRepository.save(bill);
	}
	
}

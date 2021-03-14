package info.kinhho.karaoke_management.service.impl;

import java.time.ZonedDateTime;
import java.util.Date;

import org.springframework.stereotype.Service;

import info.kinhho.karaoke_management.entities.Account;
import info.kinhho.karaoke_management.entities.Bill;
import info.kinhho.karaoke_management.entities.BillDetail;
import info.kinhho.karaoke_management.entities.Room;
import info.kinhho.karaoke_management.repository.BillDetailRepository;
import info.kinhho.karaoke_management.repository.BillRepository;
import info.kinhho.karaoke_management.repository.RoomRepository;

@Service
public class BillServiceImpl extends BaseServiceImpl<Bill, BillRepository> {
	
	private BillDetailRepository billDetailRepository;
	private RoomRepository roomRepository;
	
	
	public BillServiceImpl(BillRepository repository, BillDetailRepository billDetailRepository,
			RoomRepository roomRepository) {
		
		super(repository);
		this.billDetailRepository = billDetailRepository;
		this.roomRepository = roomRepository;
	}
	
	public void save(Bill bill) {
		this.repository.save(bill);
	}
	
	public void save(BillDetail billDetail) {
		this.billDetailRepository.save(billDetail);
	}
	
	public void setOrderForRoom(Bill bill) {
		
		int size = bill.getBillDetails().size();
		
		BillDetail billDetail = bill.getBillDetails().get(size - 1);
		
		Room room = billDetail.getRoom();
		room.setCustomerPhone(bill.getCustomerPhone());
		room.setStatus("ORDERED");
		
		this.roomRepository.save(room);
	}
	 
	public void setUseRoom(Long id) {
			
		BillDetail billDetail = this.billDetailRepository.getByRoomId(id, "NOT");
		Bill bill = billDetail.getBill();
		
		Room room = billDetail.getRoom(); 
		
		room.setCheckIn(ZonedDateTime.now());
		billDetail.setCheckIn(new Date());
		room.setStatus("USED");
		
		this.repository.save(bill);
		this.roomRepository.save(room);
			
	}
	
	public Bill getBillFromRoomId(Long id) {
		
		BillDetail detail = this.billDetailRepository.getByRoomId(id, "NOT");
		return detail.getBill();		
	}
	
	public void swapRoom(Room from, Room to) {
		
//		BillDetail detailFrom = this.billDetailRepository.getByRoomId(from.getId(), "NOT");
//		detailFrom.setCheckOut(new Date());
//		detailFrom.set("PAID");
//				
//		Bill bill = detailFrom.getBill();
//		
//		to.setCustomPhone(from.getCustomPhone());
//		to.setState( from.getState() );
//		to.setTimeStart( new Date());
//		
//		
//		
//		bill.createBillDetail(to);
	}
	
	public BillDetail getBillDetailFromRoomId(Room room) {
		
		return this.billDetailRepository.getByRoomId(room.getId(), "NOT");
	}
	
	public void setCheckOutForOldDetail(BillDetail detail) {
		
		detail.setCheckOut(new Date());
	}

	public void createNewBillDetail(BillDetail detail, Room room) {
		
		Bill bill = detail.getBill();
		
		room.setStatus("USED");
		room.setCheckIn(ZonedDateTime.now());
		BillDetail detailNew = bill.createBillDetail(room);
		detailNew.setCheckIn(new Date());
		
		this.repository.save(bill);
	}
	
	public void createSeedData() {
		
	}
}

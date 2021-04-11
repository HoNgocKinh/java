package info.kinhho.karaoke_management.service.impl;

import org.springframework.stereotype.Service;

import info.kinhho.karaoke_management.entities.BookRoom;
import info.kinhho.karaoke_management.repository.BookRoomRepository;
import info.kinhho.karaoke_management.service.BookRoomService;

@Service
public class BookRoomServiceImpl 
		extends BaseServiceImpl<BookRoom, BookRoomRepository> 
		implements BookRoomService {

	public BookRoomServiceImpl(BookRoomRepository repository) {
		super(repository);
	}
	
	public void createSeedData() {
		
	}

	@Override
	public void unactive(Long id) {
		
		BookRoom bookRoom = repository.findById(id).get();
		bookRoom.setActive(false);
		
		repository.save(bookRoom);
	}
}

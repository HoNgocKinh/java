package info.kinhho.karaoke_management.service.impl;

import org.springframework.stereotype.Service;

import info.kinhho.karaoke_management.entities.Account;
import info.kinhho.karaoke_management.entities.BookRoom;
import info.kinhho.karaoke_management.repository.BookRoomRepository;

@Service
public class BookRoomServiceImpl extends BaseServiceImpl<BookRoom, BookRoomRepository> {

	public BookRoomServiceImpl(BookRoomRepository repository) {
		super(repository);
	}
	
	public void createSeedData() {
		
	}
}

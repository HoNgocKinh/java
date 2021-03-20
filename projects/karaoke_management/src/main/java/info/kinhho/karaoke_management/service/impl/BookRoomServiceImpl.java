package info.kinhho.karaoke_management.service.impl;

import org.springframework.stereotype.Service;

import info.kinhho.karaoke_management.dtos.BookRoomDTO;
import info.kinhho.karaoke_management.entities.BookRoom;
import info.kinhho.karaoke_management.repository.BookRoomRepository;

@Service
public class BookRoomServiceImpl extends BaseServiceImpl<BookRoom, BookRoomDTO,  BookRoomRepository> {

	public BookRoomServiceImpl(BookRoomRepository repository) {
		super(repository);
	}
	
	public void createSeedData() {
		
	}

	@Override
	public BookRoomDTO toDto(BookRoom e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookRoom toEntity(BookRoomDTO d) {
		// TODO Auto-generated method stub
		return null;
	}
}

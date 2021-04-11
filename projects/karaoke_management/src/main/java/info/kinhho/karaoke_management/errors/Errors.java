package info.kinhho.karaoke_management.errors;

public class Errors {
	
	public static class BOOK_ROOM_ERROR extends Exception {
		
		private static final long serialVersionUID = 1l;
		
		public BOOK_ROOM_ERROR() {
			super(ErrorMessage.BOOKING_ROOM_AT_TIME_NOT_FOUND);
		}
	}
}

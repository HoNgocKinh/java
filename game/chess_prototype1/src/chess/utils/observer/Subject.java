package chess.utils.observer;

import chess.utils.EventType;

public class Subject<T extends Notifable > {
	
	private T t;
	
	public Subject(T t) {
		this.t = t;
	}
	
	public Object notify(EventType type, Object obj) {
		return t.notify(type, obj);
	}
}

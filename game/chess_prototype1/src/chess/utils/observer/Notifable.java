package chess.utils.observer;

import chess.utils.EventType;

public interface Notifable {
	
	Object notify(EventType type, Object obj);
}

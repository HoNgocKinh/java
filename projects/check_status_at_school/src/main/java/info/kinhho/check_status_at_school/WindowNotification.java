package info.kinhho.check_status_at_school;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;

public class WindowNotification {	

	private String message;
	
	public WindowNotification(String message) {
		this.message = message;
		
		try {
			turnOnNotification();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private void turnOnNotification() throws AWTException {
		SystemTray tray = SystemTray.getSystemTray();
		Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
		TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        //Set tooltip text for the tray icon
        trayIcon.setToolTip("System tray icon demo");
        tray.add(trayIcon);

        trayIcon.displayMessage("Message From Batch Detect", message, MessageType.INFO);
	}
}

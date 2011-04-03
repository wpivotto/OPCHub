package prixma.opc.alarms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import prixma.opc.commands.ToggleCommand;

public class AlarmLogger implements AlarmCallback {

	private static final Logger Log = LoggerFactory.getLogger(ToggleCommand.class);
	
	@Override
	public void alarmeAck(Alarm alm) {
		Log.info("ACK ALARM" + alm);
	}

	@Override
	public void alarmeOff(Alarm alm) {
		Log.info("ALARM OFF" + alm);
	}

	@Override
	public void alarmeOn(Alarm alm) {
		Log.info("ALARM ON" + alm);
	}

}

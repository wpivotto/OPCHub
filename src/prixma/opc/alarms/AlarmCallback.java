package prixma.opc.alarms;


public interface AlarmCallback {

		public void alarmeOn(Alarm alm);
		public void alarmeOff(Alarm alm);
		public void alarmeAck(Alarm alm);
		
}

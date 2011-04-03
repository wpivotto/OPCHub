package prixma.opc.alarms;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class AlarmEventNotifier {
	
	private Set<AlarmCallback> listeners = new CopyOnWriteArraySet<AlarmCallback>();
	
	public void register(AlarmCallback callback){
		listeners.add(callback);
	}

	public void unregister(AlarmCallback callback){
		listeners.remove(callback);
	}
	
	
	public void alarmOff(AlarmRule condition) {
		
		Alarm alm = new Alarm(condition.getMessage(), AlarmStatus.ACTIVE);
	
		for(AlarmCallback listener : listeners){
			listener.alarmeOff(alm);
		}	
		
	}
 
	public void alarmOn(AlarmRule condition) {
		
		Alarm alm = new Alarm(condition.getMessage(), AlarmStatus.ACTIVE);
		
		for(AlarmCallback listener : listeners){
			listener.alarmeOn(alm);
		}	
		
	}
}

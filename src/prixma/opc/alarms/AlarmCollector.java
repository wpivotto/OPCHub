package prixma.opc.alarms;


import prixma.opc.services.RunIfConnected;
import prixma.opc.services.Service;


public class AlarmCollector extends Service {

	private final AlarmsConfiguration conditions;
	private final AlarmEventNotifier notifier = new AlarmEventNotifier();
	
	public AlarmCollector(AlarmsConfiguration conditions) {
		
		this.runStrategy = new RunIfConnected();
		
		this.conditions = conditions;
		
	}

	@Override
	public void execute() {
		
		for(AlarmRule condition : conditions){
			
			if(condition.match())
				notifier.alarmOn(condition);
			else
				notifier.alarmOff(condition);
			
		}
		 
	}
	
	public void enableLog(){
		registerCallback(new AlarmLogger());
	}
	
	public void registerCallback(AlarmCallback callback) {
		notifier.register(callback);
	}
	
	
}
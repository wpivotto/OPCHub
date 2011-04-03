package prixma.opc.alarms;

public enum AlarmSeverity {
	
	CRITICAL(3l),
	ERROR(2l),
	WARNING(1l);

	private final Long level;
	
	private AlarmSeverity(Long level){
		this.level = level;
	}
	
	public Long level(){
		return this.level;
	}
}

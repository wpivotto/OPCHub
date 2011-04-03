package prixma.opc.alarms;

public enum AlarmStatus {

	ACTIVE(3l),
	INACTIVE(2l),
	ACK(1l);

	private final Long level;

	private AlarmStatus(Long level){
		this.level = level;
	}

	public Long level(){
		return this.level;
	}
	
}

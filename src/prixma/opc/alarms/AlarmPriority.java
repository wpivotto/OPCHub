package prixma.opc.alarms;

public enum AlarmPriority {
	
	HIGHEST(3l),
	HIGH(2l),
	LOW(1l),
	LOWEST(0l);
	
	private final Long level;
	
	private AlarmPriority(Long level){
		this.level = level;
	}
	
	public Long level(){
		return this.level;
	}

}

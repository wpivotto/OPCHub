package prixma.opc.alarms;


public class Alarm {

	private Long timestamp;
	private AlarmSeverity severity;
	private AlarmPriority priority;
	private AlarmStatus status;
	private String message;
	
	
	public Alarm(String message, AlarmStatus status) {
		this.severity = AlarmSeverity.WARNING;
		this.priority = AlarmPriority.LOW;
		this.message = message;
		setStatus(status);
	}

	public String getMessage() {
		return this.message;
	}
	
	public Long getTimestamp(){
		return this.timestamp;
	}
	
	public boolean isON(){
		return getStatus().equals(AlarmStatus.ACTIVE);
	}
	
	public boolean isOFF(){
		return getStatus().equals(AlarmStatus.INACTIVE);
	}
	
	public boolean isAck(){
		return getStatus().equals(AlarmStatus.ACK);
	}
	
	public AlarmStatus getStatus(){ 
		return this.status; 
	}
	
	public void setStatus(AlarmStatus status){
		this.status = status;
		this.timestamp = System.currentTimeMillis();
	}
	
	public AlarmSeverity getSeverity() {
		return severity;
	}

	public void setSeverity(AlarmSeverity severity) {
		this.severity = severity;
	}

	public AlarmPriority getPriority() {
		return priority;
	}

	public void setPriority(AlarmPriority priority) {
		this.priority = priority;
	}

	
	public void inactive(){
		setStatus(AlarmStatus.INACTIVE);
	}

	public void active(){
		setStatus(AlarmStatus.ACTIVE);
	}
	
	public void ack(){
		setStatus(AlarmStatus.ACK);
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alarm other = (Alarm) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}

	@Override
	public String toString() {
		
		StringBuilder string = new StringBuilder("\n");
		
		string.append("Message : ").append(getMessage()).append("\n")
			  .append("Status : ").append(getStatus()).append("\n")
			  .append("Severity : ").append(getSeverity()).append("\n")
			  .append("Priority : ").append(getPriority()).append("\n")
			  .append("Timestamp : ").append(getTimestamp());
		
		return string.toString();
		
	}
	
	
	
	

	

	

	

	
	
	
}

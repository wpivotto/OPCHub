package prixma.opc.alarms;

import prixma.opc.dsl.criteria.Criterias;


public class AlarmRule {
	
	private final String message;
	private final Criterias criterias;
	
	
	public AlarmRule(String message, Criterias criterias) {
		this.message = message;
		this.criterias = criterias;
	}


	public String getMessage() {
		return message;
	}


	public Criterias getCriterias() {
		return criterias;
	}
	
	public boolean match(){
		return criterias.match();
	}
	
	@Override
	public String toString() {
		return message;
	}
	
	

}

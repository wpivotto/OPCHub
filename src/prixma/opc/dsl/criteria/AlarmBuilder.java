package prixma.opc.dsl.criteria;

import prixma.opc.alarms.AlarmsConfiguration;
import prixma.opc.dsl.matchers.Matcher;
import prixma.opc.dsl.specification.And;
import prixma.opc.dsl.specification.Or;


public class AlarmBuilder implements Builder {

	private Criterias criterias = new Criterias();
	private AlarmsConfiguration conditions;
	private String message;
	
	public AlarmBuilder(String message, AlarmsConfiguration conditions){
		this.message = message;
		this.conditions = conditions;
	}
	
	public AlarmBuilder when(String item, Matcher condition){
		Criteria criteria = new ValueBasedCriteria(item, condition);
		criterias.add(criteria);
		return this;
	}

	public AlarmBuilder and(String item, Matcher condition){
		Criteria criteria = new ValueBasedCriteria(item, condition, new And());
		criterias.add(criteria);
		return this;
	}
	
	
	public AlarmBuilder or(String item, Matcher condition){
		Criteria criteria = new ValueBasedCriteria(item, condition, new Or());
		criterias.add(criteria);
		return this;
	}
	
	public void add(){
		conditions.add(message, criterias);
	}

	
	
	
}

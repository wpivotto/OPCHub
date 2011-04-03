package prixma.opc.alarms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import prixma.opc.dsl.criteria.Criterias;


public class AlarmsConfiguration implements Iterable<AlarmRule> {
	
	private List<AlarmRule> rules = new ArrayList<AlarmRule>();

	public void add(String message, Criterias criterias){
		AlarmRule rule = new AlarmRule(message, criterias);
		rules.add(rule);
	}
	
	public void clear(){
		rules.clear();
	}
	
	public boolean isEmpty(){
		return rules.isEmpty();
	}
	
	@Override
	public Iterator<AlarmRule> iterator() {
		return rules.iterator();
	}

	public int size() {
		return rules.size();
	}


}

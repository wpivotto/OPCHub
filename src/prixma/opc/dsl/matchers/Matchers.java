package prixma.opc.dsl.matchers;


import prixma.opc.alarms.AlarmsConfiguration;
import prixma.opc.dsl.criteria.AlarmBuilder;

public class Matchers {
	
	public static AlarmsConfiguration alarms = new AlarmsConfiguration();
	
	public static AlarmBuilder alarm(String message){
		return new AlarmBuilder(message, alarms);
	}
	
	public static Matcher eq(Object value){
		return new Equals(value);
	}
	
	public static Matcher not(Matcher condition){
		return new Not(condition);
	}
	
	public static Matcher contais(String value){
		return new Contains(value);
	}
	
	public static Matcher greaterThan(Number value){
		return new GreaterThan(value);
	}
	
	public static Matcher lessThan(Number value){
		return new LessThan(value);
	}
	
	public static Matcher change(){
		return new ChangeValue();
	}
	
	public static Matcher changeValueTo(Object value){
		return new CompositeMatcher(new ChangeValue(), new Equals(value));
	}
	
	public static Matcher changesToOn(){
		return new CompositeMatcher(new ChangeValue(), new Equals(1l));
	}

	public static Matcher changesToOff(){
		return new CompositeMatcher(new ChangeValue(), new Equals(0l));
	}
	
	public static Matcher isOn(){
		return new Equals(1l);
	}
	
	public static Matcher isOff(){
		return new Equals(0l);
	}
	

}

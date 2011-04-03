package prixma.opc.dsl.matchers;



public class GreaterThan implements Matcher {

	private Number value;
	
	public GreaterThan(Number value) {
		this.value = value;
	}


	@Override
	public boolean match(Object matchValue) {
		return  value.doubleValue() < ((Number) matchValue).doubleValue();	
	}
	
	

}

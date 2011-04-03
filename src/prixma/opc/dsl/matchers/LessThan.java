package prixma.opc.dsl.matchers;



public class LessThan implements Matcher {

	private Number value;
	
	public LessThan(Number value) {
		this.value = value;
	}


	@Override
	public boolean match(Object matchValue) {
		return  value.doubleValue() > ((Number) matchValue).doubleValue();	
	}
	
	

}

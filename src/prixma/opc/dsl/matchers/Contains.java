package prixma.opc.dsl.matchers;



public class Contains implements Matcher {

	private String matcherValue;
	
	public Contains(String matcherValue) {
		this.matcherValue = matcherValue;
	}


	@Override
	public boolean match(Object value) {
		return String.valueOf(value).contains(matcherValue);
	}
	
	

}

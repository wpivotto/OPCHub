package prixma.opc.dsl.matchers;



public class Not implements Matcher {

	private Matcher condition;
	
	public Not(Matcher condition) {
		this.condition = condition;
	}


	@Override
	public boolean match(Object value) {
		return !condition.match(value);
	}
	
	

}

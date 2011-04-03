package prixma.opc.dsl.matchers;

public class Equals implements Matcher {

	private final Object value;
	
	public Equals(Object value) {
		this.value = value;
	}

	@Override
	public boolean match(Object expected) {
		return value.equals(expected);
	}

}

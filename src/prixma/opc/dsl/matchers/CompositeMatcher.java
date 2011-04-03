package prixma.opc.dsl.matchers;


public class CompositeMatcher implements Matcher {

	private final Matcher one;
	private final Matcher other;

	
	public CompositeMatcher(Matcher one, Matcher other) {
		this.one = one;
		this.other = other;
	}



	@Override
	public boolean match(Object currentValue) {
		return one.match(currentValue) && other.match(currentValue);
	}

}

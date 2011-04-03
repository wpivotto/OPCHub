package prixma.opc.dsl.matchers;


public class ChangeValue implements Matcher {

	private Object lastValue;

	@Override
	public boolean match(Object currentValue) {
		
		if (!currentValue.equals(lastValue)) {
			lastValue = currentValue;
			return true;
		}
		
		return false;
		
	}

}

package prixma.opc.dsl.criteria;

import java.util.Random;

import prixma.opc.commands.ReadCommand;
import prixma.opc.dsl.matchers.Matcher;
import prixma.opc.dsl.specification.Specification;

public class ValueBasedCriteria implements Criteria {
	
	private String item;
	private final Matcher condition;
	private Specification specification;
	
	
	public ValueBasedCriteria(String item, Matcher condition) {
		this.item = item;
		this.condition = condition;
	}
	
	public ValueBasedCriteria(String item, Matcher condition, Specification specification) {
		this.item = item;
		this.condition = condition;
		this.specification = specification;
	}

	public Specification getSpecification() {
		return specification;
	}


	/**
	 * Avalia o valor atual do tag em relacao aos valores esperados
	 */
	public boolean match() {
		String value = new ReadCommand<String>(item).execute();
		return condition.match(value);
		
	}

}

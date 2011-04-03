package prixma.opc.dsl.criteria;

import java.util.Random;

import prixma.opc.dsl.matchers.Matcher;
import prixma.opc.dsl.specification.Specification;

public class QualityBasedCriteria implements Criteria {
	
	private String item;
	private final Matcher condition;
	private Specification specification;
	
	public QualityBasedCriteria(String item, Matcher condition, Specification specification) {
		this.item = item;
		this.condition = condition;
		this.specification = specification;
	}
	
	public QualityBasedCriteria(String item, Matcher condition) {
		this.item = item;
		this.condition = condition;
	}

	public Specification getSpecification() {
		return specification;
	}


	
	public boolean match() {
		Object value = new Random(System.nanoTime()).nextDouble(); //read quality
		return condition.match(value);
		
	}
	

}

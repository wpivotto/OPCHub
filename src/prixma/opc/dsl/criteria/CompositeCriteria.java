package prixma.opc.dsl.criteria;

import prixma.opc.dsl.specification.Specification;

public class CompositeCriteria implements Criteria {

	private final Criteria one;
	private final Criteria other;
	private final Specification specification;

	
	public CompositeCriteria(Criteria one, Criteria other, Specification specification) {
		this.one = one;
		this.other = other;
		this.specification = specification;
	}

	public CompositeCriteria(Criteria one, Criteria other) {
		this.one = one;
		this.other = other;
		this.specification = one.getSpecification();
	}


	@Override
	public boolean match() {
		return specification.match(one, other);
	}

	@Override
	public Specification getSpecification() {
		return specification;
	}

	
	

}

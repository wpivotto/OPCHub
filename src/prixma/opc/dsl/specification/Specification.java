package prixma.opc.dsl.specification;

import prixma.opc.dsl.criteria.Criteria;

public interface Specification {
	
	boolean match(Criteria one, Criteria other);

}

package prixma.opc.dsl.criteria;

import prixma.opc.dsl.specification.Specification;



public interface Criteria {
	
	boolean match();
	
	Specification getSpecification();


}

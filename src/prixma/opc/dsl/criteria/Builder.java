package prixma.opc.dsl.criteria;

import prixma.opc.dsl.matchers.Matcher;


public interface Builder {
	
	Builder when(String item, Matcher condition);

	Builder and(String item, Matcher condition);
	
	Builder or(String item, Matcher condition);
	
	void add();

}

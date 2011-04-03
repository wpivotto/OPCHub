package prixma.opc.dsl.criteria;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Criterias implements Iterable<Criteria> {
	
	private List<Criteria> criterias = new ArrayList<Criteria>();
	
	public void add(Criteria criteria){
		this.criterias.add(criteria);
	}

	@Override
	public Iterator<Criteria> iterator() {
		return criterias.iterator();
	}

	public void clear() {
		this.criterias.clear();
	}
	
	public boolean isEmpty(){
		return this.criterias.isEmpty();
	}
	
	public boolean match(){
		
		boolean matched = true;
		
		if(criterias.size() == 1)
			return criterias.get(0).match();

		for(int i = criterias.size() - 1; i > 0; i--){
			Criteria criteria = new CompositeCriteria(criterias.get(i), criterias.get(i - 1));
			matched = matched && criteria.match();
		}
		
		return matched;

		
	}

}

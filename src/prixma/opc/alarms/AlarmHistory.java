package prixma.opc.alarms;

import java.util.Collection;
import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.PriorityQueue;

public class AlarmHistory implements AlarmCallback {

	private PriorityQueue<Alarm> alarms;
    private int size;
    
    public AlarmHistory(int initalSize, int maxSize, Comparator<Alarm> order){
    	this.size = maxSize;
    	this.alarms = new PriorityQueue<Alarm>(initalSize, order);
    }
    
    public AlarmHistory(int initalSize, int maxSize){
    	this(initalSize, maxSize, AlarmOrder.ByTimestamp.desc());
    }
    
    public AlarmHistory(int maxSize){
    	this(100, maxSize, AlarmOrder.ByTimestamp.desc());
    }
    
    public AlarmHistory(){
    	this(100, 100, AlarmOrder.ByTimestamp.desc());
    }

    public void add(Alarm alm) {
    	
    	if(!alarms.contains(alm)){
    		if(isFull()) 
    			remove();
    		alarms.offer(alm);
    	}
    }


    public Alarm remove() {
    	if(isEmpty())
    		throw new EmptyStackException();
    	return alarms.poll();
    }
    

    public boolean remove(Alarm alm) {
    	if(isEmpty())
    		return false;
    	return alarms.remove(alm);
    }
    

    public boolean isEmpty() {
       return alarms.isEmpty();
    }
    
    public boolean isFull() {
        return alarms.size() == this.size;
    }
    
  
	
	public void clear(){
		alarms.clear();
	}


	public Alarm first() {
		return alarms.peek();
	}


	public Collection<Alarm> getAlarms() {
		return alarms;
	}


	public int size() {
		return alarms.size();
	}


	@Override
	public void alarmeAck(Alarm alm) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void alarmeOff(Alarm alm) {
		remove(alm);
	}


	@Override
	public void alarmeOn(Alarm alm) {
		add(alm);
	}

 } 
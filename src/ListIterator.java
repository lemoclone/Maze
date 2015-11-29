import java.util.List;

public class ListIterator {
	private int current = 0;
    private List<?> list;
    
	public ListIterator(){
		
	}
	
	void first () {
        current = 0;
    }
	
	void next(){
		current++;
	}
	
	Object currentItem(){
		 if (isDone()) {
	         throw new IllegalStateException("Cause already initialized");
		 }
	     return list.get(current);
	}
	
	boolean isDone(){
        return current >= list.size();
	}
	
	private class Zone{
		public Zone(){};
	}
}

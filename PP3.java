//Zachary Kowal
public class PP3 {

	@Override
	public String toString() {
		
		String str = "";
		Node n = head;
		
		while(n != null) {
			str = str + n.get(element);
			n = n.getNext();
		}
		return str;
	}
}

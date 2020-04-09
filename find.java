

public void find(E element){
	found = false;
	location = FrontCar;
	while(location != null){
		if(location.getInfo().equals(elements)){
			found = true;
			return;
		}
		location = location.getNext();
	}

}

public void find2(E element) {
	if(flag == true){
		tempList = new Comparable[size()];
		LLNode<E> temp = FrontCar;
		for (int i =0; i<tempList.length; i++){
			tempList[i] = (Comparable) temp.getInfo();
			temp = temp.getNext();
		}
		flag = false
	}
}
*/
package apps;
import adts.ListADT;
import java.util.Random;
public class PP3Test {

	public static void main(String[] args) {
		// Create doubly linked list
		ListADT<Integer> test = new ListADT<Integer>();
//		// New list should be empty:
//		System.out.println("is it empty? " + test.isEmpty());
//		
//		// Add first element into list
//		test.add(3);
//			
//		// Add at the head
//		test.add(2);
//		
//		// Add at the tail
//		test.add(5);
//		
//		// Add in the middle
//		test.add(4);
//		
//		//fill it out a little more
//		test.add(1);
//		test.add(6);
//		test.add(7);
//		test.add(8);
//		test.add(9);
//		test.add(10);
//		
//		System.out.println("Your list is: " + test.toString());
//		System.out.println("is it empty? " + test.isEmpty());
//		System.out.println("The size of the list is: " + test.size());
//		// remove from the head
//		test.remove(1);
//		
//		// remove from the tail
//		test.remove(10);
//		
//		// remove from the middle
//		test.remove(5);
//		
//		// Check elements in list (tests to string)
//		// Also resets the iterator every time we call to string, so no need to test that if we call to string mult times
//		System.out.println("Your list is: " + test.toString());
//		
//		// Check the size
//		System.out.println("The size of the list is: " + test.size());
//		
//		// Contains uses get, get uses find, testing contains tests all three
//		//number not in the list
//		System.out.println("This should be false since 1 not in list: " + test.contains(1));
//		//number in the list
//		System.out.println("This should be true since 2 in list: " + test.contains(2));
//		
//		// Printing the list backwards will be a good way to test getPrev and reset back iterator
//		test.resetBackIterator();
//		for(int i = 0; i < test.size(); i++) {
//			System.out.print(test.getPrevItem() + " ");
//		}
//		System.out.println();
//
//		// Now we just test that find2 works
//		// 3 should be in the list
//		test.find2(3,0,test.size()-1);
//		System.out.println(test.found());
//		
//		// 1 should not be in the list
//		test.find2(1,0,test.size()-1);
//		System.out.println(test.found());
		
		//Test 1 (size - empty list)
		System.out.println("The size of the list is: " + test.size());
		//Test 2 (isEmpty - empty list)
		System.out.println("is it empty? " + test.isEmpty());
		//Test3 (add - item to empty list)
		test.add(3);
		System.out.println("Your list is: " + test.toString());
		//Test 4 (add - to the head)
		test.add(2);
		System.out.println("Your list is: " + test.toString());
		//Test 5 (add - to the tail)
		test.add(5);
		System.out.println("Your list is: " + test.toString());
		//Test 6 (add - to the middle)
		test.add(4);
		System.out.println("Your list is: " + test.toString());
		//Test 7 (size - non-empty list)
		System.out.println("The size of the list is: " + test.size());
		//Test 8 (isEmpty - non-empty list)
		System.out.println("is it empty? " + test.isEmpty());

		//Test 9 (contains - number in list)
		//Test 11 (get - number in list)
		//Contains uses get, get uses find, testing contains tests all three
		System.out.println("This should be true since 2 is in list: " + test.contains(2));
		
		//Test 10 (contains - number not in list)
		//Test 12 (get - number not in list)
		//Contains uses get, get uses find, testing contains tests all three
		System.out.println("This should be false since 11 is not in list: " + test.contains(1));
		
		
		//Test 13 (toString)
		System.out.println("Your list is: " + test.toString());
		//Test 14, 15, 16, 17, 18, 19, 20, & 21 (resetIterato()r & getNextItem())
		//Note: test should loop from the tail back to the head at the end of the list
		test.resetIterator();
		for(int i = 0; i <= test.size(); i++) {
			System.out.print(test.getNextItem() + " ");
		}
		System.out.println();
		//Test 22, 23, 24, 25, 26, 27, 28, & 29 (resetBackIterator & getPrevItem())
		// Printing the list backwards will be a good way to test getPrev and resetackIterator
		//Note: test should loop from the head back to the tail at the end of the list
		test.resetBackIterator();
		for(int i = 0; i <= test.size(); i++) {
			System.out.print(test.getPrevItem() + " ");
		}
		System.out.println();
		//Test 30 (remove - middle)
		test.remove(3);
		System.out.println("Your list is: " + test.toString());
		//Test 31 (remove - head)
		test.remove(2);
		System.out.println("Your list is: " + test.toString());
		//Test 32 (remove - tail)
		test.remove(5);
		System.out.println("Your list is: " + test.toString());
		//Test 33 (remove - number not in list)
		test.remove(5);
		System.out.println("Your list is: " + test.toString());
		
//--------------------FIND/FIND2 COMPARISON PART 1 ------------------------------------------------------------------------
		ListADT<Integer> test2 = new ListADT<Integer>();
		long findstart; long findstart2; long findend; long findend2; 
		long difference;
		
		test2.add(0);
		// Part 1 of test; return times of an array of 1 element
		System.out.println("\n*********************** single element test *************************************\n");
		System.out.println("Element in array; find2() creates new array");
		findstart = System.nanoTime();
		test2.find(0);
		findend = System.nanoTime();
		System.out.println("find(): " + (findend-findstart));
		
		findstart2 = System.nanoTime();
		test2.find2(0,0,test2.size() - 1);
		findend2 = System.nanoTime();
		System.out.println("find2(): " + (findend2-findstart2));
		difference = (findend-findstart)-(findend2-findstart2);
		System.out.println("Difference in time: " + difference);
		
		System.out.println("\nElement in array; find2() uses old array");
		findstart = System.nanoTime();
		test2.find(0);
		findend = System.nanoTime();
		System.out.println("find(): " + (findend-findstart));
		
		findstart2 = System.nanoTime();
		test2.find2(0,0,test2.size() - 1);
		findend2 = System.nanoTime();
		System.out.println("find2(): " + (findend2-findstart2));
		difference = (findend-findstart)-(findend2-findstart2);
		System.out.println("Difference in time: " + difference);

		System.out.println("\nElement not in array;");
		findstart = System.nanoTime();
		test2.find(1);
		findend = System.nanoTime();
		System.out.println("find(): " + (findend-findstart));
		
		findstart2 = System.nanoTime();
		test2.find2(1,0,test2.size() - 1);
		findend2 = System.nanoTime();
		System.out.println("find()2: " + (findend2-findstart2));
		difference = (findend-findstart)-(findend2-findstart2);
		System.out.println("Difference in time: " + difference);
		

		
/*********************************************** 5000 TEST ***************************************************************************/
		int lowerIn; int upperIn; int lowerOut; int upperOut; 
		
		Random numberGenerator = new Random(25);
		 
		lowerIn = numberGenerator.nextInt(5001);
		while(true) { //  Find next even number below mid point
			if(lowerIn < 2500 && (lowerIn % 2 == 0)) break;
			else lowerIn = numberGenerator.nextInt(5001);
		}
		upperIn = numberGenerator.nextInt(5001);
		while(true) { //  Find next even number below mid point
			if(upperIn > 2500 && (upperIn % 2 == 0)) break;
			else upperIn = numberGenerator.nextInt(5001);
		}
		lowerOut = numberGenerator.nextInt(5001);
		while(true) { //  Find next even number below mid point
			if(lowerOut < 2500 && (lowerOut % 2 == 1)) break;
			else lowerOut = numberGenerator.nextInt(5001);
		}
		upperOut = numberGenerator.nextInt(5001);
		while(true) { //  Find next even number below mid point
			if(upperOut > 2500 && (upperOut % 2 == 1)) break;
			else upperOut = numberGenerator.nextInt(5001);
		}


		
		ListADT<Integer> test3 = new ListADT<Integer>();
		for(int i = 0; i <= 5000; i = i + 2) {
			test3.add(i);
		}
		System.out.println("\n*********************** 5000 TEST *************************************\n");
		/** lower bounds test **/
		System.out.println("Lower bound test: Element in array; find2() creates new array");
		System.out.println("FIND:" + lowerIn);
		findstart = System.nanoTime();
		test3.find(lowerIn);
		findend = System.nanoTime();
		System.out.println("find(): " + (findend-findstart));
		findstart2 = System.nanoTime();
		test3.find2(lowerIn, 0, test3.size() - 1);
		findend2 = System.nanoTime();
		System.out.println("find2(): " + (findend2-findstart2));
		
		difference = (findend-findstart)-(findend2-findstart2);
		System.out.println("Difference in time: " + difference);
		
		
		System.out.println("\nLower bound test: Element in array; find2() uses old array");
		System.out.println("FIND:" + lowerIn);
		findstart = System.nanoTime();
		test3.find(lowerIn);
		findend = System.nanoTime();
		System.out.println("find(): " + (findend-findstart));
		
		findstart2 = System.nanoTime();
		test3.find2(lowerIn, 0, test3.size() - 1);
		findend2 = System.nanoTime();
		System.out.println("find2(): " + (findend2-findstart2));
		
		difference = (findend-findstart)-(findend2-findstart2);
		System.out.println("Difference in time: " + difference); 

		System.out.println("\nLower bound test: Element NOT in array");
		System.out.println("FIND:" + lowerOut);
		findstart = System.nanoTime();
		test3.find(lowerOut);
		findend = System.nanoTime();
		System.out.println("find(): " + (findend-findstart));
		
		findstart2 = System.nanoTime();
		test3.find2(lowerOut, 0, test3.size() - 1);
		findend2 = System.nanoTime();
		System.out.println("find()2: " + (findend2-findstart2));
		
		difference = (findend-findstart)-(findend2-findstart2);
		System.out.println("Difference in time: " + difference);
		
		/** Upper in bounds **/
		System.out.println("\nUpper bound test: Element in array");
		System.out.println("FIND:" + upperIn);
		findstart = System.nanoTime();
		test3.find(upperIn);
		findend = System.nanoTime();
		System.out.println("find(): " + (findend-findstart));
		
		findstart2 = System.nanoTime();
		test3.find2(upperIn, 0, test3.size() - 1);
		findend2 = System.nanoTime();
		System.out.println("find2(): " + (findend2-findstart2));
		difference = (findend-findstart)-(findend2-findstart2);
		System.out.println("Difference in time: " + difference);

		/** Upper out bounds **/
		System.out.println("\nUpper bound test: Element NOT in array");
		System.out.println("FIND:" + upperOut);
		findstart = System.nanoTime();
		test3.find(upperOut);
		findend = System.nanoTime();
		System.out.println("find(): " + (findend-findstart));
		
		findstart2 = System.nanoTime();
		test3.find2(upperOut, 0, test3.size() - 1);
		findend2 = System.nanoTime();
		System.out.println("find()2: " + (findend2-findstart2));
		difference = (findend-findstart)-(findend2-findstart2);
		System.out.println("Difference in time: " + difference);
		
/*********************************************** 10000 TEST ***************************************************************************/
		lowerIn = numberGenerator.nextInt(10001);
		while(true) { //  Find next even number below mid point
			if(lowerIn < 5000 && (lowerIn % 2 == 0)) break;
			else lowerIn = numberGenerator.nextInt(10001);
		}
		upperIn = numberGenerator.nextInt(10001);
		while(true) { //  Find next even number below mid point
			if(upperIn > 5000 && (upperIn % 2 == 0)) break;
			else upperIn = numberGenerator.nextInt(10001);
		}
		lowerOut = numberGenerator.nextInt(10001);
		while(true) { //  Find next even number below mid point
			if(lowerOut < 5000 && (lowerOut % 2 == 1)) break;
			else lowerOut = numberGenerator.nextInt(10001);
		}
		upperOut = numberGenerator.nextInt(10001);
		while(true) { //  Find next even number below mid point
			if(upperOut > 5000 && (upperOut % 2 == 1)) break;
			else upperOut = numberGenerator.nextInt(10001);
		}
	
		test3 = new ListADT<Integer>();
		for(int i = 0; i <= 10000; i = i + 2) {
			test3.add(i);
		}
		System.out.println("\n*********************** 10000 TEST *************************************\n");
		/** lower bounds test **/
		System.out.println("Lower bound test: Element in array; find2() creates new array");
		System.out.println("FIND:" + lowerIn);
		findstart = System.nanoTime();
		test3.find(lowerIn);
		findend = System.nanoTime();
		System.out.println("find(): " + (findend-findstart));
		findstart2 = System.nanoTime();
		test3.find2(lowerIn, 0, test3.size() - 1);
		findend2 = System.nanoTime();
		System.out.println("find2(): " + (findend2-findstart2));
		
		difference = (findend-findstart)-(findend2-findstart2);
		System.out.println("Difference in time: " + difference);
		
		
		System.out.println("\nLower bound test: Element in array; find2() uses old array");
		System.out.println("FIND:" + lowerIn);
		findstart = System.nanoTime();
		test3.find(lowerIn);
		findend = System.nanoTime();
		System.out.println("find(): " + (findend-findstart));
		
		findstart2 = System.nanoTime();
		test3.find2(lowerIn, 0, test3.size() - 1);
		findend2 = System.nanoTime();
		System.out.println("find2(): " + (findend2-findstart2));
		
		difference = (findend-findstart)-(findend2-findstart2);
		System.out.println("Difference in time: " + difference); 

		System.out.println("\nLower bound test: Element NOT in array");
		System.out.println("FIND:" + lowerOut);
		findstart = System.nanoTime();
		test3.find(lowerOut);
		findend = System.nanoTime();
		System.out.println("find(): " + (findend-findstart));
		
		findstart2 = System.nanoTime();
		test3.find2(lowerOut, 0, test3.size() - 1);
		findend2 = System.nanoTime();
		System.out.println("find()2: " + (findend2-findstart2));
		
		difference = (findend-findstart)-(findend2-findstart2);
		System.out.println("Difference in time: " + difference);
		
		/** Upper in bounds **/
		System.out.println("\nUpper bound test: Element in array");
		System.out.println("FIND:" + upperIn);
		findstart = System.nanoTime();
		test3.find(upperIn);
		findend = System.nanoTime();
		System.out.println("find(): " + (findend-findstart));
		
		findstart2 = System.nanoTime();
		test3.find2(upperIn, 0, test3.size() - 1);
		findend2 = System.nanoTime();
		System.out.println("find2(): " + (findend2-findstart2));
		difference = (findend-findstart)-(findend2-findstart2);
		System.out.println("Difference in time: " + difference);

		/** Upper out bounds **/
		System.out.println("\nUpper bound test: Element NOT in array");
		System.out.println("FIND:" + upperOut);
		findstart = System.nanoTime();
		test3.find(upperOut);
		findend = System.nanoTime();
		System.out.println("find(): " + (findend-findstart));
		
		findstart2 = System.nanoTime();
		test3.find2(upperOut, 0, test3.size() - 1);
		findend2 = System.nanoTime();
		System.out.println("find()2: " + (findend2-findstart2));
		difference = (findend-findstart)-(findend2-findstart2);
		System.out.println("Difference in time: " + difference);
		
/*********************************************** 20000 TEST ***************************************************************************/
		lowerIn = numberGenerator.nextInt(20001);
		while(true) { //  Find next even number below mid point
			if(lowerIn < 10000 && (lowerIn % 2 == 0)) break;
			else lowerIn = numberGenerator.nextInt(20001);
		}
		upperIn = numberGenerator.nextInt(20001);
		while(true) { //  Find next even number below mid point
			if(upperIn > 10000 && (upperIn % 2 == 0)) break;
			else upperIn = numberGenerator.nextInt(20001);
		}
		lowerOut = numberGenerator.nextInt(20001);
		while(true) { //  Find next even number below mid point
			if(lowerOut < 10000 && (lowerOut % 2 == 1)) break;
			else lowerOut = numberGenerator.nextInt(20001);
		}
		upperOut = numberGenerator.nextInt(20001);
		while(true) { //  Find next even number below mid point
			if(upperOut > 10000 && (upperOut % 2 == 1)) break;
			else upperOut = numberGenerator.nextInt(20001);
		}
	
		test3 = new ListADT<Integer>();
		for(int i = 0; i <= 20000; i = i + 2) {
			test3.add(i);
		}
		System.out.println("\n*********************** 20000 TEST *************************************\n");
		/** lower bounds test **/
		System.out.println("Lower bound test: Element in array; find2() creates new array");
		System.out.println("FIND:" + lowerIn);
		findstart = System.nanoTime();
		test3.find(lowerIn);
		findend = System.nanoTime();
		System.out.println("find(): " + (findend-findstart));
		findstart2 = System.nanoTime();
		test3.find2(lowerIn, 0, test3.size() - 1);
		findend2 = System.nanoTime();
		System.out.println("find2(): " + (findend2-findstart2));
		
		difference = (findend-findstart)-(findend2-findstart2);
		System.out.println("Difference in time: " + difference);
		
		
		System.out.println("\nLower bound test: Element in array; find2() uses old array");
		System.out.println("FIND:" + lowerIn);
		findstart = System.nanoTime();
		test3.find(lowerIn);
		findend = System.nanoTime();
		System.out.println("find(): " + (findend-findstart));
		
		findstart2 = System.nanoTime();
		test3.find2(lowerIn, 0, test3.size() - 1);
		findend2 = System.nanoTime();
		System.out.println("find2(): " + (findend2-findstart2));
		
		difference = (findend-findstart)-(findend2-findstart2);
		System.out.println("Difference in time: " + difference); 

		System.out.println("\nLower bound test: Element NOT in array");
		System.out.println("FIND:" + lowerOut);
		findstart = System.nanoTime();
		test3.find(lowerOut);
		findend = System.nanoTime();
		System.out.println("find(): " + (findend-findstart));
		
		findstart2 = System.nanoTime();
		test3.find2(lowerOut, 0, test3.size() - 1);
		findend2 = System.nanoTime();
		System.out.println("find()2: " + (findend2-findstart2));
		
		difference = (findend-findstart)-(findend2-findstart2);
		System.out.println("Difference in time: " + difference);
		
		/** Upper in bounds **/
		System.out.println("\nUpper bound test: Element in array");
		System.out.println("FIND:" + upperIn);
		findstart = System.nanoTime();
		test3.find(upperIn);
		findend = System.nanoTime();
		System.out.println("find(): " + (findend-findstart));
		
		findstart2 = System.nanoTime();
		test3.find2(upperIn, 0, test3.size() - 1);
		findend2 = System.nanoTime();
		System.out.println("find2(): " + (findend2-findstart2));
		difference = (findend-findstart)-(findend2-findstart2);
		System.out.println("Difference in time: " + difference);

		/** Upper out bounds **/
		System.out.println("\nUpper bound test: Element NOT in array");
		System.out.println("FIND:" + upperOut);
		findstart = System.nanoTime();
		test3.find(upperOut);
		findend = System.nanoTime();
		System.out.println("find(): " + (findend-findstart));
		
		findstart2 = System.nanoTime();
		test3.find2(upperOut, 0, test3.size() - 1);
		findend2 = System.nanoTime();
		System.out.println("find()2: " + (findend2-findstart2));
		difference = (findend-findstart)-(findend2-findstart2);
		System.out.println("Difference in time: " + difference);
	}

}

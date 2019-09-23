import java.util.concurrent.TimeUnit;
import java.util.Random;

public class MyHeapRunner{


	private static Integer [] smallArray;
	private static Integer [] largeArray;
	private static final int SMALLCAPACITY = 1000000;
	private static final int LARGECAPACITY = 20000000;



	public MyHeapRunner(){

		this.smallArray = new Integer [SMALLCAPACITY];
		fillSmallArray();
		this.largeArray = new Integer [LARGECAPACITY];
		fillLargeArray();


	}// END constructor



	public static void main(String [] args){

		MyHeapRunner ourHeap = new MyHeapRunner();
		long totalSeconds = 0;

		// small - ORIGINAL
		for(int i = 0; i<20; i++){

			long start = System.nanoTime(); // establish a baseline time
            MyBinaryHeap<Integer> myHeap = new MyBinaryHeap<>(smallArray);
            long end = System.nanoTime(); // what's the nanoTime now?
            long msElapsed = (end - start) / 1000000; // variance between start and stop time converted to milliseconds
            totalSeconds+= msElapsed;
		}
		System.out.println("Average Execution time in milliseconds: " + totalSeconds/20);
		totalSeconds = 0;

		// small - REVERSE
		for(int i = 0; i<20; i++){

			Integer[] myArray = rearrangeSmallReverse();

			long start = System.nanoTime(); // establish a baseline time
            MyBinaryHeap<Integer> myHeap = new MyBinaryHeap<>(myArray);
            long end = System.nanoTime(); // what's the nanoTime now?
            long msElapsed = (end - start) / 1000000; // variance between start and stop time converted to milliseconds
            totalSeconds+= msElapsed;
		}
		System.out.println("Average Execution time in milliseconds: " + totalSeconds/20);
		totalSeconds = 0;



		// small - RANDOM
		for(int i = 0; i<20; i++){

			Integer[] myArray = rearrangeSmallRandom();

			long start = System.nanoTime(); // establish a baseline time
            MyBinaryHeap<Integer> myHeap = new MyBinaryHeap<>(myArray);
            long end = System.nanoTime(); // what's the nanoTime now?
            long msElapsed = (end - start) / 1000000; // variance between start and stop time converted to milliseconds
            totalSeconds+= msElapsed;
		}
		System.out.println("Average Execution time in milliseconds: " + totalSeconds/20);
		totalSeconds = 0;

//////////////////////////////////////////////////////////////


		// large - ORIGINAL
		for(int i = 0; i<20; i++){

			long start = System.nanoTime(); // establish a baseline time
            MyBinaryHeap<Integer> myHeap = new MyBinaryHeap<>(largeArray);
            long end = System.nanoTime(); // what's the nanoTime now?
            long msElapsed = (end - start) / 1000000; // variance between start and stop time converted to milliseconds
            totalSeconds+= msElapsed;
		}
		System.out.println("Average Execution time in milliseconds: " + totalSeconds/20);
		totalSeconds = 0;

		// large - REVERSE
		for(int i = 0; i<20; i++){

			Integer[] myArray = rearrangeLargeReverse();
			long start = System.nanoTime(); // establish a baseline time
            MyBinaryHeap<Integer> myHeap = new MyBinaryHeap<>(myArray);
            long end = System.nanoTime(); // what's the nanoTime now?
            long msElapsed = (end - start) / 1000000; // variance between start and stop time converted to milliseconds
            totalSeconds+= msElapsed;
		}
		System.out.println("Average Execution time in milliseconds: " + totalSeconds/20);
		totalSeconds = 0;



		// large - RANDOM
		for(int i = 0; i<20; i++){

			Integer[] myArray = rearrangeLargeRandom();
			long start = System.nanoTime(); // establish a baseline time
            MyBinaryHeap<Integer> myHeap = new MyBinaryHeap<>(myArray);
            long end = System.nanoTime(); // what's the nanoTime now?
            long msElapsed = (end - start) / 1000000; // variance between start and stop time converted to milliseconds
            totalSeconds+= msElapsed;
		}
		System.out.println("Average Execution time in milliseconds: " + totalSeconds/20);
		totalSeconds = 0;
	}// END main method






	private static void fillSmallArray(){

		Integer val = 1;
    	for(int i = 0; i<SMALLCAPACITY; i++){
    		smallArray[i] = val; 
    		val++;
    	}
    	
	}// END fillArray method



	private static void fillLargeArray(){

		Integer val = 1;
    	for(int i = 0; i<LARGECAPACITY; i++){
    		largeArray[i] = val; 
    		val++;
    	}
	}// END fillArray method


//////////////////////////////////

	/*
	rearrangeRandom() method
	*/
	private static Integer[] rearrangeSmallRandom(){

		Random value = new Random();
		Integer[] theArray = new Integer[SMALLCAPACITY];
    	for(int i = 0; i<SMALLCAPACITY; i++){
    		theArray[i] = (Integer)value.nextInt(SMALLCAPACITY);
    	}
    	return theArray;
	}// END rearrangeRandom method



	/*
	rearrangeRandom() method
	*/
	private static Integer[] rearrangeLargeRandom(){

		Random value = new Random();
		Integer[] theArray = new Integer[LARGECAPACITY];
    	for(int i = 0; i<LARGECAPACITY; i++){
    		theArray[i] = (Integer)value.nextInt(LARGECAPACITY);
    	}
    	return theArray;
	}// END rearrangeRandom method


///////////////////////////////////

	/*
	rearrangeReverse() method
	*/
	private static Integer[] rearrangeSmallReverse(){

		Integer[] myArray = new Integer[SMALLCAPACITY];
		Integer val1 = (Integer)SMALLCAPACITY;
    	for(int i = (SMALLCAPACITY-1); i>=0; i--){
    		myArray[i] = val1;
    		val1--;
    	}
    	return myArray;
	}// END rearrangeReverse method



	/*
	rearrangeReverse() method
	*/
	private static Integer[] rearrangeLargeReverse(){

		Integer[] myArray = new Integer[LARGECAPACITY];
		Integer val1 = (Integer)LARGECAPACITY;
    	for(int i = (LARGECAPACITY-1); i>=0; i--){
    		myArray[i] = val1;
    		val1--;
    	}
    	return myArray;
	}// END rearrangeReverse method


}// END CLASS




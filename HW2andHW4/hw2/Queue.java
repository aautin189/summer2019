import java.util.NoSuchElementException;

public class Queue{

	
	private int [] queue;
	private int queueCapacity;
	private int lastPhysicalSpaceInQueue;
	private int queueSize;
	private int queueFirstIndex;
	private int queueLastIndex;



	public Queue(int capacity){
		this.queue = new int [capacity];
		this.queueCapacity = capacity;
		this.lastPhysicalSpaceInQueue = capacity-1;
		this.queueSize = 0;
		this.queueFirstIndex = 0;
		this.queueLastIndex = 0;
		configureQueue();

	}// end constructor



	public void configureQueue(){

		// fill array with unique integer values 
		int elementValue = 1;
		int lastSlot = this.lastPhysicalSpaceInQueue;

		for(int index = 0; index <= lastSlot; index++){
			enqueue(elementValue, index);
			elementValue++;
		}

	}// end configureClock method


//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@//


	// this enqueue method does not take into account the queueLastPosition value
	// because it's being told where to insert the element
	// after, it just updates 
	private void enqueue(int element, int index){


		this.queue[index] = element;
		this.queueSize++;
		this.queueLastIndex = index;


	}


//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@//


	// add element back into rotation
	public void enqueue(int element){

		int last = this.queueLastIndex;
		if(last < this.lastPhysicalSpaceInQueue){
			
			last++;
			this.queue[last] = element;
		}
		else{
			
			last = 0;
			this.queue[last] = element;
		}
		this.queueLastIndex = last;
		this.queueSize++;



	}// end enqueue method




	// returns a copy of element at positionFirst; then increments positionFirst
	public int dequeue(){
		
		// Circular Array
		// if first position IS NOT at the end of array, just increment positionFirst
		// else (the first position is at the end of array), so circle it back around to beginning
		int currentFirstIndex = this.queueFirstIndex;
		int returnElement = this.queue[currentFirstIndex];

		if(currentFirstIndex < this.lastPhysicalSpaceInQueue){
		
			currentFirstIndex++;
			
		}

		else{
		
			currentFirstIndex = 0;
			
		}

		this.queueFirstIndex = currentFirstIndex;
		this.queueSize--;

		return returnElement;

	}// end dequeue method






	public int peek(int index){
		
		int peekPosition;
		int elementAtPeek;
		if(index >= this.lastPhysicalSpaceInQueue){
			peekPosition = 0;
		}
		else{
			peekPosition = index;
		
		}
		
		elementAtPeek = this.queue[peekPosition];
		return elementAtPeek;

	}// end peek method


	
	public int getNextPosition(int index){
		int theQueueCapacity = this.lastPhysicalSpaceInQueue;
		
		if(index < theQueueCapacity){
			index++;
			return index;
		}
		else

			return 0;
	}// end getNextPosition method




	public int getCapacity(){
		return queueCapacity;
	}// end getCapacity method



	public int getFirstPosition(){
		return queueFirstIndex;
	}// end getFirstPosition method



	public int getLastPosition(){
		return queueLastIndex;
	}// end getLastPosition method



	public int getQueueSize(){
		return queueSize;
	}// end getQueueSize method






} // end Queue class


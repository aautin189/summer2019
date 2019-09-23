import java.util.NoSuchElementException;

public class Stack{


	private int[] stack;
	private int stackCapacity;
	private int stackSize;
	private int firstAvailableSlot;
	private boolean stackFull;


	

	public Stack(int capacity){
		this.stack = new int [capacity];
		this.stackCapacity = capacity;
		this.stackSize = 0;
		this.stackFull = false;
		this.firstAvailableSlot = 0;
	}// end constructor

	public Stack(int capacity, int constantElement){
		this.stack = new int [capacity];
		this.stackCapacity = capacity;
		this.stackSize = 0;
		this.stackFull = false;
		this.firstAvailableSlot = 1;
		push(constantElement, 0);
	}// end constructor



	public void push(int element){
		
		// if you push an element to the last position, set isFull = yes
		if(this.firstAvailableSlot == (this.stackCapacity-1)){
			this.stack[this.firstAvailableSlot] = element;
		
			this.stackSize++;
			this.stackFull = true;
		}
		
		else{
			this.stack[this.firstAvailableSlot] = element;
			this.firstAvailableSlot++;	
			this.stackSize++;
		}

	}// end push method



	// only used by the constructor for the Hour stack
	private void push(int element, int location){
		this.stack[location] = element;
		this.stackSize++;
	}

	public int peek(){

		return this.stack[this.firstAvailableSlot];
	}


	public int pop(){
		
	
		int returnElement = this.stack[this.firstAvailableSlot];
		if(this.firstAvailableSlot != 0){

			this.firstAvailableSlot--;
		}
		this.stackSize--;
		this.stackFull = false;

		return returnElement;
	}





	public boolean isStackFull(){
		return this.stackFull;
	}// end isStackFull method



	public int getStackSize(){
		return this.stackSize;
	}// end getStackSize method





}// end Stack class
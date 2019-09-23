import java.util.NoSuchElementException;
import java.util.Scanner;

public class BallClock{
	
	private Queue actualQueue;
	private Queue copyOfQueue;
	private Stack minuteStack;
	private Stack fiveMinuteStack;
	private Stack hourStack;
	private int minutesElapsed;
	private int numberBallsCirculating;
	private boolean stopClock;


	// CONSTRUCTOR
	public BallClock(int numBalls){
	this.actualQueue 			= new Queue(numBalls);	
	this.copyOfQueue 			= new Queue(numBalls);	
	this.minuteStack 			= new Stack(4);	
	this.fiveMinuteStack 		= new Stack(11);
	this.hourStack 				= new Stack(12, 100);
	this.minutesElapsed 		= 0;
	this.numberBallsCirculating = numBalls;
	this.stopClock				= false;



	}// end constructor



	// when running this class, pass in the text file name
	public static void main(String [] args){

		Scanner input = new Scanner(System.in);
		int balls;

		while (input.hasNextInt()){
		
			
			// read a line of input and store in variable
			balls = input.nextInt();
			

			if(balls >= 27 && balls <= 127){

				// call the start clock method
				BallClock myClock = new BallClock(balls);
				int numMinutesElapsed = myClock.startClock();
				System.out.println("For "+ balls + " balls, repetition will occur in "+ numMinutesElapsed + " minutes.");

			}
		}

	}// end main



	// Only ticks for one minute
	public int startClock(){
			
		while(this.stopClock == false){
			continueClock();
		}


		return minutesElapsed;

	}// end startClock



	public void stopClock(){
		this.stopClock = true;

	}



	private void continueClock(){
		
		if(minuteStack.isStackFull() == false){
			// dequeue and push that element to minute stack
			int elementValueDequeued = actualQueue.dequeue();
			minuteStack.push(elementValueDequeued);
			this.minutesElapsed++;

		}
		else if(fiveMinuteStack.isStackFull() == false){
			// dequeue and push that element to five minute stack
			int elementValueDequeued = actualQueue.dequeue();
			fiveMinuteStack.push(elementValueDequeued);
			this.minutesElapsed++;
			// clear minute
			clearMinute();
		}
		
		else if(hourStack.isStackFull() == false){
			// dequeue and push that element to hour stack
			int elementValueDequeued = actualQueue.dequeue();
			hourStack.push(elementValueDequeued);
			this.minutesElapsed++;
			// clear five-minute
			clearFiveMinute();
			// clear minute
			if(this.stopClock == false){
				clearMinute();
			}
			
		}
		else{

			// clear hour
			clearHour();
			// clear five-minute
			if(this.stopClock == false){
				clearFiveMinute();
			}
			
			// clear minute
			if(this.stopClock == false){
				clearMinute();
				// dequeue and push that element to minute stack
				int elementValueDequeued = actualQueue.dequeue();
				minuteStack.push(elementValueDequeued);
			}
			
		}

	}// end continueClock method






// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

	private void clearMinute(){
		
		// peek at the element first, then do comparison. If true, set stopClock
		int elementTryingToPop = minuteStack.peek();
		int elementLastInQueue = actualQueue.peek(actualQueue.getLastPosition());
		if(elementTryingToPop == (elementLastInQueue-1)){
			this.stopClock = true;
		}

		else

			for(int timesToPop = 3; timesToPop >= 0; timesToPop--){
				actualQueue.enqueue(minuteStack.pop());	
			}
	}// end clearMinute method



	private void clearFiveMinute(){
		
		// peek at the element first, then do comparison. If true, set stopClock
		int elementTryingToPop = fiveMinuteStack.peek();
		int elementLastInQueue = actualQueue.peek(actualQueue.getLastPosition());
		if(elementTryingToPop == (elementLastInQueue-1)){
			this.stopClock = true;
		}
		else
			for(int timesToPop = 10; timesToPop >= 0; timesToPop--){
				actualQueue.enqueue(fiveMinuteStack.pop());
			}
		
	}// end clearFiveMinute method



	private void clearHour(){
		
		// peek at the element first, then do comparison. If true, set stopClock
		int elementTryingToPop = hourStack.peek();
		int elementLastInQueue = actualQueue.peek(actualQueue.getLastPosition());
		if(elementTryingToPop == (elementLastInQueue-1)){
			this.stopClock = true;
		}
		else

			for(int timesToPop = 10; timesToPop >= 0; timesToPop--){
				actualQueue.enqueue(hourStack.pop());
			}
	}// end clearHour method




	public void incrementTimeElapsed(){
		this.minutesElapsed++;
	}// end method




}// end BallClock class
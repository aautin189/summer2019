
import java.util.concurrent.TimeUnit;
import java.util.Random;

/**
 * CLASS TO IMPLEMENT BINARY HEAP
 * Implements a binary heap.
 * Note that all "matching" is based on the compareTo method.
 * @author Mark Allen Weiss
 */
public class MyBinaryHeap<AnyType extends Comparable<? super AnyType>>
{
    

	// CLASS variable declarations
	private static final int DEFAULT_CAPACITY = 100;

	private int currentSize;      // Number of elements in heap
	private AnyType [ ] array; // The heap array






    /**
     * Construct the binary heap given an array of items.
     */
    public MyBinaryHeap( AnyType [ ] items )
    {

    		// given an array of objects of AnyType
            currentSize = items.length;
            array = (AnyType[]) new Comparable[ ( currentSize + 2 ) * 11 / 10 ];


            //using the buildHeap() method 
                // using an enhanced for loop to traverse the array of objects
            int i = 1;
            for( AnyType item : items )
                array[ i++ ] = item;
            buildHeap( );
    }// END constructor


//////////////////////////////////////////////////////////////////////

     /**
     * Establish heap order property from an arbitrary
     * arrangement of items. Runs in linear time.
     */
    private void buildHeap( )
    {
        for( int i = currentSize / 2; i > 0; i-- )
            percolateDown( i );
    }// END buildHeap method



    /**
     * Internal method to percolate down in the heap.
     * @param hole the index at which the percolate begins.
     */
    private void percolateDown( int hole )
    {
        int child;
        AnyType tmp = array[ hole ];

        for( ; hole * 2 <= currentSize; hole = child )
        {
            child = hole * 2;
            if( child != currentSize &&
                    array[ child + 1 ].compareTo( array[ child ] ) < 0 )
                child++;
            if( array[ child ].compareTo( tmp ) < 0 )
                array[ hole ] = array[ child ];
            else
                break;
        }
        array[ hole ] = tmp;
    }// END percolateDown() method


//////////////////////////////////////////////////////////////////////



    /**
     * Insert into the priority queue, maintaining heap order.
     * Duplicates are allowed.
     * @param x the item to insert.
     */
    public void insert( AnyType x )
    {
        if( currentSize == array.length - 1 )
            enlargeArray( array.length * 2 + 1 );

            // Percolate up
        int hole = ++currentSize;
        for( array[ 0 ] = x; x.compareTo( array[ hole / 2 ] ) < 0; hole /= 2 )
            array[ hole ] = array[ hole / 2 ];
        array[ hole ] = x;
    }// END insert() method




    private void enlargeArray( int newSize )
    {
            AnyType [] old = array;
            array = (AnyType []) new Comparable[ newSize ];
            for( int i = 0; i < old.length; i++ )
                array[ i ] = old[ i ];        
    }// END enlargeArray() method



    
    /**
     * Find the smallest item in the priority queue.
     * @return the smallest item, or throw an UnderflowException if empty.
     */
    public AnyType findMin( ) throws UnderflowException
    {
        if( isEmpty( ) )
            throw new UnderflowException( );
        return array[ 1 ];
    }// END findMin() method




    /**
     * Remove the smallest item from the priority queue.
     * @return the smallest item, or throw an UnderflowException if empty.
     */
    public AnyType deleteMin( ) throws UnderflowException
    {
        if( isEmpty( ) )
            throw new UnderflowException( );

        AnyType minItem = findMin( );
        array[ 1 ] = array[ currentSize-- ];
        percolateDown( 1 );

        return minItem;
    }// END deleteMin() method





    /**
     * Test if the priority queue is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( )
    {
        return currentSize == 0;
    }// END isEmpty() method



    /**
     * Make the priority queue logically empty.
     */
    public void makeEmpty( )
    {
        currentSize = 0;
    }// END makeEmpty() method






}// END CLASS

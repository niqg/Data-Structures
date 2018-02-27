/*
 * Purpose: Data Structure and Algorithms Lab 6 Problem 2
 * Status: Complete and thoroughly tested
 * Submitted:  03/06/17
 * Comment: 
 * @author: Niq Giordano
 * @version: 2017.03.06
 */
public class Deq<T> extends Queue<T> implements ExtendedQueueInterface<T>
{

	@Override
	public void enqueueFirst(T newItem) throws ExtendedQueueException 
	{
		if(numItems == array.length)
			resize();
			
		front = (front + array.length - 1) % array.length;
		
		
		array [front] = (T) newItem;
		numItems++;
		
	}

	@Override
	public T dequeueLast() throws ExtendedQueueException 
	{		
		back = (back + array.length - 1) % array.length;
		T temp = array[back];
		array[back] = null;
		numItems--;
		
		return temp;
	}

	@Override
	public T peekLast() throws ExtendedQueueException 
	{
		if(numItems != 0)
			return array[(back + array.length - 1) % array.length];
		else
			throw new ExtendedQueueException("Error on peek");
	}

}

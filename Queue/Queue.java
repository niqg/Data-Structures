/*
 * Purpose: Data Structure and Algorithms Lab 6 Problem 1
 * Status: Complete and thoroughly tested
 * Submitted:  03/06/17
 * Comment: 
 * @author: Niq Giordano
 * @version: 2017.03.06
 */
public class Queue<T> implements QueueInterface<T>
{
	protected T [] array;
	protected int front;
	protected int back;
	protected int numItems;
	
	public Queue()
	{
		array = (T[]) new Object[3];
		front = 0;
		back = 0;
		numItems = 0;
	}

	@Override
	public boolean isEmpty() 
	{
		return (numItems == 0 ? true : false);
	}

	@Override
	public void enqueue(T newItem) throws QueueException 
	{
		if(numItems == array.length)
			resize();
			
		array [back] = newItem;
		numItems++;
		
		back = (back + 1) % array.length;
			
	}

	@Override
	public T dequeue() throws QueueException 
	{
		if(numItems != 0)
		{
			T temp = array[front];
			array[front] = null;
			front = (front + 1) % array.length;
			numItems--;
			return temp;
		}
		else
			throw new QueueException("Error on dequeue");
	}

	@Override
	public void dequeueAll() 
	{
		array = (T[]) new Object[3];
		front = 0;
		back = 0;
		numItems = 0;
	}

	@Override
	public T peek() throws QueueException 
	{
		if(numItems != 0)
			return array[front];
		else
			throw new QueueException("Error on peek");
	}
	
	protected void resize()
	{
		
		T[] tempArray = (T[]) new Object[(numItems * 3) / 2 + 1];
		
		int index = front;
		int size = array.length;
		
		for(int j = 0 ; j < numItems ; j++)
		{
			tempArray[j] = array[index];
			index = (index + 1) % size;
		}
		
		
		array = tempArray;
		back = numItems;
		front = 0;
	}

	@Override
	public String toString()
	{
		String s = "";
		int index = front;
		int size = array.length;
		
		for(int i = 0 ; i < numItems ; i++)
		{
			s += array[index] + " ";
			index = (index + 1) % size;
		}
		
		return s;
	}
}

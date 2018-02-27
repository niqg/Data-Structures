/*
 * Purpose: Data Structure and Algorithms Lab 5 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 02/26/17
 * Submitted:  02/27/17
 * Comment:
 * @author: Nicholas Giordano
 * @version: 2017.02.27
 */
public class MyStack<T> implements StackInterface<T>
{

	T[] array;
	int numItems = 0;
	
	public MyStack()
	{
		array = (T[]) new Object[3];
	}
	
	@Override
	public boolean isEmpty() 
	{
		if(numItems == 0)
			return true;
		else
			return false;	
	}

	@Override
	public void popAll() 
	{
		array = (T[]) new Object [3];
		numItems = 0;
	}

	@Override
	public void push(T newItem) throws StackException 
	{
		
		if(array.length == numItems)
			resize();
		
		array[numItems] = newItem;
		numItems++;
	}

	@Override
	public T pop() throws StackException 
	{
		if(!isEmpty())
		{
			T t = array [numItems - 1];
			array [numItems - 1] = null;
			numItems--;
			return t;
		}
			
		else
		throw new StackException("Error on Pop");
		
	}

	@Override
	public T peek() throws StackException 
	{
		if(!isEmpty())
			return array[numItems - 1];
		
		else
			throw new StackException("Error on Peek");
	}
	
	private void resize()
	{
		T[] tempArray = (T[]) new Object[(numItems * 3) / 2 + 1];
		
		for(int i = 0 ; i < numItems ; i++)
		{
			tempArray[i] = array[i];
		}
		
		array = tempArray;
	}
	
	@Override
	public String toString()
	{
		String s = "";
		for(int i = 0 ; i < numItems ; i++)
		{
			s += array[i] + " ";
		}
		return s;
	}

}

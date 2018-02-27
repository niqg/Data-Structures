/*
 * Purpose: Data Structure and Algorithms
 * @author: Nicholas Giordano
 */
import java.util.ArrayList;

public class MyListArrayListBased implements ListInterface
{
	protected ArrayList<Object> items;
	
	public MyListArrayListBased()
	{
		items = new ArrayList <Object>();
	}
	
	public MyListArrayListBased(int i)
	{
		items = new ArrayList <Object>(i);
	}
	
	@Override
	public boolean isEmpty() 
	{
		return (items.size() == 0 ? true : false);	
	}

	@Override
	public int size() 
	{
		
		return items.size();
	}

	@Override
	public void add(int index, Object item) throws ListIndexOutOfBoundsException 
	{
		if(index <= size() && index >= 0)
			items.add(index, item);

		else
			throw new ListIndexOutOfBoundsException("Index Out Of Bounds Exception on add");
		
	}

	@Override
	public Object get(int index) throws ListIndexOutOfBoundsException 
	{
		if(index < size() && index >= 0)
			return items.get(index);
		else
			throw new ListIndexOutOfBoundsException("Index Out Of Bounds Exception on get");
		
	}

	@Override
	public void remove(int index) throws ListIndexOutOfBoundsException 
	{
		if(index < size() && index >= 0)
		{
			items.remove(index);
		}
		
		else
			throw new ListIndexOutOfBoundsException("Index Out Of Bounds Exception on remove");
		
	}

	@Override
	public void removeAll() 
	{
		items = new ArrayList<Object>();
	}

}

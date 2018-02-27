/*
 * Purpose: Data Structure and Algorithms Lab 4 Problem 1
 * Status: Complete and thoroughly tested
 * Submitted:  02/27/17
 * Comment: 
 * @author: Niq Giordano
 * @version: 2017.02.27
 */
public class ListCDLSBased implements ListInterface
{
	private NodeD head;
	private int numItems = 0;
	
	@Override
	public boolean isEmpty() 
	{
		if(numItems == 0)
			return true;
		
		else
			return false;
	}

	@Override
	public int size() 
	{
		return numItems;
	}

	@Override
	public void add(int index, Object item) throws ListIndexOutOfBoundsException 
	{
		if(index <= numItems && index >= 0)
		{
			if(head == null)
			{
				head = new NodeD (item);
				head.setNext(head);
				head.setBack(head);
			}
			else if(index == 0)
			{
				NodeD prev = head.getBack();
				NodeD temp = new NodeD (item, prev, head);
				head.setBack(temp);
				prev.setNext(temp);
				head = temp;
			}
			else
			{
				NodeD prev = find (index - 1);
			 	NodeD temp = new NodeD(item, prev, prev.getNext());
			 	prev.getNext().setBack(temp);
			 	prev.setNext(temp);
			}
			numItems ++;
		}
		else
			throw new ListIndexOutOfBoundsException("List index out of bounds exception on add");
		
	}

	@Override
	public Object get(int index) throws ListIndexOutOfBoundsException 
	{
		
		
		if(index < numItems && index >= 0)
		{
			return find(index).getItem();
		}
		else
			throw new ListIndexOutOfBoundsException("List index out of bounds exception on get");
		
	}

	@Override
	public void remove(int index) throws ListIndexOutOfBoundsException 
	{
		NodeD n = null; 
		
		if(index < numItems && index >= 0)
		{
			if (index == 0)
			{
				n = head;
				head = head.getNext();
				head.setBack(n.getBack());
				
			}
			else
			{
				n = find (index - 1);
				n.setNext(n.getNext().getNext());
				n.getNext().setBack(n);
			}
			numItems--;
		}
		else
			throw new ListIndexOutOfBoundsException("List index out of bounds exception on get");
		
	}

	@Override
	public void removeAll() 
	{
		head = null;
		numItems = 0;
		
	}
	
	private NodeD find(int index) 
	{
		NodeD curr = head;
		
		if(index <= numItems/2)
	    {    
			for (int skip = 0; skip < index; skip++) 
			{
				curr = curr.getNext();
			} 
	    }
		else
		{
			for (int skip = numItems ; skip > index; skip--)
			{
				curr = curr.getBack();
			}
		}
		
		return curr;
	}
	
	/*private NodeD find(int index) 
	{
	    NodeD curr = head;
	    for (int skip = 0; skip < index; skip++) 
	    {
	    	curr = curr.getNext();
	    } 
	    return curr;
	} 
	*/
	
	public String toString()
	{
		String s = "";
		NodeD n = head;
		
		for(int i = 0 ; i < numItems ; i++)
		{
			s += n.getItem() + " ";
			n = n.getNext();
			
		}
		return s;
	}

}

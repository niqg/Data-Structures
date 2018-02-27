/*
 * Purpose: Data Structure and Algorithms
 * @author: Nicholas Giordano
 */
public class MyListReferenceBased implements ListInterface
{

	private Node head;
	
	public MyListReferenceBased()
	{
		head = null;
	}
	@Override
	public boolean isEmpty() 
	{
		if(head == null)
			return true;
		else
			return false;
	}

	@Override
	public int size() 
	{
		int size = 1;
		Node n = head;
	
		if(n != null)
		{
			while(n.getNext() != null)
			{
				n = n.getNext();
				size++;
			}
		}
		else
			size = 0;
		
		return size;
	}

	@Override
	public void add(int index, Object item) throws ListIndexOutOfBoundsException 
	{
		
		if(index <= size() && index >= 0)
		{
			if(index == 0)
			{
				head = new Node (item, head);
			}
			else
			{
				Node prev = find (index - 1);
			 	Node temp = new Node(item, prev.getNext());
			 	prev.setNext(temp);
			}
		}
		else
			throw new ListIndexOutOfBoundsException("List index out of bounds exception on add");
		
		
	}

	@Override
	public Object get(int index) throws ListIndexOutOfBoundsException 
	{
		Node n = null;
		
		if(index < size() && index >= 0)
		{
			n = find(index);
			return n.getItem();
		}
		else
			throw new ListIndexOutOfBoundsException("List index out of bounds exception on get");
		
		
	}

	@Override
	public void remove(int index) throws ListIndexOutOfBoundsException 
	{
		Node n = null; 
		
		if(index < size() && index >= 0)
		{
			if (index == 0)
				head = head.getNext();
			else
			{
			n = find (index - 1);
			n.setNext(n.getNext().getNext());
			}
		}
		else
			throw new ListIndexOutOfBoundsException("List index out of bounds exception on get");
		
	}

	@Override
	public void removeAll() 
	{
		head = null;	
	}
	
	private Node find(int index) 
	  {
	    Node curr = head;
	    for (int skip = 0; skip < index; skip++) 
	    {
	    	curr = curr.getNext();
	    } 
	    return curr;
	  } 
	
	@Override
	public String toString()
	{
		int size = size();
		String s = "";
		Node n = head;
		
		for(int i = 0 ; i < size ; i++)
		{
			s += n.getItem() + " ";
			n = n.getNext();
			
		}
		return s;
	}

}

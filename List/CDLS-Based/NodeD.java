/*
 * Purpose: Data Structure and Algorithms Lab 4 Prelab
 * Status: Complete and thoroughly tested
 * Submitted:  02/27/17
 * Comment: 
 * @author: Niq Giordano
 * @version: 2017.02.27
 */
public class NodeD 
{
	 private Object item;
	 private NodeD next;
	 private NodeD back;

	  public NodeD(Object newItem) 
	  {
	    item = newItem;
	    next = null;
	    back = null;
	  } // end constructor

	  public NodeD(Object newItem, NodeD previousNode, NodeD nextNode) 
	  {
	    item = newItem;
	    back = previousNode;
	    next = nextNode;
	    
	  } // end constructor

	  public void setItem(Object newItem) 
	  {
	    item = newItem;
	  } // end setItem

	  public Object getItem() 
	  {
	    return item;
	  } // end getItem

	  public void setNext(NodeD nextNode) 
	  {
	    next = nextNode;
	  } // end setNext

	  public NodeD getNext() 
	  {
	    return next;
	  } // end getNext
	  
	  public void setBack(NodeD previousNode)
	  {
		  back = previousNode;
	  }
	  
	  public NodeD getBack() 
	  {
	    return back;
	  }
}

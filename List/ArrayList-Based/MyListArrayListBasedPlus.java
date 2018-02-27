/*
 * Purpose: Data Structure and Algorithms
 * @author: Nicholas Giordano
 */
public class MyListArrayListBasedPlus extends MyListArrayListBased
{
	@Override
	public String toString()
	{
		String s = "";
		
		int size = size();
		for(int i = 0 ; i < size ; i++)
		{
			s += items.get(i) + " ";
		}
		return s;
	}
	
	public void reverse()
	{
		int mid = size()/2;
		int j = size() -1;
		
		for (int i = 0 ; i < mid ; i++)
		{
			Object temp = super.get(i);
			
			items.remove(i);
			items.add(i, items.get(j - 1));
			items.remove(j);
			items.add(j, temp);
				
		}
		
		
	}
}


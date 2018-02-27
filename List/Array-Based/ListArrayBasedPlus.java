
public class ListArrayBasedPlus extends ListArrayBased
{
	
	public void add(int index , Object item)
	{
		if(numItems == items.length)
			resize();
		
		super.add(index, item);
		
	}
	
	public void resize()
	{
		int resizeVariable = numItems/3;
		Object [] resizedArray = new Object [resizeVariable + numItems];
		
		for (int i = 0 ; i < numItems ; i++)
		{
			resizedArray[i] = items[i];
		}
		
		items = resizedArray;
	}
	
	public void reverse()
	{
		Object [] reversedArray = new Object [items.length];
		int reversedVariable = 0;
		
		for (int i = numItems - 1 ; i >= 0 ; i--)
		{
			reversedArray[reversedVariable] = items [i];
			reversedVariable++;
		}
		
		items = reversedArray;
	}
	
	@Override
	public String toString()
	{
		String s = "";
		
		for (int i = 0 ; i < numItems ; i++)
		{
			s += items[i] + " ";
		}
		return s;
	}
	

}

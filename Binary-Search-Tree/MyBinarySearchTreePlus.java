
public class MyBinarySearchTreePlus<T extends KeyedItem<KT>,KT extends Comparable<? super KT>> extends MyBinarySearchTree implements BSTPInterface
{

	@Override
	public int getHeight() 
	{
		int n = 0;
		
		if(root != null)
			n += getHeight(root);
		
		return n;
	}

	@Override
	public int getSize() 
	{
		int n = 0;
		
		if(root != null)
		{
			n = getSize(root);
		}
		
		return n;
	}

	@Override
	public String toStringInorder() 
	{
		String s = "";
		if(root != null)
			s = toStringInorder(root);
		
		return s;
	}

	@Override
	public String toStringPreorder() 
	{
		String s = "";
		if(root != null)
			 s = toStringPreorder(root);
		
		return s;
	}

	@Override
	public String toStringPostorder() 
	{
		String s = "";
		if(root != null)
			s = toStringPostorder(root);
		
		return s;
	}

	@Override
	public MyBinarySearchTreePlus<T , KT> getCopyOfTree() 
	{
		MyBinarySearchTreePlus<T , KT> tree = new MyBinarySearchTreePlus<T,KT>();
		return getCopyOfTree(root, tree);
		
	}
	
	private int getSize(TreeNode<T> node)
	{
		int n = 0;
		
		if(node.getLeftChild() != null)
		{
			n += getSize(node.getLeftChild());
		}
			
		if(node.getRightChild() != null)
		{
			n += getSize(node.getRightChild());
		}
		
		return n += 1;
		
	}
	
	private String toStringPostorder(TreeNode<T> node)
	{
		String s = "";
		
		if(node != null)
			s += toStringPostorder(node.getLeftChild())
				+ " " + toStringPostorder(node.getRightChild())
				+ " " +node.getItem().getKey();
		
		
		return s;
	}
	
	private String toStringPreorder(TreeNode<T> node)
	{
		String s = "";
		
		if(node != null)
			s += node.getItem().getKey()
				+ " " + toStringPreorder(node.getLeftChild())
				+ " " + toStringPreorder(node.getRightChild());
		
		
		return s;
		
	}
	
	private String toStringInorder(TreeNode<T> node)
	{
		String s = "";
		
		if(node != null)
			s += toStringInorder(node.getLeftChild())
				+ " " + node.getItem().getKey()
				+ " " + toStringInorder(node.getRightChild());
		
		
		return s;
		
	}

	private int getHeight(TreeNode<T> node)
	{
		if(node == null)
			return 0;
		else
		{
			int left = getHeight(node.getLeftChild()) + 1;
			int right = getHeight(node.getRightChild()) + 1;
			
			return (left > right ? left : right);
		}
	}

	private MyBinarySearchTreePlus<T , KT> getCopyOfTree(TreeNode<T> node , MyBinarySearchTreePlus<T , KT> tree) 
	{
		if(node != null)
		{
			tree.insert(node.getItem());
			getCopyOfTree(node.getLeftChild() , tree);
			getCopyOfTree(node.getRightChild() , tree);
		}
		return tree;
	}
}

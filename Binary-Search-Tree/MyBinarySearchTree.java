
/*
 * Purpose: Data Structure and Algorithms
 * @author: Nicholas Giordano
 */
public class MyBinarySearchTree<T extends KeyedItem<KT>,KT extends Comparable<? super KT>>extends BinarySearchTree
{
	protected T iterativeFindLeftmost(TreeNode<T> tNode)  
	{
	   TreeNode<T> leftMost = tNode;
		while(leftMost.getLeftChild() != null)
	    {
	    	leftMost = leftMost.getLeftChild();
	    } 
	    return leftMost.getItem();
	}
	protected T iterativeRetrieve(TreeNode<T> tNode,
            KT searchKey)  
	{
		 	T treeItem = null;
		 	TreeNode<T> node = tNode;
		    
		 	while(node != null)
		 	{
		 		T nodeItem = node.getItem();
		 		
		 		if (searchKey.compareTo(nodeItem.getKey()) == 0)
		 			treeItem = tNode.getItem();
		      
		 		else if (searchKey.compareTo(nodeItem.getKey()) < 0)
		 			node = node.getLeftChild();

		 		else
		 			node = node.getRightChild();
		      
		 	}  // end if
		 		return treeItem;
	}
		   // end retrieveItem
	
}

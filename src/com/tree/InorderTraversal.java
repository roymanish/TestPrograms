/**
 * 
 */
package com.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author MaRoy
 *
 */

	public class InorderTraversal {

		Node prev;
		static int maxHeight = 0;
		public static void main(String[] args){					//          2
																//      7       5
			InorderTraversal it = new InorderTraversal();       //   2    6         9
			Node n1 = new Node(2);                              //      5   11    4
																//                  12
			Node n2 = new Node(7);								//Post Order : 2 5 11 6 7 4 9 5 2
			Node n3 = new Node(5);								//Pre Order  : 2 7 2 6 5 11 5 9 4
			Node n4 = new Node(2);								//In Order   : 2 7 5 6 11 2 5 4 9  
			Node n5 = new Node(6);								//Level Order: 2 7 5 2 6 9 5 11 4 12
			Node n6 = new Node(9);
			Node n7 = new Node(5);
			Node n8 = new Node(11);
			Node n9 = new Node(4);
			Node n10 = new Node(12);
			
			n1.left = n2;
			n1.right = n3;
			
			n2.left = n4;
			n2.right = n5;
			
			n5.left = n7;
			n5.right = n8;
			
			n3.right = n6;
			n6.left = n9;
			
			//n9.right = n10;
			
			//it.inOrder(n1);
			//it.getMaxHeight(n1, 0);
			//System.out.println("Max Height:"+maxHeight);
			
			levelOrderTraversal(n1);
		}
		
		void inOrder (Node root)
		{
		 
		  if(root == null) return;
		  
		  inOrder( root.leftNode() );
		  inOrder( root.rightNode() );
		  
		  System.out.println(root.getNodeValue());
		  
		}
		
		void getMaxHeight(Node root,int height){
			
			if(root == null){
				if(height > maxHeight){
					maxHeight = height;
					
				}
				height = 0;
				return;
			}
			
			getMaxHeight(root.left, height++);
			getMaxHeight(root.right, height++);
		}
		
		public static void levelOrderTraversal(Node startNode) {  
	        Queue<Node> queue=new LinkedList<Node>();  
	        queue.add(startNode);  
	        while(!queue.isEmpty())  
	        {  
	        	Node tempNode=queue.poll();  
	            System.out.println(tempNode.getNodeValue());  
	            if(tempNode.left!=null)  
	                queue.add(tempNode.left);  
	            if(tempNode.right!=null)  
	                queue.add(tempNode.right);  
	        }  
	    }
		
	}

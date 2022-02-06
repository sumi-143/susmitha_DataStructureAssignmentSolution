package com.greatlearning.Driver;

import java.util.ArrayList;

import com.greatlearning.Service.BinarySearchTreeTraversal;
import com.greatlearning.Service.Node;

public class Driver {

	public static void main(String[] args) {
		Node root = new Node(50);
		root.leftNode = new Node(30);
		root.leftNode.leftNode = new Node(10);
		root.rightNode = new Node(60);
		root.rightNode.leftNode = new Node(55);
	
		ArrayList<Integer> output = BinarySearchTreeTraversal.traversal(root);
		System.out.println("Output Tree =>");
		for(int i = 0;i< output.size();i++) {
			if(i == output.size()-1) {
				System.out.print(output.get(i) +" ");
			}
			else {
				System.out.print(output.get(i) + " ");
			}
		}
		

	}

}

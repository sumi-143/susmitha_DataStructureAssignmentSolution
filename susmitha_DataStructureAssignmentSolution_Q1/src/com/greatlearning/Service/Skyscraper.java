package com.greatlearning.Service;

import java.util.Arrays;
import java.util.Stack;

public class Skyscraper {
	static boolean largestNumber;
	static boolean addFlag;
	
	@SuppressWarnings("unchecked")
	public static void calculateFloors(int[] floorSize) {
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0;i<floorSize.length;i++) {
			
			largestNumber = true;
			int floorSize_of_i_value = floorSize[i];
			
			for(int j =i;j<floorSize.length;j++) {
				if(j == i) {
					continue;
				}
				else {
					
					int floorSize_of_j_value = floorSize[j];
					if(floorSize_of_i_value >= floorSize_of_j_value) {
						largestNumber = true;
						continue;
					}
					else {
						
						largestNumber = false;
						stack.push(floorSize_of_i_value);
						break;
					}
				}
			}
			if(largestNumber == true) {
				try {
					Stack stacktemp = displayFloor(stack,floorSize_of_i_value,i,floorSize);
					stack.clear();
					stack =(Stack<Integer>)stacktemp.clone();
					stacktemp.clear();
					System.out.println();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			else {
				System.out.println("Day"+(i+1)+ ": \n");
			}
		}
	}


	public static  Stack<Integer> displayFloor( Stack<Integer> stack, int currentFloor, int iter, int[] arrayFloor) {
		
		int[] arrayOfPoppedItems = new int[arrayFloor.length];
		int count = 0;
		System.out.print("Day"+ (iter+1)+ ": \n" + currentFloor);
		Stack<Integer> stacktemp = new Stack<Integer>();
		boolean largestInStack;
		if(iter == arrayFloor.length -1) {
			while(!stack.empty()) {
					int popFloor = (int) stack.pop();
					arrayOfPoppedItems[count++] = popFloor;
			}
			if(arrayOfPoppedItems != null) {
				Arrays.sort(arrayOfPoppedItems);
				for(int i = arrayOfPoppedItems.length -1 ;i>0;i--) {
						if(arrayOfPoppedItems[i]!= 0) {
							System.out.print(" " +arrayOfPoppedItems[i]);
						}
				}
			}
			return stacktemp;
			
		}
		else {
			if(!stack.empty()) {
				
				while(!stack.empty()) {
					largestInStack = true;
					int popFloor = (int) stack.pop();
					for(int i = iter; i<arrayFloor.length;i++) {
						if(i == iter) {
							continue;
						}
						if(popFloor<arrayFloor[i]) {
							stacktemp.push(popFloor);
							largestInStack = false;
							break;	
						}
						else {
							largestInStack = true;
						}
					}
					if(largestInStack == true) {
						arrayOfPoppedItems[count++] = popFloor;
					}
				}
			}
			
			if(arrayOfPoppedItems != null) {
				Arrays.sort(arrayOfPoppedItems);
				for(int i = arrayOfPoppedItems.length -1;i>0;i--) {
					if(arrayOfPoppedItems[i] != 0) {
						System.out.print(" "+ arrayOfPoppedItems[i]);
					}
				}
			}
			return stacktemp;
		}
		
		
	}

}

package PriorityQueue;

import java.util.PriorityQueue;
import java.util.Scanner;
/*
LeetCode Number 215 : https://leetcode.com/problems/kth-largest-element-in-an-array/
Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
*/
public class KthMaxElement {
    public static int kthMaxEle(int[] array, int k){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // adding first k elements
        for(int i=0 ; i<k ; i++){
            priorityQueue.add(array[i]);
        }

        // now start from kth index
        for(int i=k ; i<array.length ; i++){
            // if the peek element is smaller than array[i] then remove peek element
            // and add array[i] into the priority queue
            if(priorityQueue.peek() < array[i]){
                priorityQueue.poll();
                priorityQueue.add(array[i]);
            }
        }
        return priorityQueue.peek();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of test cases:");
        int t = sc.nextInt();
        while (t-- > 0){
            System.out.println("Enter the size of the array:");
            int size = sc.nextInt();

            int[] array = new int[size];
            System.out.println("Enter elements of the array:");
            for(int i=0 ; i<size ; i++){
                array[i] = sc.nextInt();
            }

            System.out.println("Enter value of K:");
            int k = sc.nextInt();

            System.out.println(kthMaxEle(array, k));
        }
    }
}

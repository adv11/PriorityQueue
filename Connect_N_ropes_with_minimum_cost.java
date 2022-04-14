package PriorityQueue;

import java.util.PriorityQueue;
import java.util.Scanner;
/*
GFG Link : https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1#

There are given N ropes of different lengths, we need to connect these ropes into one rope.
The cost to connect two ropes is equal to sum of their lengths. The task is to connect the ropes with minimum cost.

Example 1:

Input:
n = 4
arr[] = {4, 3, 2, 6}
Output:
29
Explanation:
For example if we are given 4
ropes of lengths 4, 3, 2 and 6. We can
connect the ropes in following ways.
1) First connect ropes of lengths 2 and 3.
Now we have three ropes of lengths 4, 6
and 5.
2) Now connect ropes of lengths 4 and 5.
Now we have two ropes of lengths 6 and 9.
3) Finally connect the two ropes and all
ropes have connected.
Total cost for connecting all ropes is 5
+ 9 + 15 = 29. This is the optimized cost
for connecting ropes. Other ways of
connecting ropes would always have same
or more cost. For example, if we connect
4 and 6 first (we get three strings of 3,
2 and 10), then connect 10 and 3 (we get
two strings of 13 and 2). Finally, we
connect 13 and 2. Total cost in this way
is 10 + 13 + 15 = 38.
Example 2:

Input:
n = 5
arr[] = {4, 2, 7, 6, 9}
Output:
62
Explanation:
First, connect ropes 4 and 2, which makes
the array {6,7,6,9}. Next, add ropes 6 and
6, which results in {12,7,9}. Then, add 7
and 9, which makes the array {12,16}. And
finally add these two which gives {28}.
Hence, the total cost is 6 + 12 + 16 +
28 = 62.
Your Task:
You don't need to read input or print anything. Your task isto complete the function minCost() which takes 2 arguments and returns the minimum cost.

Expected Time Complexity : O(nlogn)
Expected Auxiliary Space : O(n)

Constraints:
1 ≤ N ≤ 100000
1 ≤ arr[i] ≤ 106
*/

/*
Proof :
Let there are 3 ropes A, B and C where A>B>C

Case 1 : Without sorting
arr = [A, B, C], cost1 = 0
arr = [A+B, C], cost1 = A+B
arr = [A+B+C], cost1 = A+B+A+B+C = 2A+2B+C

Case 2 : With sorting
arr = [A, B, C], cost2 = 0
arr = [A, B+C], cost2 = B+C
arr = [A+B+C], cost2 = B+C+A+B+C = A+2B+2C

Because A>B>C
so, cost1 > cost2 that's why we are using min heap for solving this problem because min heap sorts the array.
*/
public class Connect_N_ropes_with_minimum_cost {
    public static int minCost(int[] array){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        // adding elements into the priority queue
        for(int i : array){
            priorityQueue.add(i);
        }

        int minimumCost = 0;    // for calculating minimum cost
        // while size of priority queue is > 1
        while (priorityQueue.size() > 1){
            // remove top minimum elements
            int newRopeLength = priorityQueue.poll() + priorityQueue.poll();
            // add newRopeLength which is sum of the minimum 2 ropes into the priority queue
            priorityQueue.add(newRopeLength);
            // add their sum into the minimumCost
            minimumCost += newRopeLength;
        }
        return minimumCost;
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

            System.out.println("Minimum cost is : " + minCost(array));
        }
    }
}

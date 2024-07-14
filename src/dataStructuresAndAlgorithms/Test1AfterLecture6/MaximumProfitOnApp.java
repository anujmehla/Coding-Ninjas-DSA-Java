package dataStructuresAndAlgorithms.Test1AfterLecture6;

import java.util.Arrays;

/*
Question : Maximum profit on App
Problem statement
You have made a smartphone app and want to set its subscription price such that the profit earned is maximised.
There are certain users who will subscribe to your app only if their budget is greater than or equal to your price.

You will be provided with a list of size N having budgets of subscribers, and you need to return the maximum profit that
you can earn.

Let's say you decide that price of your app is Rs. x and there are N number of subscribers.
So maximum profit you can earn is :

 m * x
where m is total number of subscribers whose budget is greater than or equal to x.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= N <= 10^6

1 <=budget[i]<=9999

Sample Input 1 :
4
30 20 53 14
Sample Output 1 :
60
Sample Output 1 Explanation :
Price of your app should be Rs. 20 or Rs. 30. For both prices, you can get the profit Rs. 60.
Sample Input 2 :
5
34 78 90 15 67
Sample Output 2 :
201
Sample Output 2 Explanation :
Price of your app should be Rs. 67. You can get the profit Rs. 201 (i.e. 3 * 67).
 */
public class MaximumProfitOnApp {
    public static void main(String[] args) {
        int[] budget = {30,20,53,14};
        System.out.println(maximumProfit(budget));
    }
    public static int maximumProfit(int[] budget) {
        // Sort the budgets array
        Arrays.sort(budget);
        // Initialize the variable to keep track of maximum profit
        int maxProfit = 0;
        // Iterate over the sorted budgets
        for (int i = 0; i < budget.length; i++) {
            // Calculate profit for the current price point
            int profit = budget[i] * (budget.length - i);
            // Update maxProfit if the calculated profit is greater
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        // Return the maximum profit found
        return maxProfit;
    }
}

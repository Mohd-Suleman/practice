package leetcode150;

public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println("To complete circuit, start from index: "+canCompleteCircuit(gas, cost));
    }

    // Write down approach......
    // Explanation: https://www.youtube.com/watch?v=fOaUh1_fJPw
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        for(int i=0; i<gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if(totalGas < totalCost)
            return -1;
        int currentGas = 0;
        int index = 0;

        for(int j=0; j<gas.length; j++) {
            currentGas += gas[j]-cost[j];

            if(currentGas < 0) {
                currentGas = 0;
                index = j+1;
            }
        }
        return index;
    }
}

package pluse.sixty;

import java.util.Map;

public class MinimumCoin {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 7;
        System.out.println("Minimum Coin(s) required: "+optimized(coins, amount));
    }

    public static int optimized(int[] coins, int amount) {
        if(amount == 0 || coins == null) {
            return -1;
        }
        int[] dpCoins = new int[amount+1];

        for(int i=1; i<=amount; i++) {
            dpCoins[i] = Integer.MAX_VALUE;
            for(int coin: coins) {
                if(coin <= i && dpCoins[i-coin] != Integer.MAX_VALUE)
                    dpCoins[i] = Math.min(dpCoins[i], 1+dpCoins[i-coin]);
            }
        }
        if(dpCoins[amount] == Integer.MAX_VALUE)
            return -1;
        return dpCoins[amount];
    }
}

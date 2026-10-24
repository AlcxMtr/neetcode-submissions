class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int numGoodCoins = 0;
        for (int coin : coins) if (coin <= amount) numGoodCoins++;
        coins = Arrays.copyOf(coins, numGoodCoins);
        Arrays.sort(coins);
        if (coins.length == 0) return -1;
        int factor = coins[coins.length-1];
        int[] dp1 = new int[factor];
        int[] dp2 = new int[factor];
        for (int coin : coins) {
            if (coin == 0) continue;
            dp1[coin-1] = 1;
        }
        int floor = 1;
        for (; floor <= amount; floor += factor) {
            for (int i = 0; i < factor; i++) {
                int prevCount = dp1[i];
                if (prevCount == 0) continue;
                for (int coin : coins) {
                    int idx = i + coin;
                    int[] modify;
                    if (idx >= factor) {
                        idx -= factor;
                        modify = dp2;
                        if (floor+factor > amount) continue;
                    } else {
                        modify = dp1;
                    }
                    int newCount = modify[idx];
                    if (newCount == 0 || prevCount+1 < newCount) {
                        modify[idx] = prevCount+1;
                    }
                }
            }
            if (floor+factor <= amount) dp1 = dp2;
            dp2 = new int[factor];
        }
        int result = dp1[amount-(floor-factor)];
        if (result == 0) return -1;
        return result;
    }
}

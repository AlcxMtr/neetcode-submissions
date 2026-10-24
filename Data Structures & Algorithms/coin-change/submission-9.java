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
        // for (int i = 0; i < dp1.length; i++) {
        //     System.out.print(i + ":" + dp1[i] + ", ");
        // }
        System.out.println("");
        System.out.println("factor: " + factor);
        int floor = 1;
        for (; floor <= amount; floor += factor) {
            System.out.println("floor+factor: " + (floor+factor));
            // System.out.println("=== " + floor + " ====");
            for (int i = 0; i < factor; i++) {
                int prevCount = dp1[i]; // 1
                if (prevCount == 0) continue;
                for (int coin : coins) {
                    int idx = i + coin; // 1
                    // System.out.print("i: " + i + " | coin: " + coin + " | idx: " + idx + " | ");
                    int[] modify;
                    if (idx >= factor) { // false
                        idx -= factor;
                        modify = dp2;
                        if (floor+factor > amount) continue;
                        // System.out.print("mod: dp2 | ");
                    } else {
                        modify = dp1;
                        // System.out.print("mod: dp1 | ");
                    }
                    int newCount = modify[idx]; // 1
                    if (newCount == 0 || prevCount+1 < newCount) {
                        // System.out.print("set idx: " + idx + " to: " + (prevCount+1) + " | ");
                        modify[idx] = prevCount+1;
                    }
                    // System.out.println("");
                }
                // for (int num : dp1) {
                //     System.out.print(num + ", ");
                // } 
                // System.out.print("|| ");
                // for (int num : dp2) {
                //     System.out.print(num + ", ");
                // }
                // System.out.println("");
            }
            if (floor+factor <= amount) dp1 = dp2;
            System.out.println((floor+factor) + " completed: ");
            for (int i = 0; i < dp1.length; i++) {
                System.out.print(i + ":" + dp1[i] + ", ");
            }
            System.out.println("");
            dp2 = new int[factor];
        }
        int result = dp1[amount-(floor-factor)];
        if (result == 0) return -1;
        return result;
    }
}

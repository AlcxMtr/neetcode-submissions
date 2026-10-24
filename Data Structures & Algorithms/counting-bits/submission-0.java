class Solution {
    public int[] countBits(int n) {
        int counters[] = new int[n+1];
        counters[0] = 0;
        if (n >= 1) counters[1] = 1;
        int pow = 1;
        for (int i = 2; i <= n; i++) {
            if ((pow << 1 & i) != 0) pow <<= 1; // stores most important bit
            int dp = i ^ pow;
            System.out.println("i: " + i + ", pow: " + pow + ", dp: " + dp + ", counters[dp]: " + counters[dp]);
            counters[i] = counters[dp] + 1;
        }
        return counters;
    }
}

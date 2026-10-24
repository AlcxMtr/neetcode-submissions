class Solution {
    public int hammingWeight(int n) {
        int counter = 0;
        for (int i = 0; i < 32 && n > 0; i++) {
            System.out.println("Iteration: " + i + ":");
            if (n%2 == 1) counter++;
            System.out.println("n: " + n + ", n%2: " + n%2 + ", counter: " + counter);
            n >>= 1;
        }
        return counter;
    }
}

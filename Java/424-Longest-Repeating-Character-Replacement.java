class Solution {

    public int characterReplacement(String s, int k) {

        int n = s.length();
        int[] f = new int[256];

        int low = 0;
        int high = 0;

        int res = Integer.MIN_VALUE;

        for (high = 0; high < n; high++) {

            f[s.charAt(high)]++;

            int maxcnt = find(f);

            int len = high - low + 1;

            int diff = len - maxcnt;

            while (diff > k) {

                f[s.charAt(low)]--;

                low++;

                maxcnt = find(f);

                len = high - low + 1;

                diff = len - maxcnt;
            }

            res = Math.max(res, len);
        }

        return res;
    }

    public int find(int[] f) {

        int max = 0;

        for (int i = 0; i < f.length; i++) {
            max = Math.max(max, f[i]);
        }

        return max;
    }
}
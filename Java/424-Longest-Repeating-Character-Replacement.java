class Solution {

    int find(int[] a) {
        int maxc = -1;

        for (int i = 0; i < 256; i++) {
            maxc = Math.max(maxc, a[i]);
        }

        return maxc;
    }

    public int characterReplacement(String s, int k) {

        int[] f = new int[256];

        int low = 0;
        int res = 0;

        for (int high = 0; high < s.length(); high++) {

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
}
class Solution {

    int find(int[] a) {

        int maxc = -1;

        for (int i = 0; i < 256; i++) {
            maxc = Math.max(maxc, a[i]);
        }

        return maxc;
    }

    public int characterReplacement(String s, int k) {

        int n = s.length();

        int[] f = new int[256];

        int low = 0;
        int res = 0;

        for (int high = 0; high < n; high++) {

            // Current character ki frequency increase
            f[s.charAt(high)]++;

            // Window mein maximum frequency
            int maxcnt = find(f);

            // Window length
            int len = high - low + 1;

            // Required replacements
            int diff = len - maxcnt;

            // Window invalid hai
            while (diff > k) {

                // Left character remove
                f[s.charAt(low)]--;

                // Left pointer move
                low++;

                // New maximum frequency
                maxcnt = find(f);

                // New window length
                len = high - low + 1;

                // New replacements required
                diff = len - maxcnt;
            }

            // Maximum answer
            res = Math.max(res, len);
        }

        return res;
    }
}
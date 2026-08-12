class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>(); // Ye ek empty container hai  jisme hum milne wale triplets store karenge. result = answers ki basket.

        Arrays.sort(nums);// it is use to sort the array.

        for (int i = 0; i < nums.length - 2; i++) { //i fix kar diye.

            if (i > 0 && nums[i] == nums[i - 1]) { // duplicate i ko skip karne ke liye he.
                continue;
            }

            int j = i + 1;   //j hamesha i ke just next se start karega.
            int k = nums.length - 1;    //k array ke last element par rahega.

            while (j < k) {

                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    while (j < k && nums[j] == nums[j + 1]) {  // j skip
                        j++;
                    }

                    while (j < k && nums[k] == nums[k - 1]) { // k skip
                        k--;
                    }

                    j++; // value store kar ke next list me badaye ga 
                    k--;

                } else if (sum < 0) {
                    j++;

                } else { // (sum > 0)
                    k--;
                }
            }
        }

        return result;
    }
}          
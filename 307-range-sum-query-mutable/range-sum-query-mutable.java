class NumArray {
    int[] bit;
    int[] nums;
    int n;

    public NumArray(int[] nums) {
        n = nums.length;
        bit = new int[n + 1];
        this.nums = new int[n];

        for (int i = 0; i < n; i++) {
            update(i, nums[i]);
        }
    }

    public void update(int index, int val) {
        int delta = val - nums[index];
        nums[index] = val;

        index++;
        while (index <= n) {
            bit[index] += delta;
            index += index & (-index);
        }
    }

    private int prefixSum(int index) {
        index++;
        int sum = 0;

        while (index > 0) {
            sum += bit[index];
            index -= index & (-index);
        }

        return sum;
    }

    public int sumRange(int left, int right) {
        return prefixSum(right) - prefixSum(left - 1);
    }
}
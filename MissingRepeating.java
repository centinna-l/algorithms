import java.util.Arrays;

class MissingRepeating {
    public static void findMissingAndDuplicate(int[] nums) {
        int n = nums.length;
        int i = 0;

        while (i < n) {
            if (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }

        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                System.out.println("Missing number: " + (i + 1));
                System.out.println("Duplicate number: " + nums[i]);
                break;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 2, 5, 2 }; // Sample input array
        findMissingAndDuplicate(nums);
    }
}

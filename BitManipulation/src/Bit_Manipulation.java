import java.util.*;

public class Bit_Manipulation {
    // Leetcode Question No 2220  --> Minimum Bit Flips to Convert Number
    public int minBitFlips(int start, int goal) {
        int count = 0;
        int num = start ^ goal;

        while(num != 0){
            if((num & 1)==1){
                count++;
            }
            num = num >> 1;
        }
        return count;
    }

    // Question -->Check if the i-th bit is Set or Not brute force approach
    public boolean checkIthBit(int n, int i) {
        StringBuilder s = new StringBuilder("");

        while(n!=0){
            s.append(n%2);
            n = n/2;
        }

        int x = s.length();

        if(i>=x) return false;
        return s.charAt(i)=='1';
    }

    // Check if the i-th bit is Set or Not optimal approach
    public boolean checkIthBitOptimal(int n, int i){
        return (n & (1 << i)) != 0;
    }

    //leetcode Question no --> Check if a Number is Power of 2 or Not brute force approach
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;

        while(n%2==0){
            n=n/2;
        }

        return n==1;
    }

    // Check if a Number is Power of 2 or Not optimal approach
    public boolean isPowerOfTwoOptimal(int n){
        return n > 0 && (n & (n-1))==0;
    }  // n & (n - 1) → rightmost 1 ko uda deta hai

    // LeetCode Question No -78 subset
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        int total = 1 << n;

        for (int num = 0; num < total; num++) {
            List<Integer> curr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if ((num & (1 << i)) != 0) {
                    curr.add(nums[i]);
                }
            }
            ans.add(curr);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}

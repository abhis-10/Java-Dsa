package recursion.src;

import java.util.*;

public class Recursion {
    public static int SumOfNum(int n){
        if(n==0) return 0;

        return n + SumOfNum(n-1);
    }
    public static void printName(int n){
        if(n==0)return;

        System.out.println("Abhishek");
        printName(n-1);
    }
    public static void printNum(int n){
        if(n>10) return;
        System.out.println(n);
        printNum(n+1);
    }
    public static void revPrintNum(int n){
        if(n==0) return;
        System.out.println(n);
        revPrintNum(n-1);
    }
    public static void backTrackPrintNum(int n){
        if(n<1) return;
        backTrackPrintNum(n-1);
        System.out.println(n);
    }
    public static void sumParam(int n , int sum ){
        if(n==0){
            System.out.println(sum); // paramterized rec prints
            return;
        }
        sumParam(n-1,sum+n); // parameterized recursion
    }
    public static void factorial(int n  , int res){
        if(n==0){
            System.out.print(res);
            return;
        }
        factorial(n-1,res*n);
    }
    public static int factorialFunc(int n){
        if(n==0)return 1; // fuctional recu returns
        return n * factorialFunc(n-1); // functional recurison
    }
    public static double power(double x, int n){
        if(n == 0) return 1;

        if(n < 0){
            return 1 / power(x , -n);
        }
        double half = power(x,n/2);

        if(n % 2 == 0){
            return half * half;
        }else{
            return x * half * half;
        }
    }
    
    /*Leetcode Question --> 1922. Count Good Numbers*/
    static private long M = 1000000007;
    public static long findPower(long a, long b){
        if(b == 0) return 1;

        long half = findPower(a,b/2); // binary exponentiation --> ye hi hum lograthemic time dega.
        long result = (half * half) % M; // modulo M isilye kar rha hu kyuki ans limit ke andar rhe overflow na kre.

        if(b % 2 == 1) return  (result * a) % M;
        return  result;
    }
    public static int countGoodDigits(long n){
        // step 1 . count the number of even and odd indices
        long evenCount = (n+1)/2; // exponent (power) for even count;
        long oddCount = n/2; // expoent (power) for odd count;

        // step 2. need to total find actual no of good digits using below formula
        long ans = (findPower(5 , evenCount) * findPower(4 , oddCount)) % M;
        return  (int) ans;
    }
    /*QUESTION ENDS HERE*/

    /*Question --> Sort the Stack Recursively*/
    public static Deque<Integer> sortStack(Deque<Integer> stack){
      if(stack.isEmpty() || stack.size()==1) return stack;

      int topElement = stack.pop();
      sortStack(stack);
      insertTopElement(topElement , stack);
      return stack;
    }
    public static void insertTopElement(int top ,  Deque<Integer> stack){
        if(stack.isEmpty() || stack.peek()<top) {
            stack.push(top);
            return;
        }

        int temp = stack.pop();
        insertTopElement(top,stack); // ye isiliye kiya kyuki hume top ko stack mai rakhe hue sare elements se compare karana padega
        stack.push(temp);
    }
    /*QUESTION ENDS HERE*/


    /*Question --> Reverse the Stack Recursively*/
    public static Deque<Integer> reverseStack(Deque<Integer> stack){
        if(stack.isEmpty() || stack.size()==1){
            return stack;
        }

        int top = stack.pop();
        reverseStack(stack);
        insertReverseOrder(top,stack);
        return stack;
    }
    public static void insertReverseOrder(int top , Deque<Integer> stack){
        if(stack.isEmpty()) {
          stack.push(top);
          return;
        }
        int temp = stack.pop();
        insertReverseOrder(top,stack);
        stack.push(temp);
    }
    /*QUESTION END HERE*/

    /*Question --> Generate all binary Strings*/
    public static void generate(int n, String s, List<String> res){
        if(s.length()==n){
            res.add(s);
            return;
        }

        generate(n,s+"0",res);

        if(s.isEmpty() || s.charAt(s.length() -1) != '1'){
            generate(n,s+"1",res);
        }
    }
    /*QUESTION ENDS HERE*/


    /*Leetcode Question --> 22. Generate Paranthesis */
    // Brute force approach
    public static void generateParanthesis(int n, String s, List<String> res){
        if(s.length() == 2*n) { // yha 2n isiliye kiya becoz har position ke liye 2 option hai ( and )
            res.add(s);
            return;
        }
        generateParanthesis(n,s+"(",res);
        generateParanthesis(n,s+")",res);
    }
    public static boolean isValidString(String s){
        int count = 0;
        int n = s.length();

        for(int i=0;i<n;i++){
            if(s.charAt(i) == '(') {
                count++;
            }else{
                count--;
            }
        if(count < 0){
         return false;
        }
        }
        return count==0;
    }
    /*BRUTE FORCE ENDS HERE*/

    //Optimized approach
    public static void generateParenthesiss(int n , int open, int close, String s, List<String> res){
        if(s.length()==2*n){
            res.add(s);
            return;
        }

        if(open < n){
            generateParenthesiss(n,open+1,close,s+"(",res);
        }
        if(close < open){
            generateParenthesiss(n,open, close+1,s+")",res);
        }
    }
    /*OPTIMIZED APPROACH ENDS HERE*/

    /*Question --> Print Possible subsequence of a string*/
//    BRUTE FORCE APPROACH
    public static void subsequence(String s){
        int n = s.length();

       for(int i = 0; i < n; i++){
           for(int j = i + 1; j < n; j++){
               for(int q = j + 1; q < n; q++){
                    System.out.println("" + s.charAt(i) + s.charAt(j) + s.charAt(q));
               }
           }
      }
    }
    //RECURSION APPROACH
    public static void subsequence(String s,int i , String curr, List<String> res){
       if(i == s.length()){
           res.add(curr);
           return;
       }

       subsequence(s,i+1,curr+s.charAt(i),res);
       subsequence(s,i+1,curr,res);
    }
    /*QUESTION ENDS HERE*/

    /*Question --> Count all subsequences with sum K*/
    public static int countSubSequence(int[] nums, int i, int sum, int k){
        if(i==nums.length){
            if(sum==k){
                return 1;
            }else{
                return 0;
            }
        }

        int take = countSubSequence(nums,i+1,sum+nums[i],k); // including the current element
        int notTake = countSubSequence(nums,i+1,sum,k); // exlcuding the current element
        return take+notTake;
    }
    /*QUESTION ENDS HERE*/

    /*Question --> Check if there exists a subsequence with sum K*/
    public static boolean existSubSequence(int[] arr, int i, int sum , int k){
        if(sum == k) return true;
        if(i==arr.length) return false;

        if(existSubSequence(arr,i+1,sum+arr[i],k)) return true;
        if(existSubSequence(arr,i+1,sum,k)) return true;

        return false;
    }
    /*QUESTION ENDS HERE*/

    /*Question --> LeetCode question no. --> 39 Combination Sum*/
    public static List<List<Integer>> combinationSum(int[] arr, int target){
        List<List<Integer>> res = new ArrayList<>();
        generateTarget(arr,0,0, target ,new ArrayList<>(),res);
        return  res;
    }
    public static void generateTarget(int[] arr, int i, int sum, int target, List<Integer> curr, List<List<Integer>> res){
       if(sum > target){
           return;
       }
       if(sum==target){
           res.add(new ArrayList<>(curr));
           return;
       }
       for(int j=i;j<arr.length;j++){
           curr.add(arr[j]);
           generateTarget(arr,j,sum+arr[j],target,curr,res);
           curr.remove(curr.size()-1);
       }
    }
    /*QUESTION ENDS HERE*/

    public static void main(String[] args) {

//        List<String> res = new ArrayList<>();
//        subsequence("abc",0,"",res);
//        for (String x: res){
//            System.out.print(x+" ");
//        }


        int[] nums = {1,1,1,1,1};
        int k = 10;
        System.out.println( existSubSequence(nums,0,0,k));

//        List<String> res = new ArrayList<>();
//        int n = 2;
//        generate(n,"",res);
//        generateParanthesis(n,"",res);
//        generateParenthesiss(n,0,0,"",res);
//        for(String s : res){
//          if(isValidString(s)){
//              System.out.println(s+" ");
//          }else{
//              continue;
//          }
//        }
//        for(String s:res){
//            System.out.println(s+" ");
//        }
//        Deque<Integer> stack = new ArrayDeque<>();
//
//        stack.push(2);
//        stack.push(4);
//        stack.push(1);
//        stack.push(3);
//
//        Iterator<Integer> it = stack.iterator();
//        while(it.hasNext()){
//            System.out.print(it.next()+ " ");
//        }
//
//        sortStack(stack);
//          reverseStack(stack);
//        System.out.println();
//
//        Iterator<Integer> its = stack.iterator();
//        while(its.hasNext()){
//            System.out.print(its.next()+ " ");
//        }
    }
}

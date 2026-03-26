import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

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
    
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(2);
        stack.push(4);
        stack.push(1);
        stack.push(3);

        sortStack(stack);

        Iterator<Integer> it = stack.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}

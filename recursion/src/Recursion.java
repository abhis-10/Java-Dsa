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
    public static void main(String[] args) {
        System.out.print(factorialFunc(3));
    }
}

import java.util.*;

public class PowerTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        long result = 0;

        for (int i = 1; i <= n; i++) {
            result += power(x, i);
        }
        System.out.println(result);
    }
    static int power(int x, int n){
        if(n == 1)
            return x;

        return x * power(x, n-1);
    }
}

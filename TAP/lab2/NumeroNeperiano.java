import java.util.Scanner;

public class NumeroNeperiano {

    public static double fatorial(Integer n){
        if (n == 0){
            return 1;
        }else{
            return n * fatorial(n-1);
        } 
    }

    public static void main(String[] args){
        int n;
        double soma = 0;
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();

        scan.close();

        for (int i = 0; i < n; i++) {
            soma += 1.0/fatorial(i);
        }
        System.out.printf("%.6f", soma);
    }   
}

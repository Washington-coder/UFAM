import java.util.Scanner;

public class AproximacaoSeno {

    public static double fatorial(Double n){
        if (n == 0){
            return 1;
        }else{
            return n * fatorial(n-1);
        } 
    }

    public static double getElementDivision(Double x, Double n){
        return (Math.pow(x, n)/fatorial(n));
    }
    public static void main(String[] args) {
        int n;
        double x, seno = 0;

        Scanner scan = new Scanner(System.in);

        x = scan.nextDouble();
        x = Math.toRadians(x);
        n = scan.nextInt();

        scan.close();

        for (int i = 0; i < n; i++) {
            if (i == 0){
                seno = x;
            }else{
                if (i % 2 != 0){
                    double index = i + 2;
                    seno -= getElementDivision(x,index);
                }else{
                    double index = i + 2;
                    seno += getElementDivision(x,index);
                }
            }
            System.out.printf("%.10f",seno);
            System.out.println();
        }
    }
}

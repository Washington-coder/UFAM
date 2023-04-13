import java.util.Scanner;

public class AproximacaoPi {
    public static void main(String[] args){
        int n;
        double aproximacao = 0, divisor = 2.0;
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();

        scan.close();

        for (int i = 0; i < n; i++){
            if (i == 0){
                aproximacao = 3.000000;
            }else{
                if (i % 2 != 0){
                    aproximacao += (4.0/((divisor)*(divisor+1)*(divisor+2)));
                    divisor += 2.0;
                    // System.out.println(aproximacao);
                }else{
                    aproximacao -= (4.0/((divisor)*(divisor+1)*(divisor+2)));
                    divisor += 2.0;
                    // System.out.println(aproximacao);
                }
            }
            System.out.printf("%.6f", aproximacao);
            System.out.println();
        }
    }
}

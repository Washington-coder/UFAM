
import java.util.Scanner;

public class RaizQuadrada {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double numero = scan.nextDouble();
        scan.close();

        numero = Math.sqrt(numero);

        System.out.printf("%.3f", numero);
    }
}

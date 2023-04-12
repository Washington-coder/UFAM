import java.util.Scanner;

public class PontoReta {
    public static void main(String[] args) {
        double x, y, result;
        Scanner scan = new Scanner(System.in);

        x = scan.nextDouble();
        y = scan.nextDouble();

        scan.close();

        result = 2*x + y;

        if (result == 3){
            System.out.printf("Ponto (%.1f, %.1f) pertence a reta 2x + y = 3.", x, y);
        }else{
            System.out.printf("Ponto (%.1f, %.1f) nao pertence a reta 2x + y = 3.", x, y);
        }
    }  
}

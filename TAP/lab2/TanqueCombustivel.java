import java.util.Scanner;

public class TanqueCombustivel {
    public static void main(String[] args){
        double r, x, option, volumeEsfera, volumeCalotaEsferica;
        Scanner scan = new Scanner(System.in);

        r = scan.nextDouble();
        x = scan.nextDouble();
        option = scan.nextDouble();

        scan.close();
        
        volumeEsfera = (4.0/3.0) * Math.PI * Math.pow(r, 3); 
        volumeCalotaEsferica = (Math.PI/3.0) * Math.pow(x, 2) * (3*r - x);
        // Air volume
        if (option == 1){
            System.out.printf("%.4f", volumeCalotaEsferica);
        }
        if (option == 2){
            System.out.printf("%.4f", (volumeEsfera - volumeCalotaEsferica));
        }
    }
}

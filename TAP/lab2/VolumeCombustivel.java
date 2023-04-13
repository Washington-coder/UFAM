import java.util.Scanner;

public class VolumeCombustivel {
    public static void main(String[] args){
        double H, h, r, calotaEsferica;

        Scanner scan = new Scanner(System.in);

        H = scan.nextDouble();
        h = scan.nextDouble();
        r = scan.nextDouble();

        scan.close();

        calotaEsferica = (Math.PI/3.0)*Math.pow(r,2)*(3*r - r);


    }   
}

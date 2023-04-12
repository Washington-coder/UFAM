import java.util.Scanner;

public class AreaVolume {
    public static void main(String[] args) {
        double areaCirculo, volumeEsfera, r;
        Scanner scan = new Scanner(System.in);
        r = scan.nextDouble();
        scan.close();

        areaCirculo = Math.PI * Math.pow(r,2);
        volumeEsfera = (4.0/3.0) * (Math.PI * Math.pow(r,3));

        System.out.printf("Um circulo com raio de %.2f centimetros tem uma area de %.2f centimetros quadrados.", r, areaCirculo);
        System.out.println();
        System.out.printf("Uma esfera com raio de %.2f centimetros tem um volume de %.2f centimetros cubicos.", r, volumeEsfera);
    }
}

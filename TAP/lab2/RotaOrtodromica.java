import java.util.Scanner;

public class RotaOrtodromica {
    public static void main(String[] args) {
        double t1, g1, t2, g2, d;

        Scanner scan = new Scanner(System.in);

        t1 = scan.nextDouble();
        g1 = scan.nextDouble();
        t2 = scan.nextDouble();
        g2 = scan.nextDouble();

        scan.close();

        d = 6371 * Math.acos((Math.sin(Math.toRadians(t1)) * Math.sin(Math.toRadians(t2)) + Math.cos(Math.toRadians(t1)) * Math.cos(Math.toRadians(t2)) * Math.cos(Math.toRadians(g1) - Math.toRadians(g2))));

        System.out.printf("A distancia entre os pontos (%f, %f) e (%f, %f) e de %.2f km", t1, g1, t2, g2, d);
    }
}

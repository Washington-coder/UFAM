import java.util.ArrayList;
import java.util.Scanner;

public class AreaPoligono {
    public static void main(String[] args){
        ArrayList<Double> abscissas = new ArrayList<Double>();
        ArrayList<Double> ordenadas = new ArrayList<Double>();
        Scanner scan = new Scanner(System.in);

        double valor;
        double area = 0;

        valor = scan.nextDouble();
        while(valor != -1){
            abscissas.add(valor);
            valor = scan.nextDouble();
        }
        valor = scan.nextDouble();
        while(valor != -1){
            ordenadas.add(valor);
            valor = scan.nextDouble();
        }
        scan.close();

        for (int i = 0; i <= (abscissas.size() - 2); i++) {
            area += (abscissas.get(i+1) + abscissas.get(i)) * (ordenadas.get(i+1) - ordenadas.get(i));
        }
        area = area * 0.5;
        area = Math.abs(area);

        System.out.printf("%,4f", area);
    }   
}

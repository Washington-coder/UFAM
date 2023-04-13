import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class AnimaisCedulas {
    public static void main(String[] args){
        double value;
        Scanner scan = new Scanner(System.in);

        value = scan.nextDouble();
        scan.close();

        Map<Double, String> cedulas = new HashMap<>();

        cedulas.put(2.0, "Tartaruga");
        cedulas.put(5.0, "Garça");
        cedulas.put(10.0, "Arara");
        cedulas.put(20.0, "Mico-leão-dourado");
        cedulas.put(50.0, "Onça-pintada");
        cedulas.put(100.0, "Garoupa");

        if (cedulas.containsKey(value)){
            System.out.println(cedulas.get(value));
        }else{
            System.out.println("erro");
        }

    }
}

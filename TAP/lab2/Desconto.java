import java.util.Scanner;

public class Desconto {
    public static void main(String[] args) {
        double value;
        Scanner scan = new Scanner(System.in);

        value = scan.nextDouble();
        scan.close();

        if (value >= 200){
            value = value - (value * 0.05);
        }
        System.out.printf("%.2f", value);
    }    
}

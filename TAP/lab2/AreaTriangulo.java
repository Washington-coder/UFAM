import java.util.Scanner;

public class AreaTriangulo {
    public static void main(String[] args) {
        int a,b,c;
        double A, s;
        Scanner scan = new Scanner(System.in);

        a = scan.nextInt();
        b = scan.nextInt();
        c = scan.nextInt();

        scan.close();

        if ((a+b > c) && (a+c > b) && (b+c > a)) {
            s = (a+b+c)/2;
            
            A = Math.sqrt(s*(s-a)*(s-b)*(s-c));
    
            System.out.printf("%.2f", A);
        }else{
            System.out.println("Triangulo invalido");
        }
    }
}

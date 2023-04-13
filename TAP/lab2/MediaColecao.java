import java.util.Scanner;

public class MediaColecao {
    public static void main(String[] args) {
        double value = 0, soma = 0;
        int qtdElementos = 0;
        Scanner scan = new Scanner(System.in);

        while (value != -1) {
            value = scan.nextInt();
            if (value != -1){
                soma += value;
                qtdElementos++;
            }
        }
        scan.close();

        System.out.printf("%.2f", (soma/qtdElementos));
    }
}

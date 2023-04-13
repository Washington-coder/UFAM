import java.util.Scanner;

public class SomaColecao {
    public static void main(String[] args) {
        int value = 0, soma = 0;
        Scanner scan = new Scanner(System.in);

        while (value != -1) {
            value = scan.nextInt();
            if (value != -1){
                soma += value;
            }
        }
        scan.close();

        System.out.println(soma);
    }
}

import java.util.Scanner;

public class SomaDigitos {
    public static void main(String[] args) {
        int n, baseDez = 10, divisorAux = 1, resto, digito, soma = 0;
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();

        scan.close();

        while(n > baseDez) {
            resto = n % baseDez;
            digito = resto/divisorAux;
            soma += digito;
            divisorAux *= 10;
            baseDez *= 10;
            n -= resto;
        }
        digito = n/divisorAux;
        soma += digito;
        System.out.println(soma);
    }
}

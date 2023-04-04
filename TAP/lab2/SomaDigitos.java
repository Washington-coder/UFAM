import java.util.Scanner;

public class SomaDigitos {
    public static void main(String[] args) {
        int n, baseDez = 1, subRestoAnt, resto = 0, digito = 0, soma = 0;
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();

        scan.close();

        while(n >= baseDez) {
            // System.out.println(n % baseDez);
            if (baseDez == 1){
                digito = n % baseDez;
                // System.out.println(digito);
            }else{
                subRestoAnt = (n % baseDez) - resto;
                System.out.println("subRestoAnt " + subRestoAnt);
                System.out.println("baseDez " + baseDez);
                digito = subRestoAnt/baseDez;
                // System.out.println("digito " + digito);
                // System.out.println(digito);
                // subRestoAnt = n - (n % baseDez);
                // digito = baseDezSub/baseDez;
            }
            soma += digito;
            resto = n % baseDez;
            baseDez = baseDez * 10;
        }
        // System.out.println(soma);
    }
}

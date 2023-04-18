import java.util.ArrayList;
import java.util.Scanner;

class OperacoesInteiros {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double media;
        int maior = Integer.MIN_VALUE, menor = Integer.MAX_VALUE, valor = 0, somaColecoes = 0, qtdElementos = 0, qtdPares = 0, qtdImpares = 0, aux = 0;
        while (aux != 2) {
            valor = sc.nextInt();

            if (valor != -1) {
                if (valor > maior) {
                    maior = valor;
                }
                if (valor < menor) {
                    menor = valor;
                }
                if (valor % 2 == 0) {
                    qtdPares++;
                } else {
                    qtdImpares++;
                }
                somaColecoes += valor;
                qtdElementos++;
                aux = 0;
            }
            if (valor == -1) {
                aux++;
                media = somaColecoes / (double) qtdElementos;

                if (aux == 1){
                    System.out.println(qtdElementos);
                    System.out.println(qtdPares);
                    System.out.println(qtdImpares);
                    System.out.println(somaColecoes);
                    System.out.printf("%.2f\n", media);
                    System.out.println(maior);
                    System.out.println(menor);
                }

                maior = Integer.MIN_VALUE;
                menor = Integer.MAX_VALUE;
                valor = 0;
                somaColecoes = 0;
                qtdElementos = 0;
                qtdPares = 0;
                qtdImpares = 0;
            }
        }

    }
}

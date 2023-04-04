import java.util.ArrayList;
import java.util.Scanner;

class SomaColecoes {

    public static void main(String[] args) {

        // Cria um ArrayList para armazenar os valores digitados
        ArrayList<Integer> valores = new ArrayList<Integer>();

        // Lê os valores digitados pelo usuário
        Scanner sc = new Scanner(System.in);
        int valor = 0, somaColecoes = 0, aux = 0;
        while (aux != 2) {
            valor = sc.nextInt();

            if (valor != -1) {
                somaColecoes += valor;
                aux = 0;
            }
            if (valor == -1){
                aux++;
                if (aux != 2){
                    valores.add(somaColecoes);
                }
                somaColecoes = 0;
            }
        }

        // Converte o ArrayList em um array de inteiros
        int[] array = new int[valores.size()];
        for (int i = 0; i < valores.size(); i++) {
            array[i] = valores.get(i);
            System.out.println(array[i]);
        }
    }
}

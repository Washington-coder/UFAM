
import java.util.Scanner;

public class CaixaEletronico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int valor = scanner.nextInt();
        scanner.close();

        int qtdNotasCinquenta = 0, qtdNotasDez = 0, qtdNotasDois = 0;

        if (valor % 2 == 0 && valor > 0){
            if (valor > 50) {
                while (valor > 50) {
                    valor -= 50;
                    qtdNotasCinquenta++;
                }
            }
            if (valor > 10 && valor < 50) {
                while (valor > 10) {
                    valor -= 10;
                    qtdNotasDez++;
                }
            }
            if (valor > 2 && valor < 10) {
                while (valor != 0) {
                    valor -= 2;
                    qtdNotasDois++;
                }
            }
            System.out.printf("%d notas de R$50, %d notas de R$10 e %d notas de R$2", qtdNotasCinquenta, qtdNotasDez, qtdNotasDois);
        }else{
            System.out.println("Valor Invalido");
        }
    }
}

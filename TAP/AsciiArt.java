import java.util.Scanner;

class AsciiArt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int alturaArvore = scanner.nextInt();

        scanner.close();
        int alturaArvoreAux = alturaArvore;
        int qtdEspacosBranco = 0;

        for (int i = 0; i < alturaArvore; i++){
            for (int j = 0; j < alturaArvoreAux; j++){
                System.out.print("*");
            }
            for (int j = 0; j < qtdEspacosBranco; j++){
                System.out.print(" ");
            }
            for (int j = 0; j < qtdEspacosBranco; j++){
                System.out.print(" ");
            }
            for (int j = 0; j < alturaArvoreAux; j++){
                System.out.print("*");
            }
            qtdEspacosBranco = qtdEspacosBranco + 1;
            alturaArvoreAux = alturaArvoreAux - 1;
            System.out.println();
        }
    }
}
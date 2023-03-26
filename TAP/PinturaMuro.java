import java.util.Scanner;

class PinturaMuro {
    public static void main(String[] args) {
        Float comprimento = 12f;
        Float altura = 3f;

        Float areaMuro = comprimento * altura;

        Scanner scan = new Scanner(System.in);

        Float preco = scan.nextFloat();

        scan.close();

        Float precoTotal = preco * areaMuro;

        precoTotal = precoTotal + 100f;

        System.out.printf("%.1f", precoTotal);
    }
}
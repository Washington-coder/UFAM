import java.util.Scanner;

class FolhaPagamento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Float valorPorHora = scanner.nextFloat();

        int horasTrabalhadas = scanner.nextInt();

        scanner.close();

        Float salario = valorPorHora * horasTrabalhadas;
        Float ir = salario * 0.11f;
        Float inss = salario * 0.08f;
        Float totalDescontos = ir + inss;
        Float salarioLiquido = salario - totalDescontos;


        System.out.printf("Salario bruto: R$%.2f\n", salario);
        System.out.printf("IR: R$%.2f\n", ir);
        System.out.printf("INSS: R$%.2f\n", inss);
        System.out.printf("Total de descontos: R$%.2f\n", totalDescontos);
        System.out.printf("Salario liquido: R$%.2f\n", salarioLiquido);
    }
}
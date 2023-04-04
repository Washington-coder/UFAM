import java.util.Scanner;

public class IdadeUfam {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int anoAtual = scanner.nextInt(), idadeUfam = 1909, diferenca;
        diferenca = anoAtual - idadeUfam;

        System.out.println("A UFAM tem " + diferenca + " anos de fundacao");
    }  
}

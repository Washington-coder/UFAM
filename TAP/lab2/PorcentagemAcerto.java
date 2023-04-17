import java.util.ArrayList;
import java.util.Scanner;

public class PorcentagemAcerto {
    public static void main(String[] args){
        int valor, acertos = 0;
        ArrayList<Integer> questoesProva = new ArrayList<Integer>();
        ArrayList<Integer> gabarito = new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);
        valor = scan.nextInt();
        while(valor != -1){
            questoesProva.add(valor);
            valor = scan.nextInt();
        }
        valor = scan.nextInt();
        while(valor != -1){
            gabarito.add(valor);
            valor = scan.nextInt();
        }
        scan.close();

        for (int i = 0; i < questoesProva.size(); i++) {
            if (questoesProva.get(i) == gabarito.get(i)){
                acertos++;
            }
        }

        System.out.printf("%.2f", ((double)acertos/(double)questoesProva.size())*100);
    }
}

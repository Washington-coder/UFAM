import java.util.ArrayList;
import java.util.Scanner;

class TimeFutebol {
    public static void main(String[] args) {
        int valor, empate = 0, vitorias = 0, derrotas = 0;
        ArrayList<Integer> gols = new ArrayList<Integer>();
        ArrayList<Integer> golsAdversario = new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);
        valor = scan.nextInt();
        while (valor != -1) {
            gols.add(valor);
            valor = scan.nextInt();
        }
        valor = scan.nextInt();
        while (valor != -1) {
            golsAdversario.add(valor);
            valor = scan.nextInt();
        }
        
        scan.close();

        for (int i = 0; i < gols.size(); i++) {
            if (gols.get(i) == golsAdversario.get(i)){
                empate++;
            }
            if (gols.get(i) > golsAdversario.get(i)){
                vitorias++;
            }
            if (gols.get(i) < golsAdversario.get(i)){
                derrotas++;
            }
        }

        System.out.printf("%d %d %d", vitorias, empate, derrotas);
        // System.out.println(vitorias);
        // System.out.println(empate);
        // System.out.println(derrotas);
    }
}

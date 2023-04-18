import java.util.ArrayList;
import java.util.Scanner;

public class DistanciaAviao {
    public static Integer getIndices(Integer num) {
        if (num == 111) {
            return 0;
        } else if (num == 222) {
            return 1;
        } else if (num == 333) {
            return 2;
        } else if (num == 444) {
            return 3;
        } else if (num == 555) {
            return 4;
        } else if (num == 666) {
            return 5;
        } else if (num == 777) {
            return 6;
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> cidades = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        int cidade, soma = 0;
        int tabela[][] = {
                { 0, 2, 11, 6, 15, 11, 1 },
                { 2, 0, 7, 12, 4, 2, 15 },
                { 11, 7, 0, 11, 8, 3, 13 },
                { 6, 12, 11, 0, 10, 2, 1 },
                { 15, 4, 8, 10, 0, 5, 13 },
                { 11, 2, 3, 2, 5, 0, 14 },
                { 1, 15, 13, 1, 13, 14, 0 }
        };

        cidade = scanner.nextInt();

        while (cidade != -1) {
            cidades.add(cidade);
            cidade = scanner.nextInt();
        }

        int x, y;

        for (int i = 0; i < (cidades.size()-1); i++) {

            x = getIndices(cidades.get(i));
            y = getIndices(cidades.get(i + 1));
            soma += tabela[x][y];
            // System.out.println(x);
            // System.out.println(y);
        }
        System.out.println(soma);
    }
}

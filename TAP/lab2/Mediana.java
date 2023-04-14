import java.util.ArrayList;
import java.util.Scanner;

class Mediana {

    public static void main(String[] args) {

        ArrayList<Integer> valores = new ArrayList<Integer>();

        Scanner sc = new Scanner(System.in);
        int valor = 0;
        while (valor != -1) {
            valor = sc.nextInt();
            if (valor != -1){
                valores.add(valor);
            }
        }

        if (valores.size() % 2 == 0) {
            int lenth = valores.size();
            double medianaIndex1, medianaIndex2, mediana, soma;
            medianaIndex1 = ((lenth/2.0)-1);
            medianaIndex2 = medianaIndex1 + 1;

            soma = (double)valores.get((int)medianaIndex1) + (double)valores.get((int)medianaIndex2);

            System.out.printf("%.1f", (soma/2.0));

        }else{
            int lenth = valores.size();
            double medianaIndex;
            medianaIndex = (((lenth+1)/2.0)-1);
            System.out.printf("%.1f", (double)valores.get((int)(medianaIndex)));
        }
    }
}

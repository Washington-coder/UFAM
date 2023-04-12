
import java.util.Scanner;

public class Xadrez {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int numLinhas = scan.nextInt();
        scan.close();

        for(int i=0; i<numLinhas; i++) {
            for(int j=0; j<numLinhas; j++) {
                if (i % 2 == 0) {
                    System.out.print('*');
                    System.out.print(' ');
                }else{
                    System.out.print(' ');
                    System.out.print('*');
                }
            }
            System.out.println();
        }
    }
}

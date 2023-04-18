import java.util.Scanner;

public class Palindromos {
    public static boolean ehPalindromo(String palavra, int ultimoIndicePalvra){
        for (int i = 0; i < palavra.length(); i++) {
            if (palavra.charAt(i) != palavra.charAt(ultimoIndicePalvra)){
                return false;
            }
            ultimoIndicePalvra--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String palavra;
        int ultimoIndicePalvra;

        palavra = scan.nextLine();
        scan.close();
        palavra = palavra.toUpperCase();
        palavra = palavra.replace(" ", "");
        ultimoIndicePalvra = (palavra.length() - 1);

        if (ehPalindromo(palavra, ultimoIndicePalvra)){
            System.out.printf("%s 1", palavra);
        }else{
            System.out.printf("%s 0", palavra);
        }
    }
}

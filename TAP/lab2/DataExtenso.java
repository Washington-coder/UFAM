import java.util.Scanner;

public class DataExtenso {
    public static void main(String[] args) {
        String data;

        Scanner scan = new Scanner(System.in);

        data = scan.next();
        scan.close();

        String dia = data.substring(0, 2);
        String mes = data.substring(2, 4);
        String ano = data.substring(4, 8);

        if (mes.equals("01")) {
            mes = "janeiro";
        }
        if (mes.equals("02")) {
            mes = "fevereiro";
        }
        if (mes.equals("03")) {
            mes = "março";
        }
        if (mes.equals("04")) {
            mes = "abril";
        }
        if (mes.equals("05")) {
            mes = "maio";
        }
        if (mes.equals("06")) {
            mes = "junho";
        }
        if (mes.equals( "07")) {
            mes = "julho";
        }
        if (mes.equals( "08")) {
            mes = "agosto";
        }
        if (mes.equals( "09")) {
            mes = "setembro";
        }
        if (mes.equals( "10")) {
            mes = "outubro";
        }
        if (mes.equals( "11")) {
            mes = "novembro";
        }
        if (mes.equals( "12")) {
            mes = "dezembro";
        }
        System.out.println(dia + " de " + mes + " de " + ano);
    }
}

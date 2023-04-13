import java.util.Scanner;

public class ContaEnergia {
    public static void main(String[] args) {
        double valor, conta = -1;
        char tipo;

        Scanner scan = new Scanner(System.in);

        valor = scan.nextDouble();
        tipo = scan.next().charAt(0);
        scan.close();

        if (tipo == 'R'){
            if (valor > 0){
                if (valor <= 500){
                    conta = valor * 0.40;
                    System.out.println(conta);
                }
                else if (valor > 500){
                    conta = valor * 0.65;
                    System.out.println(conta);
                }
            }else{
                System.out.println(conta);
            }
        }
        else if (tipo == 'C'){
            if (valor > 0){
                if (valor <= 1000){
                    conta = valor * 0.55;
                    System.out.println(conta);
                }
                else if (valor > 1000){
                    conta = valor * 0.60;
                    System.out.println(conta);
                }
            }else{
                System.out.println(conta);
            }
        }
        else if (tipo == 'I'){
            if (conta > 0){
                if (valor <= 5000){
                    conta = valor * 0.55;
                    System.out.println(conta);
                }
                else if (valor > 5000){
                    conta = valor * 0.60;
                    System.out.println(conta);
                }
            }else{
                System.out.println(conta);
            }
        }else{
            System.out.println(conta);
        }
        
    }
}

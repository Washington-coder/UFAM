import java.util.Scanner;

class TipoTriangulo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int ladoA = scan.nextInt();
        int ladoB = scan.nextInt();
        int ladoC = scan.nextInt();

        scan.close();

        if ((((ladoA + ladoB) > ladoC) && ((ladoB + ladoC) > ladoA) && ((ladoA + ladoC) > ladoB)) && (ladoA > 0) && (ladoB > 0) && (ladoC > 0)) {
            if ((ladoA != ladoB) && (ladoA != ladoC) && (ladoB != ladoC)) {
                System.out.print("escaleno");
            }

            if ((ladoA == ladoB) && (ladoB == ladoC)){
                System.out.print("equilatero");
            }

            if (((ladoA == ladoB) && (ladoB != ladoC)) || ((ladoC == ladoB) && (ladoB != ladoA))){
                System.out.print("isosceles");
            }
        }else{
            System.out.print("invalido");
        }
    }
}
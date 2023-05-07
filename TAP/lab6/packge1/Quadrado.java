
public class Quadrado extends Retangulo{

    public Quadrado(int posX, int posY, double lado){
        super(posX, posY, lado, lado);
    }

    public String toString() {
        String resultado = String.format("Quadrado na posição (%d, %d) com lado de %.1fcm (área=%.1fcm2, perímetro=%.1fcm)", posX, posY, altura, getArea(), getPerimetro());
        return resultado;
    } 
}

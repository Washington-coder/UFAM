
public class Retangulo extends FormaGeometrica {
    public double largura;
    public double altura;

    public Retangulo(int posX, int posY, double largura, double altura){
        super(posX, posY);
        this.largura = largura;
        this.altura = altura;
    }

    public double getArea(){
        return this.largura*this.altura;
    }

    public double getPerimetro(){
        return 2*(this.largura + this.altura);
    }

    public String toString(){
        String resultado = String.format("Retângulo na posição (%d, %d) com largura de %.1fcm e altura de %.1fcm (área=%.1fcm2, perímetro=%.1fcm)", posX, posY, this.largura, this.altura, getArea(), getPerimetro());
        return resultado;
    }
}

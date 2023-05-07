
public class Circulo extends FormaGeometrica {
    public double raio;

    public double getArea() {
        double area = Math.PI * Math.pow(this.raio, 2);
        return area;
    }

    public double getPerimetro() {
        double perimetro = 2 * Math.PI * this.raio;
        return perimetro;
    }

    public String toString() {
        return "Círculo na posição (" + posX + ", " + posY + ") com raio de " + this.raio + "cm (área=" + getArea()
                + "cm2, perímetro=" + getPerimetro() + "cm)";
    }

    public Circulo(int posX, int posY, double raio) {
        super(posX, posY);
        this.raio = raio;
    }
}

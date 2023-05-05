
import java.util.ArrayList;

public class FormasMain {
    public static void main(String[] args) {
        ArrayList<FormaGeometrica> formas = new ArrayList<FormaGeometrica>();
        Circulo circulo = new Circulo(1,1,2.0);
        Quadrado quadrado = new Quadrado(1,1,2.0);
        Retangulo retangulo = new Retangulo(1,1,2.0,2.0);

        formas.add(circulo);
        formas.add(quadrado);
        formas.add(retangulo);

        for (FormaGeometrica forma : formas) {
            System.out.println(forma);
        }
    }
}

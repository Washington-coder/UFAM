
public class CoordenadaNegativaException extends RoverCoordenadaException {
    public CoordenadaNegativaException(String msg){
        System.out.println(msg);
    }

    public CoordenadaNegativaException(){
        System.out.println("Coordenada com valor negativo");
    }

    public String getMessage() {
        return "Coordenada com valor negativo";
    }
}


public class RoverCoordenadaException extends RoverException {
    public RoverCoordenadaException(String msg){
        System.out.println(msg);
    }

    public RoverCoordenadaException(){
        System.out.println("Exceção geral de coordenada do rover");
    }

    public String getMessage() {
        return "Exceção geral de coordenada do rover";
    }
}

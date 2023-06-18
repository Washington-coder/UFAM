
public class CoordenadaForaDosLimitesException extends RoverCoordenadaException {
    public CoordenadaForaDosLimitesException(String msg){
        System.out.println(msg);
    }

    public CoordenadaForaDosLimitesException(){
        System.out.println("Coordenada com valores fora dos limites");
    }

    public String getMessage() {
        return "Coordenada com valores fora dos limites";
    }
}

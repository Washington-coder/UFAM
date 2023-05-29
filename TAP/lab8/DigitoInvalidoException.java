
public class DigitoInvalidoException extends RoverCoordenadaException {
    public DigitoInvalidoException(String msg){
        System.out.println(msg);
    }

    public DigitoInvalidoException(){
        System.out.println("Digito da coordenada inválido");
    }

    public String getMessage() {
        return "Digito da coordenada inválido";
    }
}

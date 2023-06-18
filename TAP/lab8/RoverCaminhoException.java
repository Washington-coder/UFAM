
public class RoverCaminhoException extends RoverException {
    public RoverCaminhoException(String msg){
        System.out.println(msg);
    }

    public RoverCaminhoException(){
        System.out.println("Exceção geral de caminho do rover");
    }

    public String getMessage() {
        return "Exceção geral de caminho do rover";
    }
}


public class RoverException extends Exception{

    public RoverException(String msg){
        System.out.println(msg);
    }

    public RoverException(){
        System.out.println("Exceção geral do rover");
    }

    public String getMessage() {
        return "Exceção geral do rover";
    }
}
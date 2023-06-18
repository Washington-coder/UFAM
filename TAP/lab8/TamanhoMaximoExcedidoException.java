
public class TamanhoMaximoExcedidoException extends RoverCaminhoException {
    public TamanhoMaximoExcedidoException(String msg){
        System.out.println(msg);
    }

    public TamanhoMaximoExcedidoException(){
        System.out.println("Quantidade máxima de coordenadas excedida");
    }

    public String getMessage() {
        return "Quantidade máxima de coordenadas excedida";
    }
}

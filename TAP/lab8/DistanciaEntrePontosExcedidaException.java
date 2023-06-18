
public class DistanciaEntrePontosExcedidaException extends RoverCaminhoException {
    public DistanciaEntrePontosExcedidaException(String msg){
        System.out.println(msg);
    }

    public DistanciaEntrePontosExcedidaException(){
        System.out.println("Distância máxima entre duas coordenadas vizinhas excedida");
    }

    public String getMessage() {
        return "Distância máxima entre duas coordenadas vizinhas excedida";
    }
}

public class Processador {
    String marca;
    String modelo;
    double velocidade;
    int numNucleos;

    Processador(){
        this.marca = "";
        this.modelo = "";
        this.velocidade = 0;
        this.numNucleos = 0;
    }

    Processador(String marca, String modelo, double velocidade, int numNucleos) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidade = velocidade;
        this.numNucleos = numNucleos;
    }

    double getVelocidadeParalela() {
        return velocidade * numNucleos;
    }

    String getDescricao(){
        return "Processador: marca="+ marca + ", modelo="+modelo+", velocidade="+velocidade+"GHz, numNucleos="+numNucleos+", "+"velocidadeParalela=" + getVelocidadeParalela()+"GHz.";
    }
}
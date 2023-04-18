
public class Computador {

    Processador processador = new Processador();
    Memoria memoria = new Memoria();
    Disco disco = new Disco();
    String fabricante;

    
    Computador(String fabricante, Processador processador, Memoria memoria, Disco disco){
        this.fabricante = fabricante;
        this.processador = processador;
        this.memoria = memoria;
        this.disco = disco;
    }

    String getDescricao(){
        return "Computador da fabricante " + fabricante + ". " + processador.getDescricao() + " " + memoria.getDescricao() + " " + disco.getDescricao();
    }
}

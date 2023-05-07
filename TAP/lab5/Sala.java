

public class Sala {
    int bloco;
    int sala;
    int capacidade;
    boolean acessivel;

    Sala(){
        this.bloco = 0;
        this.sala = 0;
        this.capacidade = 0;
        this.acessivel = false;
    }
    
    Sala(int bloco, int sala, int capacidade, boolean acessivel){
        this.bloco = bloco;
        this.sala = sala;
        this.capacidade = capacidade;
        this.acessivel = acessivel;
    }

    String getDescricao(){
        String acessivelString = this.acessivel ? "acessível": "não acessível";
        return "Bloco " + this.bloco + ", Sala " + this.sala + " (" + this.capacidade + " lugares, " + acessivelString + ")"; 
    }
}

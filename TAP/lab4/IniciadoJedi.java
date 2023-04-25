
public class IniciadoJedi {
    String nome;
    String especie;
    int anoNascimento;

    String getDescricao() {
        return this.nome + " (especie="+ this.especie + ", nascimento=" + getAnoNascimento() + ")"; 
    }

    String getAnoNascimento() {
        if (this.anoNascimento > 0) {
            return  this.anoNascimento + " DBY";
        }else{
            
            return (this.anoNascimento * -1) + " ABY";
        }
    }

    IniciadoJedi(){
        this.nome = "";
        this.especie = "";
        this.anoNascimento = 0;
    }

    IniciadoJedi(String nome, String especie, int anoNascimento){
        this.nome = nome;
        this.especie = especie;
        this.anoNascimento = anoNascimento;
    }
}

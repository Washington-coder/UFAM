class TreinadorJedi {
    String titulacao;
    String nome;

    String getDescricao() {
        return this.titulacao + " " + this.nome;
    }

    TreinadorJedi(){
        this.titulacao = "";
        this.nome = "";
    }

    TreinadorJedi(String titulacao, String nome){
        this.titulacao = titulacao;
        this.nome = nome;
    }
}
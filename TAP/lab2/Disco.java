class Disco {
    String marca;
    String tipo;
    double capacidade;
    int rpm;

    Disco(){
        this.marca = "";
        this.tipo = "";
        this.capacidade = 0;
        this.rpm = 0;        
    }

    Disco(String marca, String tipo, double capacidade, int rpm){
        this.marca = marca;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.rpm = rpm;        
    }

    String getDescricao(){
        return "Disco: marca="+marca+", tipo="+tipo+", capacidade="+capacidade+"GB, rpm="+rpm+"rpm.";
    }
}

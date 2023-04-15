
public class ComputadorMain {
    public static void main(String[] args){
        Processador processador = new Processador("Intel", "i7", 3.2, 8);
        Memoria memoria = new Memoria("Kingston", "DDR4", 8.0, 3.2, 4);
        Disco disco = new Disco("Western Digital", "HDD", 4000.0, 9600);

        Computador computador = new Computador("Dell", processador, memoria, disco);
        computador.getDescricao();
    }
}

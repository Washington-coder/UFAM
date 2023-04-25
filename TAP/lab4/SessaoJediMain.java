
public class SessaoJediMain {
    public static void main(String[] args){
        TreinadorJedi treinador = new TreinadorJedi("Grão-Mestre", "Fae Coven");
        SessaoJedi sessao = new SessaoJedi("Instruções de Uso da Força", treinador);
        IniciadoJedi iniciado1 = new IniciadoJedi("Katooni", "Tholothian", 23);
        IniciadoJedi iniciado2 = new IniciadoJedi("Byph", "Ithorian", 21);
        IniciadoJedi iniciado3 = new IniciadoJedi("Gungi", "Wookiee", 23);
        IniciadoJedi iniciado4 = new IniciadoJedi("Petro", "Human", 22);

        sessao.addIniciado(iniciado1);
        sessao.addIniciado(iniciado2);
        sessao.addIniciado(iniciado3);
        sessao.addIniciado(iniciado4);

        String descricao = sessao.getDescricao();
        System.out.println(descricao);
    }
}

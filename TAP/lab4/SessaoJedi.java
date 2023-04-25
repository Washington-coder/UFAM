import java.util.ArrayList;

public class SessaoJedi {
    String nome;
    TreinadorJedi treinador;
    ArrayList<IniciadoJedi> iniciados;

    void addIniciado(IniciadoJedi iniciado){
        boolean ehRepetido = false;
        if (iniciados != null){
            for (IniciadoJedi iniciadoJedi : iniciados) {
                if (iniciadoJedi.nome.equals(iniciado.nome)){
                    ehRepetido = true;
                }
            }
        }
        if (!ehRepetido){
            iniciados.add(iniciado);
        }
    }

    IniciadoJedi getIniciado(String nome){
        for (IniciadoJedi iniciadoJedi : iniciados){
            if (iniciadoJedi.nome.equals(nome)){
                return iniciadoJedi;
            }
        }
        return null;
    }

    double getMediaAnoNascimento(){
        double soma = 0, media;
        for (IniciadoJedi iniciadoJedi : iniciados){
            soma += iniciadoJedi.anoNascimento;
        }

        media = soma/iniciados.size();

        return media;
    }

    String getDescricao(){
        int index = 1;
        String descricao = "";
        descricao += ("--> SESSÃO " + this.nome + " (Treinador: " + this.treinador.titulacao + " " + this.treinador.nome + ")\n");
        for (IniciadoJedi iniciadoJedi : iniciados){
            descricao += ("  - Iniciado " + index + ": " + iniciadoJedi.getDescricao() + "\n");
            index++;
        }

        return descricao;
    }

    SessaoJedi(String nome, TreinadorJedi treinador){
        this.nome = nome;
        this.treinador = treinador;
        this.iniciados = new ArrayList<IniciadoJedi>();
    }
}

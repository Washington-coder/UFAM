import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Turma {
    String nome;
    String professor;
    int numAlunos;
    boolean acessivel;
    ArrayList<Integer> horarios;

    Map<Integer, String> colunas = new HashMap<>();
    Map<Integer, Integer> linhas = new HashMap<>();

    Turma() {
        this.nome = "";
        this.professor = "";
        this.numAlunos = 0;
        this.acessivel = false;
        this.horarios = new ArrayList<Integer>();
    }

    Turma(String nome, String professor, int numAlunos, boolean acessivel) {
        this.nome = nome;
        this.professor = professor;
        this.numAlunos = numAlunos;
        this.acessivel = acessivel;
        this.horarios = new ArrayList<Integer>();
    }

    void addHorario(int horario) {
        this.horarios.add(horario);
    }

    String getHorariosString() {
        String result = "";

        int[][] matriz = {
                { 1, 8, 15, 22, 29 },
                { 2, 9, 16, 23, 30 },
                { 3, 10, 17, 24, 31 },
                { 4, 11, 18, 25, 32 },
                { 5, 12, 19, 26, 33 },
                { 6, 13, 20, 27, 34 },
                { 7, 14, 21, 28, 35 }
        };

        colunas.put(0, "segunda");
        colunas.put(1, "terça");
        colunas.put(2, "quarta");
        colunas.put(3, "quinta");
        colunas.put(4, "sexta");

        linhas.put(0, 8);
        linhas.put(1, 10);
        linhas.put(2, 12);
        linhas.put(3, 14);
        linhas.put(4, 16);
        linhas.put(5, 18);
        linhas.put(6, 20);

        for (int i = 0; i < horarios.size(); i++) {
            int horarioProcurado = horarios.get(i);
            for (int j = 0; j < matriz.length; j++) {
                for (int k = 0; k < matriz[0].length; k++) {
                    if (horarioProcurado == matriz[j][k]){
                        String diaDaSemana = colunas.get(k);
                        int hora = linhas.get(j);
                        if (i != horarios.size() - 1){
                            result += diaDaSemana + " " + hora + "hs, ";
                        }else{
                            result += diaDaSemana + " " + hora + "hs";
                        }
                    }
                }
            }            
        }
        return result;
    }

    String getDescricao(){
        String acessivelString = this.acessivel == true ? "sim" : "não";
        return "Turma: " + this.nome + "\n" + "Professor: " + this.professor + "\n" + "Número de Alunos: " + this.numAlunos + "\n" + "Horário: " + this.getHorariosString() + "\n" + "Acessível: " + acessivelString;
    }
}

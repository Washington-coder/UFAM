import java.util.ArrayList;

public class Ensalamento {
    ArrayList<Sala> salas;
    ArrayList<Turma> turmas;
    ArrayList<TurmaEmSala> ensalamento;
    
    Ensalamento(){
        
    }
    
    void addSala(Sala sala){
        salas.add(sala);
    }
    
    void addTurma(Turma turma){
        turmas.add(turma);
    }
    
    Sala getSala(Turma turma){
        for (TurmaEmSala turmaIndex : ensalamento){
            if (turmaIndex.turma == turma){
                return turmaIndex.sala;
            }
        }
        return null;
    }
    
    boolean salaDisponivel(Sala sala, int horario){
        for (TurmaEmSala turmaIndex : ensalamento){
            if (turmaIndex.sala == sala){
                for (int i = 0; i < turmaIndex.turma.horarios.size(); i++) {
                    if (turmaIndex.turma.horarios.get(i) == horario){
                        return false;
                    }    
                }
            }
        }
        return true;
    }

    boolean salaDisponivel(Sala sala, ArrayList<Integer> horarios){
        return true;
    }

    boolean salaDisponivelEmTodosHorarios(Turma turma, Sala sala){
        for (int i = 0; i < turma.horarios.size(); i++) {
            if (!salaDisponivel(sala, turma.horarios.get(i))){
                return false;
            }
        }
        return true;
    }

    boolean alocar(Turma turma, Sala sala){
        int contador = 0;

        if (sala.acessivel){
            contador++;
        }

        if (turma.numAlunos <= sala.capacidade){
            contador++;
        }

        if (salaDisponivelEmTodosHorarios(turma, sala)){
            contador++;
        }

        if (contador == 3){
            return true;
        }else{
            return false;
        }
    }

    void alocarTodas(){
        for (TurmaEmSala turmaEmSala : ensalamento) {
            alocar(turmaEmSala.turma, turmaEmSala.sala);
        }
    } 

    int getTotalTurmasAlocadas(){
        int contador = 0;
        for (TurmaEmSala turmaEmSala : ensalamento) {
            if (turmaEmSala.sala != null){
                contador++;
            }
        }
        return contador;
    }

    int getTotalEspacoLivre(){
        int total = 0;

        for (TurmaEmSala turmaEmSala : ensalamento) {
            if (turmaEmSala.sala != null){
                total += turmaEmSala.sala.capacidade - turmaEmSala.turma.numAlunos;
            }
        }

        return total;
    }

    String relatorioResumoEnsalamento(){
        return "Total de Salas: " + getTotalTurmasAlocadas() + "\n" ;
    }

    String relatorioTurmasPorSala(){
        return "";
    }

    String relatorioSalasPorTurma(){
        return "";
    }


}

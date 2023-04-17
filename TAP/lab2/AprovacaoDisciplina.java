import java.util.ArrayList;
import java.util.Scanner;

public class AprovacaoDisciplina {
    public static void main(String[] args){
        ArrayList<Double> notaAlunos = new ArrayList<Double>();
        ArrayList<Integer> frequenciaAlunos = new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);
        double nota, cargaHorariaDisciplina, cargaHorariaMinima;
        int presencas, aprovados = 0, reprovadosPorNota = 0, reprovadosPorFrequencia = 0;

        nota = scan.nextDouble();
        while(nota != -1){
            notaAlunos.add(nota);
            nota = scan.nextDouble();
        }
        presencas = scan.nextInt();
        while(presencas != -1){
            frequenciaAlunos.add(presencas);
            presencas = scan.nextInt();
        }
        cargaHorariaDisciplina = scan.nextDouble();

        scan.close();

        cargaHorariaMinima = cargaHorariaDisciplina * 0.75;

        for (int i = 0; i < notaAlunos.size(); i++) {
            if (notaAlunos.get(i) >= 5.0 && frequenciaAlunos.get(i) >= cargaHorariaMinima){
                aprovados++;
            }
            else if(frequenciaAlunos.get(i) < cargaHorariaMinima){
                reprovadosPorFrequencia++;
            }
            else if(notaAlunos.get(i) < 5.0){
                reprovadosPorNota++;
            }
        }
        System.out.printf("%d %d %d", aprovados, reprovadosPorNota, reprovadosPorFrequencia);
    }
}


public class TurmaMain {
    public static void main(String[] args) {
        Turma t1 = new Turma("Sistemas Operacionais", "Andrew S. Tanenbaum", 65, true);
        t1.addHorario(5);
        t1.addHorario(19);
        t1.addHorario(33);
        System.out.println(t1.getHorariosString());
    }
}

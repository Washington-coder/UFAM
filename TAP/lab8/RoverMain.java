package br.edu.ufam.icomp.lab_excecoes;
public class RoverMain {
    public void main(String[] args) throws RoverException {
        Caminho c = new Caminho(6);
        try {
            Coordenada r1 = new Coordenada(23, 55, 8);
            c.addCoordenada(r1);
            Coordenada r2 = new Coordenada(27, 65, 2);
            c.addCoordenada(r2);
            Coordenada r3 = new Coordenada(37, 70, 7);
            c.addCoordenada(r3);
            Coordenada r4 = new Coordenada(48, 74, 2);
            c.addCoordenada(r4);
            Coordenada r5 = new Coordenada(62, 74, 6);
            c.addCoordenada(r5);
            Coordenada r6 = new Coordenada(63, 74, 7);
            c.addCoordenada(r6);
            Coordenada r7 = new Coordenada(77, 74, 1);
            c.addCoordenada(r7);

            System.out.println(c.toString());
        } catch (RoverException e) {
            System.out.println(e.getMessage());
            c.reset();
        }
    }
}

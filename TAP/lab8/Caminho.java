
package br.edu.ufam.icomp.lab_excecoes;
import java.util.ArrayList;
import java.util.Arrays;

public class Caminho {
    private Coordenada[] caminho = new Coordenada[0];
    // private int tamanho = 0;
    private int tamanho;

    public Caminho(int maxTam) {
        // this.tamanho = 0;
        this.tamanho = maxTam;
    }

    public int tamanho() {
        return caminho.length;
    }

    public void addCoordenada(Coordenada coordenada)
            throws TamanhoMaximoExcedidoException, DistanciaEntrePontosExcedidaException {

        Coordenada ultimCoordenada;
        // tamanho++;

        if (caminho.length > 0) {
            int digito = (caminho[caminho.length - 1].getPosX() + caminho[caminho.length - 1].getPosY()) % 10;
            try {
                ultimCoordenada = new Coordenada(caminho[caminho.length - 1].getPosX(),
                        caminho[caminho.length - 1].getPosY(), digito);
            } catch (Exception e) {
                ultimCoordenada = null;
            }
        } else {
            ultimCoordenada = coordenada;
        }

        if (ultimCoordenada.distancia(coordenada) > 15) {
            throw new DistanciaEntrePontosExcedidaException();
        }

        if (caminho.length >= this.tamanho) {
            throw new TamanhoMaximoExcedidoException();
        }

        Coordenada[] novoCaminho = Arrays.copyOf(caminho, caminho.length + 1);
        novoCaminho[novoCaminho.length - 1] = coordenada;

        caminho = novoCaminho;

    }

    public void reset() {
        Coordenada[] novoCaminho = new Coordenada[0];
        caminho = novoCaminho;
        this.tamanho = 0;
    }

    public String toString() {
        String baseMsg = "Dados do caminho:\n  - Quantidade de pontos: " + caminho.length + "\n  - Pontos:\n";
        String data = "";

        if (caminho.length > 0) {
            for (int i = 0; i < caminho.length; i++) {
                int posX = caminho[i].getPosX();
                int posY = caminho[i].getPosY();
                data += "    -> " + posX + ", " + posY + "\n";
            }
        }

        return baseMsg + data;
    }
}

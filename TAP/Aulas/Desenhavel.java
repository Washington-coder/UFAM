package Aulas;

public interface Desenhavel {
    int COR_VERMELHO = 1;
    int COR_VERDE = 2;
    int COR_AZUL = 3;

    void setCor(int cor);
    void desenha();
}
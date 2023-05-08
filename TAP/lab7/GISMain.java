package br.edu.ufam.icomp.lab_encapsulamento;

import java.util.ArrayList;

public class GISMain {
    public static void main(String[] args) {

        Localizavel[] localizaveis = new Localizavel[2];
        
        localizaveis[0] = new Celular(0, 0, 0);
        localizaveis[1] = new CarroLuxuoso("abc");

        for (int i = 0; i < localizaveis.length; i++) {
            System.out.println(localizaveis[i].getPosicao());
        }

    }
}

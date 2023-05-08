package br.edu.ufam.icomp.lab_encapsulamento;

import java.util.Random;

public class Celular implements Localizavel {
    private int codPais;
    private int codArea;
    private int numero;
    private Posicao posicao;

    public Celular(int codPais, int codArea, int numero) {
        setCodPais(codPais);
        setCodArea(codArea);
        setNumero(numero);
        double latitude, longitude, altitude;
        Random rand = new Random();

        latitude = -3.160000 + ((-2.960000) - (-3.160000)) * rand.nextDouble();
        longitude = -60.120000 + ((-59.820000) - (-60.120000)) * rand.nextDouble();
        altitude = 15.0 + ((100.0) - (15.0)) * rand.nextDouble();

        this.posicao = new Posicao(latitude, longitude, altitude);
    }

    public final void setCodPais(int codPais) {
        if (codPais > 1 && codPais <= 1999){
            this.codPais = codPais;
        }else{
            this.codPais = -1;
        }
	}

    public int getCodPais() {
        return this.codPais;
    }

    public final void setCodArea(int codArea) {
        if (codArea > 10 && codArea <= 99){
            this.codArea = codArea;
        }else{
            this.codArea = -1;
        }
	}

    public int getCodArea(){
        return this.codArea;
    }

    public final void setNumero(int numero) {
        if (numero > 10000000 && numero <= 999999999){
            this.numero = numero;
        }else{
            this.numero = -1;
        }
    }

    public int getNumero() {
        return this.numero;
    }

    public Posicao getPosicao() {
        return this.posicao;
    }

    public double getErroLocalizacao(){
        return 50.0;
    }
}

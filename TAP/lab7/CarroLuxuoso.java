package br.edu.ufam.icomp.lab_encapsulamento;

import java.util.Random;

public class CarroLuxuoso extends Carro implements Localizavel{
    private Posicao posicao;

    public CarroLuxuoso (String placa){
        super(placa);
        setPlaca(placa);

        double latitude, longitude, altitude;
        Random rand = new Random();

        latitude = -3.160000 + ((-2.960000) - (-3.160000)) * rand.nextDouble();
        longitude = -60.120000 + ((-59.820000) - (-60.120000)) * rand.nextDouble();
        altitude = 15.0 + ((100.0) - (15.0)) * rand.nextDouble();

        this.posicao = new Posicao(latitude, longitude, altitude);
    }

    public Posicao getPosicao(){
        return this.posicao;
    }

    public double getErroLocalizacao(){
        return 15.0;
    }
}

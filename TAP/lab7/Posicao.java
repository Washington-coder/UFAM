package br.edu.ufam.icomp.lab_encapsulamento;

public class Posicao {
	private double latitude;
	private double longitude;
	private double altitude;
	
	public Posicao(double latitude, double longitude, double altitude){
		this.setLatitude(latitude);
		this.setLongitude(longitude);
		this.setAltitude(altitude);
	}
	
	public String toString() {
		// String resultado = String.format("Posição: %.6f, %.6f, %.f", this.latitude, this.longitude, this.altitude);
		return "Posição: " + this.latitude + ", " + this.longitude + ", " +  this.altitude;
	}

	public double getAltitude() {
		return this.altitude;
	}

	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}

	public double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
}

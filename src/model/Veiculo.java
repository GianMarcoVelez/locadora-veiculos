package model;

import java.io.Serializable;

public abstract class Veiculo implements Serializable {
    private String modelo;
    private String placa;
    private double valorDiaria;

    public Veiculo(String modelo, String placa, double valorDiaria) {
        this.modelo = modelo;
        this.placa = placa;
        this.valorDiaria = valorDiaria;
    }

    public abstract double calcularPrecoTotal(int dias);

    public String getModelo() { return modelo; }
    public String getPlaca() { return placa; }
    public double getValorDiaria() { return valorDiaria; }

    @Override
    public String toString() {
        return "Veículo: " + modelo + " | Placa: " + placa + " | Diária: R$" + valorDiaria;
    }
}
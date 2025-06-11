package model;

import java.io.Serializable;

public class Locacao implements Serializable {
    private Cliente cliente;
    private Veiculo veiculo;
    private int dias;
    private double valorTotal;

    public Locacao(Cliente cliente, Veiculo veiculo, int dias) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dias = dias;
        this.valorTotal = veiculo.calcularPrecoTotal(dias);
    }

    public Cliente getCliente() { return cliente; }
    public Veiculo getVeiculo() { return veiculo; }
    public int getDias() { return dias; }
    public double getValorTotal() { return valorTotal; }

    @Override
    public String toString() {
        return "Locação: " + cliente.getNome() + " alugou " + veiculo.getModelo() +
               " por " + dias + " dias. Total: R$" + valorTotal;
    }
}
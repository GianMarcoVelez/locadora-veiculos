package model;

public class Carro extends Veiculo {
    private boolean arCondicionado;

    public Carro(String modelo, String placa, double valorDiaria, boolean arCondicionado) {
        super(modelo, placa, valorDiaria);
        this.arCondicionado = arCondicionado;
    }

    @Override
    public double calcularPrecoTotal(int dias) {
        double precoBase = getValorDiaria() * dias;
        return arCondicionado ? precoBase * 1.1 : precoBase;
    }

    @Override
    public String toString() {
        return super.toString() + " | Ar Condicionado: " + (arCondicionado ? "Sim" : "Não");
    }
}
package model;

public class Moto extends Veiculo {
    private boolean partidaEletrica;

    public Moto(String modelo, String placa, double valorDiaria, boolean partidaEletrica) {
        super(modelo, placa, valorDiaria);
        this.partidaEletrica = partidaEletrica;
    }

    @Override
    public double calcularPrecoTotal(int dias) {
        return partidaEletrica ? getValorDiaria() * dias * 1.05 : getValorDiaria() * dias;
    }

    @Override
    public String toString() {
        return super.toString() + " | Partida Elétrica: " + (partidaEletrica ? "Sim" : "Não");
    }
}
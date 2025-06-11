package controller;

import model.Cliente;
import model.Veiculo;
import utils.LogSistema;

import java.util.ArrayList;
import java.util.List;

public class LocacaoController {
    private List<String> locacoes;

    public LocacaoController() {
        locacoes = new ArrayList<>();
    }

    public void locarVeiculo(Cliente cliente, Veiculo veiculo, int dias) {
        double total = veiculo.calcularPrecoTotal(dias);
        locacoes.add("Cliente " + cliente.getNome() + " alugou " + veiculo.getModelo() +
                " por " + dias + " dias. Total: R$" + total);
        LogSistema.registrar("Locação realizada: Cliente " + cliente.getNome() +
                " alugou " + veiculo.getModelo() + " por " + dias + " dias. Total: R$" + total);
        System.out.println("Locação realizada com sucesso! Total a pagar: R$" + total);
    }

    public void listarLocacoes() {
        if (locacoes.isEmpty()) {
            System.out.println("Nenhuma locação realizada.");
            return;
        }
        locacoes.forEach(System.out::println);
    }
}
package controller;

import model.Veiculo;
import utils.Serializador;
import utils.LogSistema;

import java.util.ArrayList;
import java.util.List;

public class VeiculoController {
    private static final String ARQUIVO_VEICULOS = "data/veiculos.dat";
    private List<Veiculo> veiculos;

    public VeiculoController() {
        veiculos = Serializador.carregarDados(ARQUIVO_VEICULOS);
        if (veiculos == null) {
            veiculos = new ArrayList<>();
        }
    }

    public void cadastrarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
        Serializador.salvarDados(veiculos, ARQUIVO_VEICULOS);
        LogSistema.registrar("Veículo cadastrado: " + veiculo.getModelo() + " - Placa: " + veiculo.getPlaca());
        System.out.println("Veículo cadastrado com sucesso!");
    }

    public void listarVeiculos() {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }
        veiculos.forEach(System.out::println);
    }

    public void removerVeiculo(String placa) {
        Veiculo veiculo = buscarVeiculoPorPlaca(placa);
        if (veiculo != null) {
            veiculos.remove(veiculo);
            Serializador.salvarDados(veiculos, ARQUIVO_VEICULOS);
            LogSistema.registrar("Veículo removido: " + veiculo.getModelo() + " - Placa: " + veiculo.getPlaca());
            System.out.println("Veículo removido com sucesso!");
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }

    public Veiculo buscarVeiculoPorPlaca(String placa) {
        return veiculos.stream()
                .filter(v -> v.getPlaca().equalsIgnoreCase(placa))
                .findFirst()
                .orElse(null);
    }
}
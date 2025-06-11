package controller;

import model.Cliente;
import utils.Serializador;
import utils.LogSistema;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    private static final String ARQUIVO_CLIENTES = "data/clientes.dat";
    private List<Cliente> clientes;

    public ClienteController() {
        clientes = Serializador.carregarDados(ARQUIVO_CLIENTES);
        if (clientes == null) {
            clientes = new ArrayList<>();
        }
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
        Serializador.salvarDados(clientes, ARQUIVO_CLIENTES);
        LogSistema.registrar("Cliente cadastrado: " + cliente.getNome() + " - CPF: " + cliente.getCpf());
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        clientes.forEach(System.out::println);
    }

    public Cliente buscarClientePorCpf(String cpf) {
        return clientes.stream()
                .filter(c -> c.getCpf().equalsIgnoreCase(cpf))
                .findFirst()
                .orElse(null);
    }

    public void removerCliente(String cpf) {
        Cliente cliente = buscarClientePorCpf(cpf);
        if (cliente != null) {
            clientes.remove(cliente);
            Serializador.salvarDados(clientes, ARQUIVO_CLIENTES);
            LogSistema.registrar("Cliente removido: " + cliente.getNome() + " - CPF: " + cliente.getCpf());
            System.out.println("Cliente removido com sucesso!");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
}
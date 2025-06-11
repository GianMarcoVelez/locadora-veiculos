package view;

import java.util.Scanner;
import controller.VeiculoController;
import controller.ClienteController;
import controller.LocacaoController;
import model.Carro;
import model.Moto;
import model.Cliente;
import model.Veiculo;

public class Menu {
    private Scanner scanner;
    private VeiculoController veiculoController;
    private ClienteController clienteController;
    private LocacaoController locacaoController;

    public Menu() {
        scanner = new Scanner(System.in);
        veiculoController = new VeiculoController();
        clienteController = new ClienteController();
        locacaoController = new LocacaoController();
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n--- Locadora de Veículos ---");
            System.out.println("1. Cadastrar Veículo");
            System.out.println("2. Listar Veículos");
            System.out.println("3. Remover Veículo");
            System.out.println("4. Cadastrar Cliente");
            System.out.println("5. Listar Clientes");
            System.out.println("6. Realizar Locação");
            System.out.println("7. Listar Locações");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            processarOpcao(opcao);
        } while (opcao != 8);

        System.out.println("Sistema encerrado. Obrigado por utilizar!");
    }

    private void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                cadastrarVeiculo();
                break;
            case 2:
                veiculoController.listarVeiculos();
                break;
            case 3:
                removerVeiculo();
                break;
            case 4:
                cadastrarCliente();
                break;
            case 5:
                clienteController.listarClientes();
                break;
            case 6:
                realizarLocacao();
                break;
            case 7:
                locacaoController.listarLocacoes();
                break;
            case 8:
                System.out.println("Saindo do sistema...");
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
        }
    }

    private void cadastrarVeiculo() {
        System.out.print("Informe o modelo do veículo: ");
        String modelo = scanner.nextLine();
        System.out.print("Informe a placa do veículo: ");
        String placa = scanner.nextLine();
        System.out.print("Informe o valor da diária: ");
        double valorDiaria = scanner.nextDouble();
        scanner.nextLine(); // Limpar buffer

        System.out.print("O veículo é um carro ou uma moto? (carro/moto): ");
        String tipo = scanner.nextLine().toLowerCase();

        if (tipo.equals("carro")) {
            System.out.print("Possui ar-condicionado? (sim/não): ");
            boolean arCondicionado = scanner.nextBoolean();
            veiculoController.cadastrarVeiculo(new Carro(modelo, placa, valorDiaria, arCondicionado));
        } else if (tipo.equals("moto")) {
            System.out.print("Possui partida elétrica? (sim/não): ");
            boolean partidaEletrica = scanner.nextBoolean();
            veiculoController.cadastrarVeiculo(new Moto(modelo, placa, valorDiaria, partidaEletrica));
        } else {
            System.out.println("Tipo de veículo inválido!");
        }
    }

    private void removerVeiculo() {
        System.out.print("Informe a placa do veículo que deseja remover: ");
        String placa = scanner.nextLine();
        veiculoController.removerVeiculo(placa);
    }

    private void cadastrarCliente() {
        System.out.print("Informe o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Informe o CPF do cliente: ");
        String cpf = scanner.nextLine();

        clienteController.cadastrarCliente(new Cliente(nome, cpf));
    }

    private void realizarLocacao() {
        System.out.print("Informe o CPF do cliente: ");
        String cpf = scanner.nextLine();
        Cliente cliente = clienteController.buscarClientePorCpf(cpf);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        System.out.print("Informe a placa do veículo: ");
        String placa = scanner.nextLine();
        Veiculo veiculo = veiculoController.buscarVeiculoPorPlaca(placa);

        if (veiculo == null) {
            System.out.println("Veículo não encontrado.");
            return;
        }

        System.out.print("Informe o número de dias da locação: ");
        int dias = scanner.nextInt();

        locacaoController.locarVeiculo(cliente, veiculo, dias);
    }
}
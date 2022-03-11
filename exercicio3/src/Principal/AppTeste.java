package Principal;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import Principal.enums.TipoPessoa;
import Principal.enums.TipoVeiculo;

public class AppTeste {

    private static boolean verificar = true;
    private static DummyDB dummyDB = new DummyDB();

    public static void limparTela() throws InterruptedException, IOException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public static void main(String[] args) throws InterruptedException, IOException {

        limparTela();
        System.out.println("Seja bem Vindo A Revenda Cachoeiro");

        Scanner ler = new Scanner(System.in);
        int indiceMenu = 0;
        do {
            System.out.println("\nSelecione a opção desejada:");
            System.out.println("1 - Venda de Veículo");
            System.out.println("2 - Compra de Veículo");
            System.out.println("3 - Cadastrar Cliente");
            System.out.println("4 - Cadastrar Vendedor");
            System.out.println("5 - Cadastrar Veiculo");
            System.out.println("6 - Exibir Lista de Clientes");
            System.out.println("7 - Exibir Lista de Vendas");
            System.out.println("8 - Exibir Lista de Compras");
            System.out.println("9 - Sair\n");
            indiceMenu = ler.nextInt();
            validarMenu(indiceMenu, ler);
        } while (verificar);
        limparTela();
        System.out.println("Obrigado por utilizar o sistema!");

    }

    private static void validarMenu(int valor, Scanner ler) {

        switch (valor) {
            case 1:
                realizarVenda(ler);
                break;
            case 2:
                realizarCompra(ler);
                break;
            case 3:
                limparBuffer(ler);
                cadastrarCliente(selecionarTipoPessoa(ler), ler);
                break;
            case 4:
                limparBuffer(ler);
                cadastrarVendedor(selecionarTipoPessoa(ler), ler);
                break;
            case 5:
                cadastrarVeiculo(selecionarTipoVeiculo(ler), ler);
                break;
            case 6:
                exibirListaClientes();
                break;
            case 7:
                exibirListaVendas();
                break;
            case 8:
                exibirListaCompras();
                break;
            case 9:
                verificar = false;
                break;

            default:
                break;
        }

    }

    private static void exibirListaCarros() {
        if (dummyDB.getCarrosDB().size() == 0) {
            System.out.println("Não há nenhum carro cadastrado.");
        } else {

            System.out.println("--- Listagem dos Carros ---\n");
            System.out.printf("%-13s %-10s %-10s %-8s\n", "Placa", "Nome", "Preço", "Ano");
            System.out.println("----------------------------------------------------------");
            for (Carro c : dummyDB.getCarrosDB()) {
                System.out.printf("%-13s %-10s %-10s %-8s \n", c.getPlaca(), c.getNomeVeiculo(), c.getPreco(), c.getAno());
            }
            System.out.println("----------------------------------------------------------");
        }
    }

    private static void exibirListaMotos() {
        if (dummyDB.getMotosDB().size() == 0) {
            System.out.println("Não há nenhuma moto cadastrada. \n");
        } else {

            System.out.println("--- Listagem das Motos ---\n");
            System.out.printf("%-15s %-10s %-10s %-8s\n", "Placa", "Nome", "Preço", "Ano");
            System.out.println("----------------------------------------------------------");
            for (Moto m : dummyDB.getMotosDB()) {
                System.out.printf("%-15s %-10s %-10s %-8s \n", m.getPlaca(), m.getNomeVeiculo(), m.getPreco(),
                        m.getAno());
            }
            System.out.println("----------------------------------------------------------");
        }
    }

    private static void exibirListaVendas() {

        if (dummyDB.getVendasDB().size() == 0) {
            System.out.println("Não há nenhuma Venda Realizada. \n");
        } else {

            System.out.println("--- Listagem de Vendas ---\n");
            System.out.printf("%-30s %-10s %-10s %-8s\n", "Data", "Valor Final", "Vendedor", "Carro");
            System.out.println("-----------------------------------------------------------------------------------------");
            for (Venda v : dummyDB.getVendasDB()) {
                System.out.printf("%-30s %-10s %-10s %-8s \n", v.getDataVenda(), v.getValorFinal(), v.getVendedor().getNome(), v.getVeiculo().getNomeVeiculo());
            }
            System.out.println("-----------------------------------------------------------------------------------------");
        }
    }

    private static void exibirListaCompras() {

        if (dummyDB.getComprasDB().size() == 0) {
            System.out.println("Não há nenhuma Compra realizada. \n");
        } else {

            System.out.println("--- Listagem de Vendas ---\n");
            System.out.printf("%-30s %-10s %-10s %-8s\n", "Data", "Valor Final", "Vendedor", "Carro");
            System.out.println("-----------------------------------------------------------------------------------");
            for (Compra c : dummyDB.getComprasDB()) {
                System.out.printf("%-30s %-10s %-10s %-8s \n", c.getDataCompra(), c.getValorFinal(), c.getVendedor().getNome(), c.getVeiculo().getNomeVeiculo());
            }
            System.out.println("-----------------------------------------------------------------------------------");
        }
    }

    private static void exibirListaClientes() {

        if (dummyDB.getClientesDB().size() == 0) {
            System.out.println("Não há nenhum cliente cadastrado.\n");
        } else {

            System.out.println("--- Listagem dos Clientes ---\n");
            System.out.printf("%-15s %-15s %-10s \n", "Nome", "CPF", "Telefone");
            System.out.println("-----------------------------------------------------");
            for (Cliente c : dummyDB.getClientesDB()) {
                System.out.printf("%-15s %-15s %-10s \n", c.getNome(), c.getCpfCnpj(),c.getTelefone());
            }
            System.out.println("-----------------------------------------------------");
        }
    }

    private static void realizarVenda(Scanner ler) {

        Venda venda;
        Cliente cliente;
        Veiculo veiculo = null;
        Vendedor vendedor;

        String placa = "";
        String cpfCnpj;
        int controle = 0;

        if (dummyDB.getCarrosDB().size() == 0 && dummyDB.getMotosDB().size() == 0) {
            System.out.println("Não há nenhum veiculo disponivel para venda.");
        } else {
            if (dummyDB.getVendedoresDB().size() == 0) {
                System.out.println(
                        "Para realizar esse tipo de operação é necessário que um funcionário esteja cadastrado.");

            } else {

                do {
                    System.out.println("CPF ou Cnpj do Vendedor da Empresa: ");
                    cpfCnpj = tratarString(ler, "CPF ou CNPJ", false);

                    vendedor = dummyDB.getVendedorByDocumento(cpfCnpj);

                    if (vendedor == null) {
                        System.out.println("Vendedor não encontrado. Tente novamente!");
                    }
                } while (vendedor == null);

                do {
                    System.out.println("CPF ou Cnpj do Cliente: ");
                    cpfCnpj = tratarString(ler, "CPF ou CNPJ", false);

                    cliente = dummyDB.getClienteByDocumento(cpfCnpj);

                    if (cliente == null) {
                        System.out.println("Cliente não cadastrado no sistema!\n");
                        System.out.println("Cadastrando Cliente...");
                        cliente = cadastrarCliente(selecionarTipoPessoa(ler), ler);
                        dummyDB.getClientesDB().add(cliente);
                        System.out.println("Cliente Cadastrado com Sucesso. \n");
                    }
                } while (cliente == null);

                System.out.println("O que deseja comprar:\n 1 - Carro\n 2 - Moto");
                do {
                    controle = ler.nextInt();

                    if (controle != 1 && controle != 2) {
                        System.out.println("Digite um valor valido. \n 1 - Carro\n 2 - Moto\n>");
                    }

                } while (controle != 1 && controle != 2);

                limparBuffer(ler);
                if (controle == 1) {
                    if (dummyDB.getCarrosDB().size() == 0) {
                        exibirListaCarros();
                    } else {

                        do {
                            exibirListaCarros();
                            System.out.println("Qual veiculo deseja comprar? Digite a placa: ");
                            placa = ler.nextLine();
                            veiculo = dummyDB.getVeiculoByPlaca(TipoVeiculo.CARRO, placa);

                            if (veiculo == null) {
                                System.out.println("Veiculo não encontrado, digite novamente uma placa.");
                            }
                        } while (veiculo == null);
                    }

                } else if (controle == 2) {
                    if (dummyDB.getMotosDB().size() == 0) {
                        exibirListaMotos();
                    } else {
                        do {
                            exibirListaMotos();
                            System.out.println("Qual veiculo deseja comprar? Digite a placa: ");
                            placa = ler.nextLine();
                            veiculo = dummyDB.getVeiculoByPlaca(TipoVeiculo.MOTO, placa);
                            if (veiculo == null) {
                                System.out.println("\nVeiculo não encontrado, digite novamente uma placa.");
                            }
                        } while (veiculo == null);
                    }
                }

                venda = new Venda(LocalDateTime.now(), veiculo.getPreco(), vendedor, veiculo);
                dummyDB.getVendasDB().add(venda);
                System.out.println("Venda Realizada com Sucesso!");
                
                System.out.println(venda.toString());

            }
        }
    }

    private static void realizarCompra(Scanner ler) {

        Cliente cliente;
        Veiculo veiculo;
        Vendedor vendedor;
        Compra compra;
        String cpfCnpj;

        if (dummyDB.getVendedoresDB().size() == 0) {
            System.out
                    .println("Para realizar esse tipo de operação é necessário que um Vendedor esteja cadastrado.");
        } else {
            do {
                System.out.println("CPF ou Cnpj do Vendedor da Empresa: ");
                cpfCnpj = tratarString(ler, "CPF ou CNPJ", false);

                vendedor = dummyDB.getVendedorByDocumento(cpfCnpj);

                if (vendedor == null) {
                    System.out.println("Vendedor não encontrado. Tente novamente!");
                }
            } while (vendedor == null);

            do {
                System.out.println("CPF ou Cnpj do Cliente: ");
                cpfCnpj = tratarString(ler, "CPF ou CNPJ", false);

                cliente = dummyDB.getClienteByDocumento(cpfCnpj);

                if (cliente == null) {
                    System.out.println("Cliente não cadastrado no sistema!\n");
                    System.out.println("Cadastrando Cliente...");
                    cliente = cadastrarCliente(selecionarTipoPessoa(ler), ler);
                    dummyDB.getClientesDB().add(cliente);
                    System.out.println("Cliente Cadastrado com Sucesso. \n");
                }
            } while (cliente == null);

            System.out.println("Informe os dados do veiculo que deseja vender.");
            veiculo = cadastrarVeiculo(selecionarTipoVeiculo(ler), ler);
            compra = new Compra(LocalDateTime.now(), veiculo.getPreco(), vendedor, veiculo);
            dummyDB.getComprasDB().add(compra);
            System.out.println("Veiculo Vendido com sucesso.");

        }

    }

    private static TipoVeiculo selecionarTipoVeiculo(Scanner ler) {

        TipoVeiculo tipoVeiculo;
        System.out.println("Tipo do veiculo (Carro ou Moto): ");
        limparBuffer(ler);
        tipoVeiculo = Enum.valueOf(TipoVeiculo.class, tratarEnums(ler, "Tipo de Veiculo", TipoVeiculo.values()));

        return tipoVeiculo;
    }

    private static TipoPessoa selecionarTipoPessoa(Scanner ler) {

        TipoPessoa tipoPessoa;
        System.out.println("Tipo da Pessoa(Fisica ou Juridica): ");
        tipoPessoa = Enum.valueOf(TipoPessoa.class, tratarEnums(ler, "Tipo de Pessoa", TipoPessoa.values()));

        return tipoPessoa;
    }

    private static Veiculo cadastrarVeiculo(TipoVeiculo v, Scanner ler) {
        Moto moto;
        Carro carro;
        int controleCategoria = 0;

        double preco;
        String placa;
        int ano;
        int capacidadeTanque;
        String nomeVeiculo;
        String cor;
        String cambio;
        String marca;

        String categoria = "";
        double versao;
        int qntPorta;

        int cilindrada;
        String tipoDePartida;

        System.out.println("Nome do Veiculo: ");
        nomeVeiculo = tratarString(ler, "Nome do Veiculo", false);

        System.out.println("Preço: ");
        preco = tratarDouble(ler, "Preço");

        System.out.println("Ano: ");
        ano = tratarInt(ler, "Ano");

        limparBuffer(ler);
        System.out.println("Placa: ");
        placa = tratarString(ler, "Placa", false);

        System.out.println("Capacidade do Tanque: ");
        capacidadeTanque = tratarInt(ler, "Capacidade do Tanque");

        limparBuffer(ler);
        System.out.println("Cor: ");
        cor = tratarString(ler, "Cor", false);

        System.out.println("Cambio: ");
        cambio = tratarString(ler, "Cambio", false);

        System.out.println("Marca: ");
        marca = tratarString(ler, "Marca", false);

        if (v.equals(TipoVeiculo.CARRO)) {

            System.out.println("Categoria: ");
            do {
                System.out.println("1 - Hatch\n2 - Sedan\n3 - Caminhonetes\n4 - SUV");
                controleCategoria = ler.nextInt();

                if (controleCategoria == 1) {
                    categoria = "Hatch";
                } else if (controleCategoria == 2) {
                    categoria = "Sedan";
                } else if (controleCategoria == 3) {
                    categoria = "Caminhonetes";
                } else if (controleCategoria == 4) {
                    categoria = "SUV";
                } else {
                    System.out.println("Informe o valor correto\n");
                    controleCategoria = 5;
                }

            } while (controleCategoria == 5);

            System.out.println("Versão (1.0): ");
            versao = tratarDouble(ler, "Versão");

            limparBuffer(ler);
            System.out.println("Quantidade de Portas: ");
            qntPorta = tratarInt(ler, "Quantidade de Portas");

            carro = new Carro(placa, preco, ano, capacidadeTanque, nomeVeiculo, marca, cor, cambio, v, categoria,
                    versao,
                    qntPorta);
            dummyDB.getCarrosDB().add(carro);

            return carro;
        } else {

            System.out.println("Cilindrada: ");
            cilindrada = tratarInt(ler, "Cilindrada");

            ler.nextLine();
            System.out.println("Tipo de Partida: ");
            tipoDePartida = tratarString(ler, "Tipo de Pida", false);
            moto = new Moto(placa, preco, ano, capacidadeTanque, nomeVeiculo, marca, cor, cambio, v, cilindrada,
                    tipoDePartida);
            dummyDB.getMotosDB().add(moto);

            return moto;
        }
    }

    private static Cliente cadastrarCliente(TipoPessoa p, Scanner ler) {

        Cliente cliente;
        String nome;
        String cpfCnpj;
        String telefone;

        System.out.println("Nome: ");
        nome = tratarString(ler, "Nome", false);

        System.out.println("CPF ou Cnpj: ");
        cpfCnpj = tratarString(ler, "CPF ou CNPJ", false);

        cliente = dummyDB.getClienteByDocumento(cpfCnpj);

        if (cliente != null) {
            System.out.println("Cliente já cadastrado!");
            return cliente;
        }

        System.out.println("Telefone: ");
        telefone = tratarString(ler, "Telefone", false);

        cliente = new Cliente(nome, p, cpfCnpj, telefone);
        dummyDB.getClientesDB().add(cliente);

        return cliente;

    }

    private static Vendedor cadastrarVendedor(TipoPessoa p, Scanner ler) {

        Vendedor vendedor;
        String nome;
        String cpfCnpj;
        String telefone;
        double comissao;

        System.out.println("CPF ou Cnpj: ");
        cpfCnpj = tratarString(ler, "CPF ou CNPJ", false);

        vendedor = dummyDB.getVendedorByDocumento(cpfCnpj);

        if (vendedor != null) {
            System.out.println("Vendedor já cadastrado!");
            return vendedor;
        }

        System.out.println("Nome: ");
        nome = tratarString(ler, "Nome", false);

        System.out.println("Telefone: ");
        telefone = tratarString(ler, "Telefone", false);

        System.out.println("Comissão: ");
        comissao = tratarDouble(ler, "Comissão");

        vendedor = new Vendedor(nome, p, cpfCnpj, telefone, comissao);
        dummyDB.getVendedoresDB().add(vendedor);

        return vendedor;
    }

    private static double tratarDouble(Scanner ler, String nomeAtributo) {

        double valor = 0;
        boolean erro = false;

        do {
            try {
                valor = ler.nextDouble();
                erro = false;
            } catch (InputMismatchException | NullPointerException e) {
                System.err.println(String.format("Valor inválido. Digite %s novamente!", nomeAtributo));
                erro = true;
                limparBuffer(ler);
            }

        } while (erro);

        return valor;
    }

    private static int tratarInt(Scanner ler, String nomeAtributo) {

        int valor = 0;
        boolean erro = false;

        do {
            try {
                valor = ler.nextInt();
                erro = false;
            } catch (InputMismatchException | NullPointerException e) {
                System.err.println(String.format("Valor inválido. Digite %s novamente!", nomeAtributo));
                erro = true;
                limparBuffer(ler);
            }

        } while (erro);

        return valor;
    }

    private static String tratarString(Scanner ler, String nomeAtributo, Boolean permitirBlank) {

        String valor = null;
        boolean erro = false;

        do {
            try {
                valor = ler.nextLine();
                erro = false;
                if (!permitirBlank) {
                    if (valor.isBlank() || valor == null) {
                        System.err.println(String.format(
                                "Campo não pode ser nulo ou está em branco. Digite %s novamente!", nomeAtributo));
                        erro = true;
                    }
                }

            } catch (InputMismatchException | NullPointerException e) {
                System.err.println(String.format("Valor inválido. Digite %s novamente!", nomeAtributo));
                erro = true;
                limparBuffer(ler);
            }

        } while (erro);

        return valor;
    }

    private static String tratarEnums(Scanner ler, String nomeAtributo, Object[] enumList) {

        String valor;
        boolean existe = false;
        do {
            valor = tratarString(ler, nomeAtributo, false);

            for (Object object : enumList) {
                if (String.valueOf(object).equals(valor.toUpperCase())) {
                    existe = true;
                    break;
                }
            }
            if (existe) {
                return valor.toUpperCase();
            } else {
                System.err.println(
                        String.format("Valor não Permitido, os valores permitidos são %s. Digite %s novamente!",
                                Arrays.toString(enumList), nomeAtributo));
                existe = false;
            }
        } while (!existe);
        return null;

    }

    private static void limparBuffer(Scanner ler) {
        ler.nextLine();
    }

}

package mapa.application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import mapa.controls.HospedeDAO;
import mapa.controls.HospedeImpl;
import mapa.controls.ReservaDAO;
import mapa.controls.ReservaImpl;
import mapa.controls.SuiteDAO;
import mapa.controls.SuiteImpl;
import mapa.dialogs.Mensagem;
import mapa.entities.Hospede;
import mapa.entities.Reserva;
import mapa.entities.Suite;
import mapa.exceptions.ElementoNaoEncontradoException;
import mapa.exceptions.ReservaInvalidaException;
import mapa.exceptions.ValorIncorretoException;

public class MAPA3_Hotel {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        ReservaDAO reservaDAO = new ReservaImpl();
        HospedeDAO hospedeDAO = new HospedeImpl();
        SuiteDAO suiteDAO = new SuiteImpl();

        List<Reserva> listaDeReservas = new ArrayList<>();
        int opcao;

        do {
            // Receber opção do menu
            do {
                try {
                    Mensagem.mostrarMenu();
                    opcao = Mensagem.inserirInteiro("");
                    if (opcao < 0 || opcao > 6) {
                        throw new ValorIncorretoException(Mensagem.erroNumerico());
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println(Mensagem.erroNumerico());
                } catch (ValorIncorretoException e) {
                    System.out.println(e.getMessage());
                }
            } while (true);
            // ---------------------

            switch (opcao) {
                // 1 - RESERVAR SUITE
                case 1 -> {
                    List<Hospede> listaDeHospedes = new ArrayList<>();
                    Reserva r;
                    Hospede h;
                    Suite s;
                    int qtdDeDiarias = 0;
                    int numeroDeHospedes = 0;
                    int codigo = 0, idade = 0;
                    int numeroDaSuite = 0, capacidade = 0;
                    String nome = null, endereco, tipo = null;
                    double valorDaDiaria = 0;

                    do {
                        try {
                            numeroDeHospedes = Mensagem.inserirInteiro("\nQuantidade de hóspedes: ");
                            if (numeroDeHospedes <= 0) {
                                throw new ValorIncorretoException(Mensagem.erroNumerico());
                            }
                            break;
                        } catch (ValorIncorretoException | InputMismatchException e) {
                            System.out.println(Mensagem.erroNumerico());
                        }
                    } while (true);

                    Mensagem.cadastrarHospedes();
                    for (int i = 0; i < numeroDeHospedes; i++) {
                        /*
                            Fornecendo dados dos hóspedes
                         */
                        System.out.println("\nDados do hóspede " + (i + 1) + ":");
                        // Código
                        do {
                            try {
                                codigo = Mensagem.inserirInteiro("Código do hóspede: ");
                                hospedeDAO.verificarCodigo(codigo);
                                break;
                            } catch (InputMismatchException | ValorIncorretoException e) {
                                System.out.println(Mensagem.erroNumerico());
                            }
                        } while (true);
                        // ---------------------

                        // Nome
                        do {
                            try {
                                nome = Mensagem.inserirTexto("Nome do hóspede: ");
                                hospedeDAO.verificarNome(nome);
                                break;
                            } catch (ValorIncorretoException e) {
                                System.out.println(Mensagem.erroValorVazio());
                            }
                        } while (true);
                        // ---------------------

                        // Endereço
                        endereco = Mensagem.inserirTexto("Endereço do hóspede: ");

                        // Idade do hóspede
                        do {
                            try {
                                idade = Mensagem.inserirInteiro("Idade do hóspede: ");
                                hospedeDAO.verificarIdade(idade);
                                break;
                            } catch (ValorIncorretoException | InputMismatchException e) {
                                System.out.println(Mensagem.erroNumerico());
                            }
                        } while (true);
                        // Instanciando um hóspede
                        h = new Hospede(codigo, nome, endereco, idade);
                        listaDeHospedes.add(h);
                    }

                    /*
                        Fornecendo dados da suite
                     */
                    Mensagem.cadastrarSuite();
                    // Número
                    do {
                        System.out.println("Dados da suite:");
                        try {
                            do {
                                try {
                                    numeroDaSuite = Mensagem.inserirInteiro("Número da suite: ");
                                    suiteDAO.verificarNumero(numeroDaSuite);
                                    if (reservaDAO.procurarReserva(listaDeReservas, numeroDaSuite)) {
                                        throw new ReservaInvalidaException(Mensagem.erroSuiteOcupada());
                                    }
                                    break;
                                } catch (ValorIncorretoException | InputMismatchException e) {
                                    System.out.println(Mensagem.erroNumerico());
                                }
                            } while (true);
                            // ---------------------

                            // Tipo
                            tipo = Mensagem.inserirTexto("Tipo da suíte: ");

                            // Capacidade
                            do {
                                try {
                                    capacidade = Mensagem.inserirInteiro("Capacidade da suíte: ");
                                    suiteDAO.verificarCapacidade(capacidade);
                                    if (!reservaDAO.verificarCapacidade(listaDeHospedes, capacidade)) {
                                        throw new ReservaInvalidaException(Mensagem.erroCapacidade());
                                    }
                                    break;
                                } catch (ValorIncorretoException | InputMismatchException e) {
                                    System.out.println(Mensagem.erroNumerico());
                                }
                            } while (true);
                            // ---------------------

                            // Valor diária
                            do {
                                try {
                                    valorDaDiaria = Mensagem.inserirReal("Valor da diária: R$ ");
                                    suiteDAO.verificarValor(valorDaDiaria);
                                    break;
                                } catch (ValorIncorretoException | InputMismatchException e) {
                                    System.out.println(Mensagem.erroNumerico());
                                }
                            } while (true);
                            break;
                        } catch (ReservaInvalidaException e) {
                            System.out.println(e.getMessage());
                        }
                    } while (true);

                    // Instanciando uma suite
                    s = new Suite(numeroDaSuite, tipo, capacidade, valorDaDiaria);

                    // Quantidade de diárias
                    do {
                        try {
                            qtdDeDiarias = Mensagem.inserirInteiro("Quantidade de diárias: ");
                            suiteDAO.verificarNumero(qtdDeDiarias);
                            break;
                        } catch (ValorIncorretoException | InputMismatchException e) {
                            System.out.println(e.getMessage());
                        }
                    } while (true);

                    // Instanciando uma reserva
                    r = new Reserva(s, numeroDeHospedes, qtdDeDiarias, listaDeHospedes);

                    // Adicionar a reserva à lista
                    reservaDAO.adicionarReserva(listaDeReservas, r);

                    // Mostrar reserva                    
                    Mensagem.sucessoReserva();
                    reservaDAO.mostrarReserva(r);
                }

                // 2 - Listar reservas
                case 2 -> {
                    try {
                        Mensagem.mostrarReservas();
                        if (reservaDAO.verificarReservas(listaDeReservas)) {
                            throw new ElementoNaoEncontradoException(Mensagem.erroNaoEncontrada());
                        } else {
                            reservaDAO.listarTodasAsReservas(listaDeReservas);
                        }
                    } catch (ElementoNaoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                }

                // 3 - Localizar suite
                case 3 -> {
                    Mensagem.mostrarSuite();
                    do {
                        int numeroSuite;
                        do {
                            try {
                                numeroSuite = Mensagem.inserirInteiro("Que suite deseja procurar ? \n> ");
                                suiteDAO.verificarNumero(numeroSuite);
                                break;
                            } catch (ValorIncorretoException | InputMismatchException e) {
                                System.out.println(Mensagem.erroNumerico());
                            }
                        } while (true);
                        try {
                            // Se não houver reservas cadastradas
                            if (reservaDAO.verificarReservas(listaDeReservas)) {
                                throw new ElementoNaoEncontradoException(Mensagem.erroNaoEncontrada());
                            } else {
                                try {
                                    // Se houver a suite, exibe, senão, lança erro
                                    Suite s = reservaDAO.procurarCodigoSuite(listaDeReservas, numeroSuite);
                                    reservaDAO.mostrarHospedeSuite(listaDeReservas, s.getNumero());
                                    break;
                                } catch (ElementoNaoEncontradoException e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                        } catch (ElementoNaoEncontradoException e) {
                            System.out.println(e.getMessage());
                        }
                    } while (true);
                }

                default -> {
                }

            }

            // 1 - RESERVAR SUITE
            // 1 - RESERVAR SUITE
            // 1 - RESERVAR SUITE
            // CADASTRAR
            // ALTERAR
            // LISTAR
            // LOCALIZAR POR NOME
            // EXCLUIR
            //coletarTexto("----Tecle ENTER para continuar----");
        } while (opcao != 0);
    }
}

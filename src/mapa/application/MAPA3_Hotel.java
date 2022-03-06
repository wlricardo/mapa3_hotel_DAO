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
import mapa.exceptions.ValorIncorretoException;

public class MAPA3_Hotel {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        ReservaDAO reservaDAO = new ReservaImpl();
        HospedeDAO hospedeDAO = new HospedeImpl();
        SuiteDAO suiteDAO = new SuiteImpl();

        List<Reserva> listaReservas = new ArrayList<>();
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
                    int numeroDeHospedes = 0;
                    int codigo = 0, idade = 0;
                    String nome = null, endereco = null;
                    List<Hospede> listaDeHospedes = new ArrayList<>();

                    Mensagem.cadastrarHospedes();
                    // Receber número de hóspedes
                    do {
                        try {
                            numeroDeHospedes = Mensagem.inserirInteiro("Quantidade de hóspedes: ");
                            if (numeroDeHospedes <= 0) {
                                throw new ValorIncorretoException(Mensagem.erroNumerico());
                            }
                            break;
                        } catch (ValorIncorretoException e) {
                            System.out.println(e.getMessage());
                        } catch (InputMismatchException e) {
                            Mensagem.erroNumerico();
                        }
                    } while (true);

                    /*
                        Fornecendo dados dos hóspedes
                     */
                    for (int i = 0; i < numeroDeHospedes; i++) {
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
                                System.out.println(e.getMessage());
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
                            } catch (ValorIncorretoException e) {
                                System.out.println(e.getMessage());
                            } catch (InputMismatchException e) {
                                System.out.println(Mensagem.erroNumerico());
                            }
                        } while (true);
                    }
                    // Instanciando um hóspede
                    Hospede h = new Hospede(codigo, nome, endereco, idade);
                    listaDeHospedes.add(h);
                }

                // 2 - Alterar suite
                case 2 -> {

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

package mapa.dialogs;

import java.util.Scanner;

public abstract class Mensagem {

    public static void mostrarMenu() {
        System.out.println("Sistema de reservas");
        System.out.println("[1] Reservar suite");
        System.out.println("[2] Listar reservas");
        System.out.println("[3] Localizar suite");
        System.out.println("[4] Localizar hóspede");
        System.out.println("[5] Liberar suite");
        System.out.println("[0] Sair");
        System.out.print(">_ ");
    }

    public static void cadastrarHospedes() {
        System.out.println("\n-------------------------");
        System.out.println(" Cadastrado dos hóspedes ");
        System.out.println("-------------------------");
    }

    public static void cadastrarSuite() {
        System.out.println("\n-------------------------");
        System.out.println("     Cadastrado da suite   ");
        System.out.println("-------------------------");
    }

    public static void mostrarReservas() {
        System.out.println("\n-------------------------");
        System.out.println("     Suites reservadas   ");
        System.out.println("-------------------------");
    }

    public static void mostrarSuite() {
        System.out.println("\n-------------------------");
        System.out.println("     Localizar suite     ");
        System.out.println("-------------------------");
    }

    public static double inserirReal(String descricao) {
        System.out.print(descricao);
        return new Scanner(System.in).nextDouble();
    }

    public static int inserirInteiro(String descricao) {
        System.out.print(descricao);
        return new Scanner(System.in).nextInt();
    }

    public static String inserirTexto(String descricao) {
        System.out.print(descricao);
        return new Scanner(System.in).nextLine();
    }

    public static String erroNumerico() {
        return "\n ** Erro! Valor não compatível **\n";
    }

    public static String erroValorVazio() {
        return "\n ** Erro! Este valor não pode ser vazio **\n";
    }

    public static String erroSuiteOcupada() {
        return "\n ** Erro! Suite já ocupada **\n";
    }

    public static String erroNaoEncontrada() {
        return "\n ** Erro! Não foram encontradas reservas **\n";
    }

    public static String erroCapacidade() {
        return "\n ** Erro! Total de hóspedes maior que a capaciade da suite **\n";
    }

    public static String erroReserva() {
        return "\n ** Erro! Reserva não efetuada **\n";
    }

    public static void sucessoReserva() {
        System.out.println("\n\n ** Reserva efetuada com sucesso ! **");
    }
}

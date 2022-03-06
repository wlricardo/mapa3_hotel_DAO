package mapa.application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import mapa.dialogs.Mensagem;
import mapa.exceptions.ValorIncorretoException;

public class MAPA3_Hotel {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int opcao = -1;

        do {
            do {
                try {
                    Mensagem.mostrarMenu();
                    opcao = receberInteiro("");
                    if (opcao < 0 || opcao > 6) {
                        throw new ValorIncorretoException("\n ** Informe valores entre [0-6] **\n");
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("\n ** Informe apenas valores numéricos **\n");
                } catch (ValorIncorretoException e) {
                    System.out.println();
                }
            } while (true);

            try {
                switch (opcao) {

                    // 1 - RESERVAR SUITE
                    case 1 -> {

                    }
                    case 2 -> {
                    }
                    case 3 -> {
                    }
                    case 4 -> {
                    }
                    case 5 -> {
                    }
                    case 0 -> {
                    }
                    default -> {
                        System.out.println("\n ** Opção inválida **\n");
                    }

                }
                // CADASTRAR
                // ALTERAR
                // LISTAR
                // LOCALIZAR POR NOME
                // EXCLUIR

            } catch (Exception e) {

                //coletarTexto("----Tecle ENTER para continuar----");
            }

        } while (opcao != 0);

    }

    private static int receberInteiro(String msg) {
        int valor = new Scanner(System.in).nextInt();
        if (valor <= 0) {
            throw new ValorIncorretoException("\n ** Forneça valores inteiros maiores que zero **\n");
        }
        return valor;
    }

    private static double inserirReal(String descricao) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(descricao);
        return scanner.nextDouble();
    }

    private static String inserirTexto(String descricao) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(descricao);
        return scanner.nextLine();
    }
}

package mapa.dialogs;

import java.util.Scanner;
import mapa.exceptions.ValorIncorretoException;

public abstract class Mensagem {

    public static void mostrarMenu() {
        System.out.println("Sistema de reservas");
        System.out.println("1 - Reservar suite");
        System.out.println("2 - Alterar suite");
        System.out.println("3 - Listar reservas");
        System.out.println("4 - Localizar suite");
        System.out.println("5 - Localizar hóspede");
        System.out.println("6 - Liberar suite");
        System.out.println("0 - Sair");
        System.out.print(">_ ");
    }
    
}

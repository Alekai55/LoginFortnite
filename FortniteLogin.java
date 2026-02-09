package Folnai;

import java.util.Scanner;
import java.util.ArrayList;

public class FortniteLogin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        listaJugadores.add(new Jugador("Ninja", "llama123"));
        listaJugadores.add(new Jugador("Lolito", "mamon123"));

        boolean continuar = true;

        System.out.println("===== BIENVENIDO A FORTNITE =====");

        while (continuar) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Iniciar Sesión");
            System.out.println("2. Registrar Usuario");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.println("\n---- INICIO DE SESIÓN ----");
                    System.out.print("Introduce tu Gamertag: ");
                    String nombreUser = sc.nextLine();
                    System.out.print("Introduce tu Contraseña: ");
                    String passUser = sc.nextLine();

                    boolean encontrado = false;

                    for (Jugador j : listaJugadores) {
                        if (j.gamertag.equalsIgnoreCase(nombreUser)) {
                            encontrado = true;
                            if (j.iniciarSesion(passUser)) {
                                System.out.println("¡Bienvenido de nuevo, " + j.gamertag + "!");
                            } else {
                                System.out.println("Contraseña incorrecta para " + j.gamertag);
                            }
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Error: El jugador '" + nombreUser + "' no está registrado.");
                    }
                    break;

                case 2:
                    System.out.println("\n===== REGISTRO DE NUEVO JUGADOR =====");
                    System.out.print("Elige tu gamertag: ");
                    String nuevoGametag = sc.nextLine();
                    System.out.print("Escribe tu contraseña: ");
                    String nuevoPassword = sc.nextLine();

                    listaJugadores.add(new Jugador(nuevoGametag, nuevoPassword));
                    System.out.println("Registro completado con éxito.");
                    System.out.println("Total de jugadores en la base de datos: " + Jugador.getJugadoresConectados());
                    break;

                case 3:
                    System.out.println("Cerrando el juego...");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
                    break;
            }
        }
        sc.close();
    }
}
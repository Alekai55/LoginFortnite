package Folnai;

import java.util.Scanner;

    public class FortniteLogin{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            Jugador j1 = new Jugador("Ninja", "llama123");
            Jugador j2 = new Jugador("Lolito", "mamon123");

            System.out.println("Actualmente hay " + Jugador.getJugadoresConectados() + " jugadores conectados");

            System.out.println("\n----INICIO DE SESIÓN----");
            System.out.println("Introduce tu Gamertag: ");
            String nombreUser = sc.nextLine();
            System.out.println("Introduce tu Contraseña: ");
            String passUser = sc.nextLine();

            boolean encontrado = false;

            if (nombreUser.equalsIgnoreCase(j1.gamertag)){
                encontrado = true;
                if (j1.iniciarSesion(passUser)){
                    System.out.println("Bienvenido de nuevo " + j1.gamertag + " !");
                } else{
                    System.out.println("Contraseña incorrecta " +  j1.gamertag + " ,pruebe de nuevo");
                }
            }
            else if (nombreUser.equalsIgnoreCase(j2.gamertag)){
                encontrado = true;
                if (j2.iniciarSesion(passUser)){
                    System.out.println("Bienvenido de nuevo " + j2.gamertag + " !");
                } else{
                    System.out.println("Contraseña incorrecta " + j2.gamertag + " ,pruebe de nuevo");
                }
            }
            if (!encontrado){
                System.out.println("Error: el jugador " + nombreUser + " no existe." );
            }
        }
    }


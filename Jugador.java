package Folnai;

public class Jugador {

    public String gamertag;
    private String contrasena;
    public static int jugadoresConectados = 0;

    public Jugador(String gamertag, String contrasena) {
        this.gamertag = gamertag;
        this.contrasena = contrasena;
        Folnai.Jugador.jugadoresConectados++;
    }

    public static int getJugadoresConectados() {

        return jugadoresConectados;
    }

    public boolean iniciarSesion(String passIntroducida) {
        return this.contrasena.equals(passIntroducida);
    }
}


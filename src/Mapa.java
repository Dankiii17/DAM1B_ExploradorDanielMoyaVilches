import java.util.Scanner;

public class Mapa {
    private char[][] tablero;
    private Posicion posTesoro;
    private Posicion posJugador;
    private Enemigo[] enemigos;
    private Posicion[] posTrampas;

    public Mapa(){
        this.tablero = new char[6][20];
        this.enemigos= new Enemigo[]{new Enemigo(), new Enemigo(), new Enemigo()};
        this.posTrampas= new Posicion[3];
        this.posTesoro=new Posicion((int)(Math.random()*7+0),(int)(Math.random()*21+0));



    }
    public void inicializarTablero() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 20; j++) {
                tablero[i][j] = ' ';
            }

        }
        colocarEnemigos();
        colocarTesoro();
        colocarTrampas();
        colocarJugador();
    }
    private void colocarJugador(){
        int fila;
        int columna;
        do {
            fila = (int) (Math.random()*6);
            columna =0;
        } while (tablero[fila][columna]!=' ');
        posJugador = new Posicion(fila,columna);
        tablero[fila][columna] = 'J';
    }
    private void colocarTrampas(){
        for (int i = 0; i < posTrampas.length; i++) {
            int fila, columna;
            do {
                fila = (int) (Math.random()*6);
                columna = (int) (Math.random()*20);
            } while (tablero[fila][columna]!= ' ');
            posTrampas[i] = new Posicion(fila,columna);
            tablero[posTrampas[i].getCoordenadaFila()][posTrampas[i].getCoordenadaCol()] = 'T';
        }
    }
    private void colocarEnemigos() {
        for (int i = 0; i < enemigos.length; i++) {
            int fila, columna;
            do {
                fila = (int) (Math.random()*6);
                columna = (int) (Math.random()*20);
            } while (tablero[fila][columna] != ' ');
            enemigos[i] = new Enemigo();
            tablero[fila][columna] = 'E';
        }
    }

    public Enemigo[] getEnemigos() {
        return enemigos;
    }

    private void colocarTesoro(){
         int tesoro=tablero[(int) (Math.random()*6)][(int) (Math.random()*20)] = ' ';
    }
    public void mostrar(){
        inicializarTablero();
        System.out.println("----------------------------------------------------------------------------------");
        for (int fila = 0; fila < tablero.length; fila++){
            for (int col = 0; col < tablero[fila].length; col++){
                System.out.print(" | ");
                System.out.print(tablero[fila][col]);

            }
            System.out.print(" | ");
            System.out.println();
            System.out.print("----------------------------------------------------------------------------------");
            System.out.println();

        }

    }
    public void Ronda(){
        boolean partida=true;
        System.out.println("Bienvenido al juego del explorador!");
        System.out.println("****************************************************************");
        System.out.println("Introduzca su nombre:");
        Scanner scanner = new Scanner(System.in);
        String nombreJugador = scanner.nextLine();
        Explorador explorador = new Explorador(nombreJugador);
        while (partida){
            mostrar();
            if(posJugador.getCoordenadaCol()==enemigos[0].getPosicionActual().getCoordenadaCol() && posJugador.getCoordenadaFila()==enemigos[1].getPosicionActual().getCoordenadaFila()
                    ||posJugador.getCoordenadaCol()==enemigos[1].getPosicionActual().getCoordenadaCol() && posJugador.getCoordenadaFila()==enemigos[2].getPosicionActual().getCoordenadaFila()||
                    posJugador.getCoordenadaCol()==enemigos[2].getPosicionActual().getCoordenadaCol() && posJugador.getCoordenadaFila()==enemigos[3].getPosicionActual().getCoordenadaFila()){
                System.out.println("Has sido eliminado por un enemigo!");
                partida=false;
                return;
            }else if (posJugador.getCoordenadaCol()==posTrampas[0].getCoordenadaCol() && posJugador.getCoordenadaFila()==posTrampas[0].getCoordenadaFila()
                    ||posJugador.getCoordenadaCol()==posTrampas[1].getCoordenadaCol() && posJugador.getCoordenadaFila()==posTrampas[1].getCoordenadaFila()||
                    posJugador.getCoordenadaCol()==posTrampas[2].getCoordenadaCol() && posJugador.getCoordenadaFila()==posTrampas[2].getCoordenadaFila()){
                System.out.println("Has pisado una trampa!");
                partida=false;
                return;
            }
            System.out.println("¿Hacia donde quieres moverte?");
            System.out.println("W=arriba, S=Abajo, A=Izquierda, D=Derecha");
            String movimiento="";
           boolean direccionvalida=false;
           while(!direccionvalida){
               movimiento=scanner.next().toUpperCase();
               if(movimiento.equals("W") || movimiento.equals("S") || movimiento.equals("A") || movimiento.equals("D")){
                   direccionvalida=true;
               }else{
                   System.out.println("Introduce una dirección válida (W, S, A, D)");
               }
           }
            int filaActual = explorador.getPosicionactual().getCoordenadaFila();
            int colActual = explorador.getPosicionactual().getCoordenadaCol();
            if (movimiento.equals("W") && filaActual > 0) {
                explorador.moverse(Explorador.ARRIBA);
            } else if (movimiento.equals("S") && filaActual < tablero.length - 1) {
                explorador.moverse(Explorador.ABAJO);
            } else if (movimiento.equals("A") && colActual > 0) {
                explorador.moverse(Explorador.IZQUIERDA);
            } else if (movimiento.equals("D") && colActual < tablero[0].length - 1) {
                explorador.moverse(Explorador.DERECHA);
            } else {
                System.out.println("Movimiento inválido");
                continue;
            }
            int nuevaFila = explorador.getPosicionactual().getCoordenadaFila();
            int nuevaCol = explorador.getPosicionactual().getCoordenadaCol();
            if (nuevaFila < tablero.length && nuevaCol < tablero[0].length) {
                tablero[filaActual][colActual] = ' ';
                tablero[nuevaFila][nuevaCol] = 'J';
            }
            for (int i = 0; i < enemigos.length; i++) {
                Posicion posEnemigo = enemigos[i].getPosicionActual();
                if (posEnemigo.getCoordenadaFila() < tablero.length && posEnemigo.getCoordenadaCol() < tablero[0].length) {
                    tablero[posEnemigo.getCoordenadaFila()][posEnemigo.getCoordenadaCol()] = ' ';
                    enemigos[i].moverse();
                    posEnemigo = enemigos[i].getPosicionActual();
                    if (posEnemigo.getCoordenadaFila() < tablero.length && posEnemigo.getCoordenadaCol() < tablero[0].length) {
                        tablero[posEnemigo.getCoordenadaFila()][posEnemigo.getCoordenadaCol()] = 'E';
                    }
                }
            }


        }
        System.out.println("Has encontrado el tesoro!");
    }


}

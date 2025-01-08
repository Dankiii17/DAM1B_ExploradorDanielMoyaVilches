public class Explorador {
    private String nombre;
    private  Posicion posicionactual;
    static final int ARRIBA=1;
     static final int ABAJO=2;
     static final int DERECHA=3;
     static final int IZQUIERDA=4;

    public Explorador(String nombre){
        this.nombre=nombre;
        int fila= (int) (Math.random()*7);
        this.posicionactual=new Posicion(fila,0);
    }

    public String getNombre() {
        return nombre;
    }

    public Posicion getPosicionactual() {
        return posicionactual;
    }

    public void setPosicionactual(Posicion posicionactual) {
        this.posicionactual = posicionactual;
    }
    public void moverse(int direccion) {
        int filaActual = posicionactual.getCoordenadaFila();
        int colActual = posicionactual.getCoordenadaCol();
        if (direccion == ARRIBA && filaActual > 0) {
            posicionactual.setCoordenadaFila(filaActual - 1);
        } else if (direccion == ABAJO && filaActual < 5) {
            posicionactual.setCoordenadaFila(filaActual + 1);
        } else if (direccion == DERECHA && colActual < 19) {
            posicionactual.setCoordenadaCol(colActual + 1);
        } else if (direccion == IZQUIERDA && colActual > 0) {
            posicionactual.setCoordenadaCol(colActual - 1);
        } else {
            System.out.println("Movimiento inválido"); } }
}

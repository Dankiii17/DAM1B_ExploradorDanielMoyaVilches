public class Explorador {
    private String nombre;
    private Posicion posicionactual;
    private final int ARRIBA=1;
    private final int ABAJO=2;
    private final int DERECHA=3;
    private final int IZQUIERDA=4;

    public Explorador(String nombre){
        this.nombre=nombre;
        int fila= (int) (Math.random()*7+1);
        this.posicionactual=new Posicion(fila,1);
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
    public void moverse(int direccion){
        if (direccion==ARRIBA){
            posicionactual.setCoordenadaFila(posicionactual.getCoordenadaFila()-1);
        } else if (direccion == ABAJO) {
            posicionactual.setCoordenadaFila(posicionactual.getCoordenadaFila()+1);
        }else if (direccion == DERECHA) {
            posicionactual.setCoordenadaCol(posicionactual.getCoordenadaCol()+1);
        } else if (direccion == IZQUIERDA) {
            posicionactual.setCoordenadaCol(posicionactual.getCoordenadaCol()-1);
        }
    }
}

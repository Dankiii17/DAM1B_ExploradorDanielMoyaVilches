public class Explorador {
    private String nombre;
    private static Posicion posicionactual;
    private static final int ARRIBA=1;
    private static final int ABAJO=2;
    private static final int DERECHA=3;
    private static final int IZQUIERDA=4;

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
    public static void moverse(int direccion){
        if (direccion==ARRIBA){
            if (posicionactual.getCoordenadaFila()!=0){
            posicionactual.setCoordenadaFila(posicionactual.getCoordenadaFila()-1);}
            else {System.out.println("No puedes moverse hacia arriba.");}
        } else if (direccion == ABAJO) {
            if (posicionactual.getCoordenadaFila()!=5){
            posicionactual.setCoordenadaFila(posicionactual.getCoordenadaFila()+1);}
            else {System.out.println("No puedes moverse hacia abajo.");}
        }else if (direccion == DERECHA) {
            if (posicionactual.getCoordenadaCol()!=0){
            posicionactual.setCoordenadaCol(posicionactual.getCoordenadaCol()+1);}
            else {System.out.println("No puedes moverse hacia la derecha.");}
        } else if (direccion == IZQUIERDA) {
            if (posicionactual.getCoordenadaCol()!=19){
            posicionactual.setCoordenadaCol(posicionactual.getCoordenadaCol()-1);}
            else {System.out.println("No puedes moverse hacia la izquierda.");}
        }
    }
}

public class Enemigo {
    private Posicion posicionactual;

    public Enemigo(){
        this.posicionactual=new Posicion((int) (Math.random()*7+1),(int) (Math.random()*21+1));
    }
    public Posicion getPosicionActual(){
        return this.posicionactual;
    }
    public void setPosicionActual(Posicion posicionactual){
        this.posicionactual=posicionactual;
    }
    public void moverse(){
             int direccion=(int) (Math.random()*5+1);
             if(direccion==1){
                 if (this.posicionactual.getCoordenadaFila()!=0){
                 this.posicionactual.setCoordenadaFila(this.posicionactual.getCoordenadaFila()-1);}
             }else if(direccion==2){
                 if (this.posicionactual.getCoordenadaFila()!=5){
                 this.posicionactual.setCoordenadaFila(this.posicionactual.getCoordenadaFila()+1);}
             } else if (direccion==3) {
                 if (this.posicionactual.getCoordenadaCol()!=0){
                 this.posicionactual.setCoordenadaCol(this.posicionactual.getCoordenadaCol()+1);}
             }else if (direccion==4){
                 if (this.posicionactual.getCoordenadaCol()!=19){
                 this.posicionactual.setCoordenadaCol(this.posicionactual.getCoordenadaCol()-1);}
             }
    }
}
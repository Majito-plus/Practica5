public class Automovil extends Entrega{
    private static final double TARIFA = 5.0;
    private static final double COSTO_POR_KM= 1.0;
    public Automovil(String destino,double distancia){
        super(destino , distancia);
    }
    @Override 
    public String getModalidades(){
        return "AUTOMOVIL";
    }
    public double calcularCosto(){
        return TARIFA + COSTO_POR_KM* getDistancia(); 
    }
    
}

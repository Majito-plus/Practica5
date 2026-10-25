public class Bicicletas extends Entrega {
    private static final double TARIFA = 2.0;
    private static final double COSTO_POR_KM= 0.5;
     public Bicicletas(String destino, double distancia) {
        super(destino, distancia);
     }
     @Override 
     public String getModalidades(){
        return "BICICLETA";
     }
     @Override 
    public double calcularCosto() {
        return TARIFA+COSTO_POR_KM*getDistancia();
     }

}
public class Entrega{
 private static final double RECARGA_POR_KILOMETRO_EXTRA = 1.0;
 private  String destino ;
 private double distancia ;
 public Entrega(String destino, double distancia) {
       if (destino == null || destino.isBlank()) {
            throw new IllegalArgumentException("El destino no puede estar vacío");
        }
        if (Double.isNaN(distancia) || Double.isInfinite(distancia) || distancia <= 0) {
        }
     this.destino=destino;
     this.distancia = distancia;
 }
 public String getDestino() {
     return destino;
 }
 public double getDistancia() {
     return distancia;
 }
 public String getModalidades(){
    return "ESTANDAR";
 }
 // ESTE ES UN CORTO GENERICO QUE SE UTILIZA 
 public double calcularCosto() {
     return 10.0;
 }
// ESTE SERA CON LA RECARGA EXTRA
 public double calcularCosto(double distanciaExtra) {
     if (Double.isNaN(distanciaExtra) || Double.isInfinite(distanciaExtra)||distanciaExtra<=0) {
         throw new IllegalArgumentException("La distancia extra no puede ser NaN o infinita");
     }
     return calcularCosto() + (distanciaExtra * RECARGA_POR_KILOMETRO_EXTRA);
 }
}

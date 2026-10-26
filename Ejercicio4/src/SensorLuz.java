public class SensorLuz extends Sensor implements Calibrable {
    private double ajuste ;
    public SensorLuz(String identificador , String ubicacion) {
    super(identificador, ubicacion);
    this.ajuste = (0.0);
 }
    @Override 
    public double leer(){
        return 40.0+ ajuste ;
    }
    @Override 
    public void calibrar(double ajuste ){
         this.ajuste= ajuste ;
    }
}


public class SensorTemperatura extends Sensor implements Calibrable {
    private double ajuste ;
    public SensorTemperatura(String identificador , String ubicacion) {
    super(identificador, ubicacion);
    this.ajuste = (0.0);
 }
    @Override 
    public double leer(){
        return 30.0+ ajuste ;
    }
    @Override 
    public void calibrar(double ajuste ){
         this.ajuste= ajuste ;
    }
}
 

public class SensorHumedad extends Sensor{
public SensorHumedad(String identificador , String ubicacion){
    super(identificador,ubicacion);
}
@Override 
public double leer(){
    return 25.0;
}

}
public abstract  class Sensor{
    private String identificador ;
    private String ubicacion;
    public Sensor (String identificador , String ubicacion ){
        this.identificador= identificador ;
        this.ubicacion= ubicacion;
    }
    public String getIdentificador(){
        return identificador ;

    }
    public String getUbicacion(){
        return ubicacion;
    }
    public abstract double leer();

    
}
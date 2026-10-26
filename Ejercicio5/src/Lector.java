public class Lector {
    private String nombre;
    private String id;
    public Lector (String nombre, String id){
        this.nombre=nombre;
        this.id=id;
    }
    public String getNombre(){
        return nombre;
    }
    public String getId(){
        return id;
    }
}

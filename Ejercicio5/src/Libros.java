public class Libros {
    private String titulo;
    private boolean disponible; 

public Libros (String titulo){
    this.titulo = titulo;
    this.disponible=true;
}
public String getTitulo(){
    return titulo;
}
public boolean getDisponible(){
    return disponible ;
}
public boolean marcarPrestado(){
 if (disponible){
 disponible=false ;
 return true;
 }else {
    return false;
 }
}public boolean marcarDisponible(){
if (!disponible){
 disponible=true;
 return true;
 }else {
    return false;
 }
}
}

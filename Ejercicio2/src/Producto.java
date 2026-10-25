public class Producto {

    private String nombre;
    private double precio;

     public Producto(String nombre, double precio) {
        // El precio debe ser un número positivo: se rechazan 0, negativos, NaN e infinito
        if (Double.isNaN(precio) || Double.isInfinite(precio) || precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que 0");
        }
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
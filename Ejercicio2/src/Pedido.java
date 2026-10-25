public class Pedido {
    private static final double UMBRAL_DESCUENTO = 30.0;
    private static final double PORCENTAJE_DESCUENTO = 0.10;
    // Arreglo de 3 casillas (todas empiezan vacías, en null)
    private Producto[] productos = new Producto[3];
    private int cantidad = 0;
    public boolean agregarProducto(Producto producto) {
        if (producto == null) {
            return false;               // no hay nada que agregar
        }
        if (cantidad == productos.length) {
            return false;               // el pedido ya está lleno (3 de 3)
        }
        productos[cantidad] = producto; // lo guardamos en la siguiente casilla libre
        cantidad = cantidad + 1;
        return true;
    }

    // Muestra una línea por cada producto
    public void mostrarLineas() {
        for (int i = 0; i < cantidad; i++) {
            System.out.println((i + 1) + ". " + productos[i].getNombre()
                    + " - Bs " + productos[i].getPrecio());
        }
    }

    // Subtotal: suma de los precios de los productos
    public double calcularSubtotal() {
        double suma = 0;
        for (int i = 0; i < cantidad; i++) {
            suma = suma + productos[i].getPrecio();
        }
        return suma;
    }

    // Total: por ahora es igual al subtotal (el reto le agrega el descuento)
     public double calcularDescuento() {
        double subtotal = calcularSubtotal();
        if (subtotal > UMBRAL_DESCUENTO) {
            return subtotal * PORCENTAJE_DESCUENTO;
        }
        return 0;
    }

    // Total: subtotal menos descuento
    public double calcularTotal() {
        return calcularSubtotal() - calcularDescuento();
    }
}

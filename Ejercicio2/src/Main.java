public class Main {
     public static void main(String[] args) {

        Producto cafe = new Producto("Cafe", 12.0);
        Producto sandwich = new Producto("Sandwich", 18.5);
        Producto jugo = new Producto("Jugo", 9.5);

        Pedido pedido = new Pedido();
        pedido.agregarProducto(cafe);
        pedido.agregarProducto(sandwich);
        pedido.agregarProducto(jugo);

        System.out.println("--- Pedido ---");
        pedido.mostrarLineas();
        System.out.println("Subtotal: " + pedido.calcularSubtotal());
                System.out.println("Descuento: " + pedido.calcularDescuento()); 
        System.out.println("Total: " + pedido.calcularTotal());

        // Caso límite 1: el pedido ya tiene 3 productos
        boolean cuarto = pedido.agregarProducto(new Producto("Torta", 15.0));
        System.out.println("Agregar un cuarto producto: " + cuarto);

        // Caso límite 2: precio inválido
        try {
            Producto malo = new Producto("Regalo", -5.0);
            System.out.println("Producto creado: " + malo.getNombre());
        } catch (IllegalArgumentException e) {
            System.out.println("Precio rechazado: " + e.getMessage());
        }
            // Reto: segundo pedido, por debajo del umbral
        Pedido pedido2 = new Pedido();
        pedido2.agregarProducto(cafe);
        pedido2.agregarProducto(jugo);
        System.out.println("--- Pedido 2 ---");
        pedido2.mostrarLineas();
        System.out.println("Subtotal: " + pedido2.calcularSubtotal());
        System.out.println("Descuento: " + pedido2.calcularDescuento());
        System.out.println("Total: " + pedido2.calcularTotal());
    
          // Reto: caso límite, subtotal exacto en el umbral
        Pedido pedido3 = new Pedido();
        pedido3.agregarProducto(cafe);
        pedido3.agregarProducto(new Producto("Empanada", 18.0));
        System.out.println("--- Pedido 3 ---");
        pedido3.mostrarLineas();
        System.out.println("Subtotal: " + pedido3.calcularSubtotal());
        System.out.println("Descuento: " + pedido3.calcularDescuento());
        System.out.println("Total: " + pedido3.calcularTotal());
}
}
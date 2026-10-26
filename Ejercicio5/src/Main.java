public class Main {
    public static void main(String[] args) {
        Libros libro = new Libros("Don Quijote");
        Lector lector = new Lector("Ana", "L-01");
        Prestamo prestamo = new Prestamo(libro, lector);

        System.out.println("=== 1. Prestamo valido (dia 0) ===");
        if (prestamo.registrarPrestamo(0)) {
            System.out.println("Prestamo registrado: " + libro.getTitulo()
                    + " -> " + lector.getNombre());
            System.out.println("Fecha limite de devolucion: dia " + prestamo.getFechaDevolucion());
        }

        System.out.println("\n=== 2. Intento repetido ===");
        if (prestamo.registrarPrestamo(1)) {
            System.out.println("Prestamo registrado");
        } else {
            System.out.println("Rechazado: el libro ya esta prestado");
        }

        System.out.println("\n=== 3. Reto: vencimiento ===");
        System.out.println("Dia 5 vencido? " + prestamo.estaVencido(5));
        System.out.println("Dia 7 vencido? " + prestamo.estaVencido(7));
        System.out.println("Dia 8 vencido? " + prestamo.estaVencido(8));

        System.out.println("\n=== 4. Devolucion ===");
        if (prestamo.registrarDevolucion()) {
            System.out.println("Libro devuelto. Disponible: " + libro.getDisponible());
        }
        System.out.println("Dia 20 vencido tras devolver? " + prestamo.estaVencido(20));
    }
}
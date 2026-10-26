public class Prestamo {
    private static final int PLAZO_DIAS = 7;   // regla: se presta por 7 dias

    private Libros libro;
    private Lector lector;
    private boolean activo;
    private int fechaDevolucion;               // dia simulado limite (ej. dia 7)

    public Prestamo(Libros libro, Lector lector) {
        if (libro == null) {
            throw new IllegalArgumentException("El libro no puede ser null");
        }
        if (lector == null) {
            throw new IllegalArgumentException("El lector no puede ser null");
        }
        this.libro = libro;
        this.lector = lector;
        this.activo = false;
        this.fechaDevolucion = 0;
    }

    // Prestamo "normal": se presta el dia 0
    public boolean registrarPrestamo() {
        return registrarPrestamo(0);
    }

    // Prestamo indicando en que dia simulado se presta
    public boolean registrarPrestamo(int diaPrestamo) {
        if (diaPrestamo < 0) {
            throw new IllegalArgumentException("El dia no puede ser negativo");
        }
        boolean sePresto = libro.marcarPrestado();
        if (sePresto) {
            activo = true;
            fechaDevolucion = diaPrestamo + PLAZO_DIAS;
        }
        return sePresto;
    }

    public boolean registrarDevolucion() {
        if (!activo) {
            return false;
        }
        libro.marcarDisponible();
        activo = false;
        return true;
    }

    // RETO: esta vencido si sigue activo y ya paso el dia limite
    public boolean estaVencido(int diaActual) {
        if (diaActual < 0) {
            throw new IllegalArgumentException("El dia no puede ser negativo");
        }
        return activo && diaActual > fechaDevolucion;
    }

    public boolean estaActivo() { return activo; }
    public int getFechaDevolucion() { return fechaDevolucion; }
    public Libros getLibro() { return libro; }
    public Lector getLector() { return lector; }
}



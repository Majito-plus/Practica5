## Descripción
Una biblioteca pequeña registra el préstamo de un libro a un lector. El libro
puede estar disponible o prestado, y no se puede prestar una segunda vez
mientras siga prestado. Se trabaja con un solo préstamo por ejecución, sin
listas ni bases de datos.

## Archivos
| Archivo | Qué hace |
|---|---|
| `Libros.java` | Guarda el título y si está disponible. Protege su propio estado con `marcarPrestado()` y `marcarDisponible()` |
| `Lector.java` | Guarda el nombre y el identificador del lector |
| `Prestamo.java` | Asocia un `Libros` con un `Lector`, registra el préstamo y la devolución, y calcula si está vencido |
| `Main.java` | Crea los objetos y muestra la secuencia del ejercicio |

## Cómo compilar y ejecutar
Los cuatro archivos deben estar en la misma carpeta.
```
javac *.java
java Main
```

## Diseño
```
Prestamo ──tiene──► Libros
Prestamo ──tiene──► Lector
```
`Libros` y `Lector` no se conocen entre sí. `Prestamo` es la clase que los
relaciona (asociación), y así cada clase tiene una sola responsabilidad:
- `Libros` cuida si está disponible o prestado.
- `Lector` guarda los datos de la persona.
- `Prestamo` coordina el préstamo y la devolución.

## Encapsulamiento
Los atributos `disponible` (en `Libros`) y `activo` (en `Prestamo`) son
`private`. `Main` no puede modificarlos directamente: solo puede llamar a
métodos que validan cada operación y devuelven `true` o `false` según si se
pudo realizar.

`activo` no se recibe en el constructor porque debe cambiar solo mediante
`registrarPrestamo()` y `registrarDevolucion()`. Así no se puede crear un
préstamo activo sobre un libro que sigue disponible.

## Salida del programa
```
=== 1. Prestamo valido (dia 0) ===
Prestamo registrado: Don Quijote -> Ana
Fecha limite de devolucion: dia 7

=== 2. Intento repetido ===
Rechazado: el libro ya esta prestado

=== 3. Reto: vencimiento ===
Dia 5 vencido? false
Dia 7 vencido? false
Dia 8 vencido? true

=== 4. Devolucion ===
Libro devuelto. Disponible: true
Dia 20 vencido tras devolver? false
```
La salida muestra el préstamo válido, el intento rechazado de prestar un libro
ya prestado y la devolución, como pide la consigna.

## Pruebas realizadas
| # | Prueba | Resultado esperado | Resultado |
|---|---|---|---|
| 1 | Libro nuevo | Disponible, y el préstamo no está activo | ✅ |
| 2 | Prestar un libro disponible | `true`, el libro queda no disponible y el préstamo activo | ✅ |
| 3 | Prestar un libro ya prestado | `false`, el estado no cambia | ✅ |
| 4 | Devolver un préstamo activo | `true`, el libro vuelve a estar disponible | ✅ |
| 5 | Devolver sin haber prestado | `false`, el libro sigue disponible | ✅ |
| 6 | Devolver dos veces seguidas | La segunda da `false` | ✅ |
| 7 | Volver a prestar después de devolver | `true` | ✅ |
| 8 | Dos préstamos sobre el mismo libro | El segundo se rechaza | ✅ |
| 9 | El préstamo rechazado intenta devolver el libro de otro | `false`, el libro sigue prestado | ✅ |
| 10 | `Prestamo` con libro o lector `null` | `IllegalArgumentException` | ✅ |
| 11 | `Lector` con nombre vacío o identificador `null` | `IllegalArgumentException` | ✅ |

## Reto opcional: fecha simulada y vencimiento
**Fechas simuladas:** uso números de día (día 0, día 1, día 2…) en vez de
fechas reales.

**Regla definida:**
- El préstamo dura **7 días** (`PLAZO_DIAS = 7`). Si se presta el día 0, la
  fecha límite de devolución es el día 7.
- Un préstamo está **vencido** si sigue activo y el día actual es **mayor** que
  la fecha límite. El día 7 todavía no está vencido, y el día 8 sí.
- Un préstamo ya devuelto nunca está vencido.

**Cómo se usa:**
- `registrarPrestamo(int diaPrestamo)` calcula la fecha límite.
- `registrarPrestamo()` (sin parámetro) presta el día 0. Es una **sobrecarga**
  del método anterior.
- `estaVencido(int diaActual)` aplica la regla.

**Pruebas del reto:**
| # | Prueba | Resultado esperado | Resultado |
|---|---|---|---|
| 12 | Prestar el día 0 | Fecha límite: día 7 | ✅ |
| 13 | Consultar el día 7 y el día 8 | No vencido y vencido | ✅ |
| 14 | Prestar el día 10 | Fecha límite: día 17 | ✅ |
| 15 | Consultar un préstamo ya devuelto | No vencido | ✅ |
| 16 | Consultar un préstamo que nunca se prestó | No vencido | ✅ |
| 17 | Día negativo al prestar o al consultar | `IllegalArgumentException` | ✅ |
| 18 | Día negativo rechazado al prestar | El libro sigue disponible | ✅ |

**Categoría creativa propuesta: Medium.** Agregué una fecha límite simulada, una
regla de vencimiento y la sobrecarga de `registrarPrestamo`, combinando
constantes, validaciones y sobrecarga. Lo comprobé con las pruebas 12 a 18.

## Decisiones de diseño
- El libro valida su propio estado, así que nadie puede dejarlo "prestado dos
  veces". `Prestamo` solo le pide la acción y revisa la respuesta.
- `registrarDevolucion()` primero revisa que el préstamo esté activo. Así un
  préstamo que nunca prestó el libro no puede devolver el de otro.
- Los métodos devuelven `boolean` para que `Main` pueda mostrar el resultado sin
  tocar los atributos.

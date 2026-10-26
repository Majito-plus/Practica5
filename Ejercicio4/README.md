## Descripción
Un invernadero usa sensores que comparten identificador y ubicación. Todos
entregan una lectura, pero solo algunos se pueden calibrar. Los valores son
simulados, sin conectar hardware real.

## Archivos
| Archivo | Qué hace |
|---|---|
| `Sensor.java` | Clase **abstracta**. Guarda identificador y ubicación, tiene los getters y declara `leer()` abstracto |
| `Calibrable.java` | **Interfaz** con el método `calibrar(double ajuste)` |
| `SensorTemperatura.java` | Extiende `Sensor` e implementa `Calibrable`. Lee 30.0 + ajuste |
| `SensorHumedad.java` | Extiende `Sensor`. No es calibrable. Lee 65.0 |
| `SensorLuz.java` | Extiende `Sensor`. No es calibrable. Lee 800.0 (reto) |
| `Main.java` | Crea los sensores, los guarda en un `Sensor[]`, los lee y calibra |


## Elección: clase abstracta o interfaz
Usé una **clase abstracta** (`Sensor`) para lo que todos los sensores
comparten: el identificador, la ubicación, los getters y el método `leer()`,
que cada sensor implementa a su manera. Usé una **interfaz** (`Calibrable`)
para la capacidad de calibrarse, porque solo algunos sensores la tienen. Si
`calibrar()` estuviera en `Sensor`, `SensorHumedad` y `SensorLuz` tendrían que
cargar con un método que no necesitan. Además, una clase solo puede heredar de
otra clase, pero puede implementar varias interfaces, así que la interfaz
permite añadir la capacidad sin cambiar la jerarquía.

## Cómo se calibra desde un `Sensor[]`
El arreglo es de tipo `Sensor`, y `Sensor` no tiene `calibrar()`. Por eso, en
`Main` uso `instanceof Calibrable` para preguntar si el sensor cumple la
interfaz y un cast a `Calibrable` para poder llamar a `calibrar()`. Los
sensores que no son calibrables entran por el `else`.

## Salida del programa
```
---Antes de calibrar
t-5323-Zona B1-65.0
p-789-Zona C-30.0
z-456-zona B-800.0
=== APLICANDO CALIBRACIÓN ===
t-5323 no se calibró
p-789 calibrado con 2.0
z-456 no se calibró

=== LECTURAS DESPUÉS DE CALIBRAR ===
ID: t-5323 | Lectura actual: 65.0
ID: p-789 | Lectura actual: 32.0
ID: z-456 | Lectura actual: 800.0
```
Solo la temperatura cambia (30.0 pasa a 32.0). La humedad y la luz no se
calibran y mantienen su lectura.

## Pruebas realizadas
| # | Prueba | Esperado | Resultado |
|---|---|---|---|
| 1 | Lectura de temperatura sin calibrar | 30.0 | ✅ |
| 2 | Lectura de humedad | 65.0 | ✅ |
| 3 | Lectura de luz | 800.0 | ✅ |
| 4 | Calibrar la temperatura con +2.0 | 32.0 | ✅ |
| 5 | Calibrar dos veces seguidas | Reemplaza el ajuste, no lo suma | ✅ |
| 6 | Solo la temperatura es `Calibrable` | `instanceof` verdadero solo en ella | ✅ |
| 7 | Humedad y luz no se modifican al calibrar | Mantienen 65.0 y 800.0 | ✅ |
| 8 | Intentar `new Sensor(...)` | Error de compilación: clase abstracta | ✅ |
| 9 | Cast de `SensorHumedad` a `Calibrable` sin `instanceof` | `ClassCastException` (por eso se comprueba antes) | ✅ |

## Reto opcional: tercer sensor
Agregué `SensorLuz` sin modificar los ciclos que recorren y presentan los
sensores. Solo creé la clase nueva y añadí una línea en el arreglo.

## Decisiones de diseño
- `calibrar()` reemplaza el ajuste anterior y no lo acumula.
- Los valores de lectura son fijos y simulados, para que las pruebas siempre

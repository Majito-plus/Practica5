## Descripción
Clase base `Entrega` y dos subclases (`Bicicleta`, `EAutomovil`). Cada
subclase sobrescribe `calcularCosto()` con `@Override`. Un arreglo `Entrega[]` guarda
ambas modalidades y se recorre con un ciclo, sin preguntar el tipo con `if`.
## Datos de prueba (ficticios)
Bicicleta a Calle 123  (10km), 
Automóvil a Avenida 456 (20 km)
Bicicleta a Boulevard 789 (30 km)
 Las tarifas también son inventadas:

- Bicicleta: 2.0 de cargo fijo + 0.5 por km.
- Automóvil: 5.0 de cargo fijo + 1 por km.
- Recargo por km extra (sobrecarga): 1 por km.

## Salida del programa

```
--- Costo de cada entrega ---
Bicicleta a Centro (3.0 km): Bs 7.0
Automovil a Aeropuerto (12.0 km): Bs 38.0
--- Con 2.0 km extra de recargo (sobrecarga) ---
Bicicleta a Centro: Bs 10.0
Automovil a Aeropuerto: Bs 41.0
--- Casos limite ---
Bicicleta con 0.0 km extra: Bs 7.0
Distancia rechazada: La distancia debe ser mayor que 0
Recargo rechazado: Los km extra no pueden ser negativos
--- Reto: tipo estatico y dinamico ---
Automovil a Parque: Bs 20.5
```

## Decisiones de diseño
- `calcularCosto()` se sobrescribe en cada subclase con `@Override`. El costo es un
  cargo fijo (se suma una vez) más un cargo por km (se multiplica por la distancia).
- **Sobrecarga:** `calcularCosto(double kmExtra)` tiene el mismo nombre pero un
  parámetro más (cambia el número de parámetros) y suma un recargo por cada km extra.
- El ciclo no usa `if`: cada objeto ejecuta su propia versión del método.
- `Entrega` valida la distancia en el constructor y lanza una excepción si no es
  mayor que 0.

## Explicación
- Los métodos que puedo llamar los determina el **tipo estático**, es decir, el tipo
  con el que se declara la variable (`Entrega`): solo puedo llamar a lo que existe
  en esa clase.
- La implementación sobrescrita que se ejecuta la determina el **tipo dinámico**, es
  decir, el objeto real creado con `new`: en tiempo de ejecución Java elige la
  versión de `EntregaBicicleta` o de `EntregaAutomovil`.

## Reto: tipo estático y tipo dinámico

```
Entrega e = new EntregaAutomovil("Parque", 5.0);

 variable e (tipo estático: Entrega)  ---->  objeto (tipo dinámico: EntregaAutomovil)
```

- **Tipo estático:** el tipo con el que se declara la variable. Lo decide el
  compilador y limita qué métodos puedo llamar.
- **Tipo dinámico:** el tipo del objeto real creado con `new`. Se decide al ejecutar
  y determina qué versión sobrescrita se ejecuta.

`e.calcularCosto()` devuelve 20.5, la versión del automóvil, aunque `e` esté declarada
como `Entrega`.

## Extensión creativa
- **Categoría propuesta:** Easy
- **Qué agregué:** validación de la distancia y de los km extra, y casos límite en `Main`.
- **Cómo comprobé que funciona:** con la salida de arriba, que incluye los casos límite.

## Descripción

Programa en Java que calcula el costo de entregas según su modalidad
(bicicleta o automóvil). Se usa **herencia**, **sobrescritura** (`@Override`),
**sobrecarga** y **polimorfismo**.

## Estructura del proyecto

| Archivo | Qué hace |
|---|---|
| `Entrega.java` | Clase base. Guarda destino y distancia, valida los datos y tiene `calcularCosto()` y la sobrecarga `calcularCosto(double distanciaExtra)` |
| `Bicicletas.java` | Subclase. Sobrescribe `calcularCosto()`: tarifa 2.0 + 0.5 por km |
| `Automovil.java` | Subclase. Sobrescribe `calcularCosto()`: tarifa 5.0 + 1.0 por km |
| `Main.java` | Guarda las entregas en un `Entrega[]`, las recorre con un `for` (sin `if`) e imprime los costos |

## Cómo compilar y ejecutar

Los cuatro archivos deben estar en la misma carpeta.

```
javac *.java
java Main
```

## Conceptos aplicados

- **Herencia:** `Bicicletas` y `Automovil` extienden `Entrega`.
- **Sobrescritura:** cada subclase cambia `calcularCosto()` usando `@Override`.
- **Sobrecarga:** `calcularCosto()` y `calcularCosto(double)` tienen el mismo
  nombre pero distinta cantidad de parámetros.
- **Polimorfismo:** un solo arreglo `Entrega[]` guarda bicicletas y automóviles,
  y el ciclo llama `calcularCosto()` sin preguntar el tipo.

## Resultado de la ejecución

```
--- Costo de cada entrega ---
BICICLETA a Calle 123 (10.0 km): 7.0
AUTOMOVIL a Avenida 456 (20.0 km): 25.0
BICICLETA a Boulevard 789 (30.0 km): 17.0
--- Costo con 3 km de recargo ---
BICICLETA a Calle 123: 10.0
AUTOMOVIL a Avenida 456: 28.0
BICICLETA a Boulevard 789: 20.0
--- Casos de error ---
Distancia rechazada: La distancia debe ser un numero  finito mayor a 0
Recargo rechazado: La distancia extra debe ser un numero  finito mayor o igual a 0
--- Reto: tipo estático y dinámico ---
AUTOMOVIL a Parque: 10.0
```

## Evidencia (dos frases)

1. El **tipo estático** (el tipo de la variable) determina qué métodos se pueden llamar.
2. El **tipo dinámico** (el objeto real) determina qué implementación sobrescrita se ejecuta.

## Reto: tipo estático vs tipo dinámico

```java
Entrega a = new Automovil("Parque", 5.0);
```

```
   VARIABLE                         OBJETO
┌──────────────┐               ┌─────────────────────┐
│ Entrega a ───┼─────────────► │ Automovil           │
└──────────────┘               │ destino = "Parque"  │
  tipo estático                │ distancia = 5.0     │
  (la etiqueta)                └─────────────────────┘
                                 tipo dinámico
                                 (el objeto real)
```

- **Tipo estático (`Entrega`):** lo que dice la declaración de la variable.
  El compilador lo usa para saber qué métodos están permitidos.
- **Tipo dinámico (`Automovil`):** el objeto que realmente se creó.
  Al ejecutar, Java usa la versión de `calcularCosto()` de ese objeto,
  por eso `a.calcularCosto()` da 10.0 (5.0 + 1.0 × 5 km).

## Validaciones

- El destino no puede ser `null` ni estar vacío.
- La distancia debe ser un numero  finito mayor a 0.
- La distancia extra debe ser un numero  finito mayor o igual a 0.
- Si algún dato es inválido se lanza `IllegalArgumentException`.


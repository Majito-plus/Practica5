# Ejercicio 1: Cuenta digital con reglas de negocio

## Descripción
Clase `CuentaDigital` que representa una cuenta con titular, identificador y saldo.
El saldo no se modifica directamente desde `Main`: solo cambia con los métodos
`depositar` y `retirar`, que validan sus propias reglas. Los métodos devuelven
`true` si la operación se realizó y `false` si fue rechazada.

## Archivos
- `CuentaDigital.java`: la clase con los datos y las reglas de negocio.
- `Main.java`: programa que prueba operaciones válidas e inválidas.


## Cómo compilar y ejecutar
Desde la carpeta `ejercicio1`:

```bash
javac CuentaDigital.java Main.java
java Main
```

## Datos de prueba (ficticios)
- Cuenta 1: Juan Perez, identificador 123456789, saldo inicial 400.0
- Cuenta 2 (reto): Maria Lopez, identificador 987654321, saldo inicial 500.0

## Salida del programa

```
Su saldo es de 400.0
Deposito 50:true su saldo es de 450.0
Retiro 200:true su saldo es de 250.0
Deposito -100:false su saldo es de 250.0
Retiro 300:false su saldo es de 250.0
Reto
Saldo inicial de Maria: 500.0 | Limite diario: 500.0
Deposito 200:true su saldo es de 700.0
Retiro 300:true su saldo es de 400.0
Retiro 250:false su saldo es de 400.0
Nuevo dia, limite diario reiniciado
Retiro 250:true su saldo es de 150.0 | Limite diario: 500.0
```

## Tabla de pruebas

| # | Prueba --------------------| Saldo antes | Resultado | Saldo después |
|---|----------------------------|-------------|-----------|---------------|
| 1 | Depósito correcto (50)---- | 400 --------| `true`--- | 450 ----------|
| 2 | Retiro correcto (200)----- | 450 --------| `true`--- | 250 ----------|
| 3 | Monto no positivo (-100)-- | 250 --------| `false`-- | 250 ----------|
| 4 | Fondos insuficientes (300) | 250-------- | `false` --| 250 ----------|

En la prueba 4, el retiro de 300 supera el saldo de 250, pero no supera el límite
diario (200 + 300 = 500, que no es mayor que 500). Así la prueba comprueba una sola
regla: los fondos insuficientes.

## Decisiones de diseño
- Los atributos son `private`, por lo que `Main` no puede cambiarlos directamente.
- No existe un `setSaldo`: el saldo solo cambia con `depositar` y `retirar`,
  que rechazan montos no positivos y retiros mayores al saldo.
- `depositar` y `retirar` devuelven `boolean` para que `Main` sepa si la operación
  se realizó o fue rechazada.
- La clase no imprime nada: `Main` consulta el saldo con `getSaldo()` y lo muestra.
- En `retirar`, las validaciones van en este orden: monto válido, fondos
  suficientes y límite diario. Así cada rechazo corresponde a una sola causa.

## Reto opcional: límite diario de retiro
Se agregó un límite de retiro de 500 por día. El límite es un valor fijo: lo que
cambia durante el día es lo ya retirado, y se reinicia con el método `nuevoDia()`.

| # | Prueba---------------------------------| Resultado | Saldo después |
|---|----------------------------------------|-----------|---------------|
| 1 | Depósito de 200 -----------------------| `true` ---| 700 ----------|
| 2 | Retiro de 300 (dentro del límite) -----| `true` ---| 400 ----------|
| 3 | Retiro de 250 (300 + 250 = 550 > 500) -| `false`-- | 400 ----------|
| 4 | Después de `nuevoDia()`, retiro de 250 | `true` ---| 150-----------|

En la prueba 3 el saldo de 400 alcanzaba para retirar 250, así que el rechazo se
debe únicamente al límite diario.

## Extensión creativa
- **Categoría propuesta:** Easy
- **Qué agregué:** un límite diario de retiro de 500, un acumulador de lo retirado
  en el día y el método `nuevoDia()` para reiniciarlo.
- **Conceptos integrados:** constantes, atributos privados, condicionales y métodos.
- **Cómo comprobé que funciona:** con la tabla del reto. La prueba 3 se rechaza por
  el límite aunque el saldo alcanzaba, y la prueba 4 pasa después de reiniciar el día.

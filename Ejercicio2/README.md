# Ejercicio 2: Pedido de cafetería

## Descripción
`Producto` guarda nombre y precio. `Pedido` guarda hasta 3 productos en un arreglo,
muestra sus líneas y calcula subtotal, descuento y total. `Main` no suma precios:
delega el cálculo al `Pedido`.
```bash
javac Producto.java Pedido.java Main.java 
java Main
java Pruebas
```

## Salida de `java Main`

```
--- Pedido ---
1. Cafe - Bs 12.0
2. Sandwich - Bs 18.5
3. Jugo - Bs 9.5
Subtotal: 40.0
Descuento: 4.0
Total: 36.0
Agregar un cuarto producto: false
Precio rechazado: El precio debe ser mayor que 0
--- Pedido 2 ---
1. Cafe - Bs 12.0
2. Jugo - Bs 9.5
Subtotal: 21.5
Descuento: 0.0
Total: 21.5
```
## Decisiones de diseño
- **Relación entre `Pedido` y `Producto`: asociación (agregación).** El pedido "tiene"
  productos, pero estos se crean fuera, en `Main`, y existen sin el pedido. El mismo
  `Producto` puede estar en varios pedidos (por ejemplo, el café en el Pedido 1 y en
  el Pedido 2). Sería composición si `Pedido` creara sus propios productos y estos
  desaparecieran junto con él.
- El ciclo usa `i < cantidad` y no `productos.length`, porque las casillas sin usar
  valen `null`.
- `Producto` valida el precio en el constructor y lanza una excepción, así un
  producto inválido nunca llega a existir.

## Reto: descuento
**Regla:** si el subtotal **supera** el umbral de 30, se descuenta el 10% del subtotal.
Supera significa "mayor estricto" (`>`), así que con subtotal exactamente 30.0 no hay
descuento. El umbral y el porcentaje son constantes (`static final`) en `Pedido`.

| Subtotal | ¿Supera 30? --| Descuento | Total |
|----------|---------------|-----------|-------|
| 21.5   --| No -----------| 0.0 ------| 21.5 -|
| 30.0 ----| No (es igual) | 0.0 ------| 30.0 -|
| 40.0 ----| Sí -----------| 4.0 ------| 36.0 -|
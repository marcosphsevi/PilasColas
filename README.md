# PilasColas

Implementación propia en Java de las estructuras de datos **Pila** (LIFO) y **Cola** (FIFO), construidas desde cero con nodos enlazados y genéricos, y una serie de ejercicios interactivos por consola que las ponen en práctica.

No utiliza `Stack`, `Queue` ni `Deque` de la librería estándar: las dos estructuras están programadas a mano.

## Contenido

- [Ejercicios](#ejercicios)
- [Estructura del proyecto](#estructura-del-proyecto)
- [Estructuras de datos](#estructuras-de-datos)
- [Requisitos](#requisitos)
- [Compilación y ejecución](#compilación-y-ejecución)
- [Ejemplo de uso](#ejemplo-de-uso)

## Ejercicios

El programa (`Main`) ejecuta los cuatro ejercicios de forma secuencial, leyendo la entrada desde teclado:

1. **Invertir una cadena** (`Pila`): se lee una línea de texto, se apila carácter a carácter y se desapila para obtener la cadena al revés.
2. **Gestión de una cola de atención** (`Cola`): menú interactivo con las opciones:
   1. *Llegada*: añade una persona al final de la cola.
   2. *Atender*: atiende (y elimina) a la persona que está al frente.
   3. *Mostrar cola*: muestra las personas en espera sin alterar el orden.
   4. *Salir*: termina el ejercicio y pasa al siguiente.
3. **Comprobador de palíndromos** (`Pila` + `Cola`): se mete la palabra en una pila y en una cola a la vez; al vaciarlas, la cola devuelve la palabra original y la pila la invertida. Si coinciden, es palíndroma.
4. **Conversión de decimal a binario** (`Pila`): se divide sucesivamente entre 2 apilando los restos, y al desapilarlos se obtiene el número en binario.

Las entradas se validan: no se admiten líneas vacías y, donde se espera un número, se comprueba que sea un entero válido (clase `Depurar`).

## Estructura del proyecto

```
PilasColas/
├── src/
│   ├── Main.java      # Programa principal con los 4 ejercicios
│   ├── Pila.java      # Pila genérica (LIFO)
│   ├── Cola.java      # Cola genérica (FIFO)
│   ├── Nodo.java      # Nodo enlazado genérico
│   └── Depurar.java   # Utilidad de validación de enteros
├── pilasColas.iml     # Configuración de módulo de IntelliJ IDEA
└── README.md
```

## Estructuras de datos

Ambas estructuras son genéricas (`<T>`) y se apoyan en `Nodo<T>`, un nodo de lista enlazada simple con el dato y una referencia al siguiente nodo.

### `Pila<T>`

| Método | Descripción |
| --- | --- |
| `void push(T dato)` | Apila un elemento en la cima. |
| `T pop()` | Desapila y devuelve el elemento de la cima. Devuelve `null` si la cola está vacía. |
| `boolean isEmpty()` | Indica si la pila está vacía. |
| `int size()` | Devuelve el número de elementos. |

### `Cola<T>`

| Método | Descripción |
| --- | --- |
| `void enqueue(T dato)` | Encola un elemento al final. |
| `T dequeue()` | Desencola y devuelve el elemento del frente. Devuelve `null` si la cola está vacía. |
| `boolean isEmpty()` | Indica si la cola está vacía. |
| `int size()` | Devuelve el número de elementos. |

Todas las operaciones de inserción y extracción se ejecutan en tiempo constante, O(1).

### `Depurar`

| Método | Descripción |
| --- | --- |
| `static boolean depuracionEnteros(String numero)` | Devuelve `true` si la cadena se puede convertir a `int`. |

## Ejemplo de uso

```
Ejercicio 1:
Escribe una línea de texto
hola mundo
Cadena inversa: "odnum aloh"
Ejercicio 2:
Elije una opción:
1) Llegada
2) Atender
3) Mostrar cola
4) Salir
1
Introduce el Nombre de la persona que acaba de llegar a la cola:
Ana
...
Ejercicio 3
Escribe una palabra, para comprobar si es palíndroma o no.
reconocer
La palabra reconocer es palíndroma.
Ejercicio 4
Introduce un número entero para pasarlo a binario.
10
El número 10 en binario es 1010
```

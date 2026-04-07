# Práctica: Generador de horario de clase por consola

## Descripción de la práctica

Desarrolla una aplicación en Kotlin que permita introducir por teclado la información básica de un horario semanal de clase y que, una vez recogidos los datos, la muestre de forma ordenada, alineada y con formato de tabla en la consola.

El objetivo de la práctica es trabajar la entrada de datos por teclado y la salida formateada en consola, de manera que el programa no se limite a mostrar texto sin ordenar, sino que presente la información de forma clara, legible y estructurada, como si fuera un pequeño cuadro horario real.

La aplicación deberá pedir al usuario los datos de las asignaturas de una semana lectiva y, con esa información, construir una tabla con los días y las horas de clase.

---

## Qué se pretende evaluar

Con esta práctica se trabajarán especialmente los siguientes criterios de evaluación:

* CE a) Uso de la consola para realizar operaciones de entrada y salida de información.
* CE b) Aplicación de formatos en la visualización de la información.
* CE c) Reconocimiento y uso de las posibilidades de entrada/salida del lenguaje y librerías asociadas.

Dicho de forma más terrenal: aquí no basta con que “funcione”. Tiene que pedir bien los datos, mostrarlos bien y hacer un uso correcto de la entrada y salida en consola. Vamos, que el programa no parezca hecho a martillazos.

---

## Enunciado para el alumnado

### Objetivo

Realiza un programa en Kotlin que solicite por teclado un horario de clase de lunes a viernes, con 6 horas al día, y lo muestre al final en forma de tabla bien formateada.

---

## Funcionamiento general

El programa deberá:

* Pedir al usuario el nombre del grupo o curso.
* Pedir los nombres de los tramos horarios.
* Pedir las asignaturas correspondientes a cada día y a cada hora.
* Mostrar al final el horario completo en forma de tabla.

---

## Datos que debe leer el programa

### 1. Nombre del grupo

Por ejemplo:

* 1º DAW
* 1º ASIR
* 2º SMR

---

### 2. Tramos horarios

Se leerán los 6 periodos lectivos.

Por ejemplo:

* 08:15 - 09:15
* 09:15 - 10:15
* 10:15 - 11:15
* 11:45 - 12:45
* 12:45 - 13:45
* 13:45 - 14:45

---

### 3. Asignatura de cada franja

Para cada una de las 6 horas y para cada uno de los 5 días lectivos:

* Lunes
* Martes
* Miércoles
* Jueves
* Viernes

El programa deberá pedir qué asignatura corresponde a cada celda del horario.

Por ejemplo:

* Lunes, hora 1 → Programación
* Lunes, hora 2 → Bases de Datos
* ...
* Viernes, hora 6 → Entornos de Desarrollo

---

## Requisitos

### Requisitos obligatorios

El programa debe cumplir **todos** estos requisitos:

* La entrada de datos se realizará por consola.
* La salida final debe mostrarse en forma de tabla alineada.
* La tabla debe incluir:

    * una cabecera con los días,
    * una primera columna con el tramo horario,
    * y el contenido de cada asignatura en su posición correspondiente.
* Debe mostrarse un título identificando el horario y el grupo.
* La visualización debe ser clara y legible.
* Se deben controlar los espacios para que las columnas queden bien alineadas.
* Se deben utilizar funciones para separar responsabilidades en el programa.
* Los mensajes al usuario deben ser claros.
* El código debe estar bien organizado y ser fácil de leer.

---

## Ejemplo de datos que debería introducir el usuario

### Grupo

1º DAW

### Tramos horarios

08:15 - 09:15
09:15 - 10:15
10:15 - 11:15
11:45 - 12:45
12:45 - 13:45
13:45 - 14:45

### Asignaturas

**Lunes**
Programación
Bases de Datos
Sistemas Informáticos
Lenguajes de Marcas
Entornos de Desarrollo
Programación

**Martes**
Programación
Programación
Bases de Datos
Sistemas Informáticos
Inglés
Itinerario Personal

**Miércoles**
Bases de Datos
Programación
Programación
Lenguajes de Marcas
Sistemas Informáticos
Entornos de Desarrollo

**Jueves**
Sistemas Informáticos
Bases de Datos
Programación
Programación
Inglés
Sostenibilidad

**Viernes**
Lenguajes de Marcas
Sistemas Informáticos
Bases de Datos
Programación
Entornos de Desarrollo
Tutoría

---

## Ejemplo de salida esperada

```
==============================================================
                 HORARIO DEL GRUPO 1º DAW
==============================================================

+---------------+----------------------+----------------------+----------------------+----------------------+----------------------+
| Hora          | Lunes                | Martes               | Miércoles            | Jueves               | Viernes              |
+---------------+----------------------+----------------------+----------------------+----------------------+----------------------+
| 08:15-09:15   | Programación         | Programación         | Bases de Datos       | Sistemas Informáticos| Lenguajes de Marcas  |
| 09:15-10:15   | Bases de Datos       | Programación         | Programación         | Bases de Datos       | Sistemas Informáticos|
| 10:15-11:15   | Sistemas Informáticos| Bases de Datos       | Programación         | Programación         | Bases de Datos       |
| 11:45-12:45   | Lenguajes de Marcas  | Sistemas Informáticos| Lenguajes de Marcas  | Programación         | Programación         |
| 12:45-13:45   | Entornos de Desarrollo| Inglés              | Sistemas Informáticos| Inglés               | Entornos de Desarrollo|
| 13:45-14:45   | Programación         | Itinerario Personal  | Entornos de Desarrollo| Sostenibilidad      | Tutoría              |
+---------------+----------------------+----------------------+----------------------+----------------------+----------------------+
```

---

## Qué aspectos de formato se esperan

Aquí está la clave del CE b. No vale con imprimir datos “uno debajo de otro” sin más. Se exige que el alumnado cuide cuestiones como estas:

* que las columnas tengan un ancho homogéneo;
* que los textos estén alineados;
* que la cabecera se distinga del resto;
* que la tabla sea fácil de leer;
* que los nombres largos no rompan completamente la presentación.

En otras palabras: el programa debe mostrar la información como un horario, no como una lista desordenada de supervivencia.

---

## Posible secuencia de lectura de datos

Una forma lógica de pedir los datos sería esta:

1. Pedir nombre del grupo.
2. Pedir los 6 tramos horarios.
3. Para cada tramo horario:

    * pedir asignatura del lunes,
    * pedir asignatura del martes,
    * pedir asignatura del miércoles,
    * pedir asignatura del jueves,
    * pedir asignatura del viernes.
4. Mostrar la tabla final.

---

## Variante más sencilla

Si quieres que la práctica no se haga demasiado larga, también puedes simplificarla así:

* en vez de pedir 6 tramos horarios escritos por el usuario, los dejas fijos en el programa;
* el alumno solo introduce las asignaturas;
* al final se imprime el horario.

Eso te permite centrar más la práctica en entrada básica por consola y salida formateada, sin dispersarse demasiado.

---

## Redacción breve para entregar directamente al alumnado

**Práctica: Horario semanal por consola**

Desarrolla una aplicación en Kotlin que permita introducir por teclado un horario semanal de clase y mostrarlo al final en forma de tabla bien alineada en consola.

El programa deberá pedir:

* el nombre del grupo,
* los 6 tramos horarios,
* y la asignatura correspondiente a cada día de la semana lectiva (lunes a viernes) en cada una de las 6 horas.

Al finalizar, deberá mostrar el horario completo en formato tabla, con:

* una fila de cabecera con los días,
* una columna inicial con las horas,
* y el nombre de cada asignatura en su posición correspondiente.

Se valorará especialmente:

* el uso correcto de la entrada y salida por consola,
* la claridad de los mensajes,
* y el formato aplicado a la salida final para que la tabla sea legible y ordenada.

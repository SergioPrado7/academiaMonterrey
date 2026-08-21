# Sistema de Gestión - Cine San Pedro 🎬
**Práctica: Inyección de Dependencias en Java**

Este proyecto es un ejemplo práctico de qué es y para qué sirve la **Inyección de Dependencias** usando solo Java básico (sin Spring, sin anotaciones y sin librerías mágicas). 

Para entender la diferencia, el proyecto se divide en dos versiones dentro de dos paquetes: `gestion_v0` (la forma incorrecta o amarrada) y `gestion_v1` (la forma limpia y flexible).

---

## 📂 ¿Cómo está organizado el proyecto?

### 1. La versión sin Inyección de Dependencias (`gestion_v0`)
En esta primera versión, la clase `SalaCine` hace todo el trabajo pesado y toma todas las decisiones. 
* Dentro de su propio constructor usa la palabra `new` para crear un `ProyectorIMAX` y un `ProyectorDigital`.
* Usa un `if / else` para decidir cuál de los dos encender.

**¿Por qué está mal?**
* **Desperdicio de memoria:** Al hacer `new` de los dos proyectores al mismo tiempo, creas objetos que ni siquiera vas a usar en esa función.
* **Código muy rígido:** La sala está obligada a conocer cada marca y modelo de proyector que exista. Si mañana compramos un proyector 3D, tendríamos que entrar a modificar el código de la sala.

---

### 2. La versión con Inyección de Dependencias (`gestion_v1`)
En esta versión arreglamos el diseño usando tres piezas clave:
1. **La Interfaz (`Proyector`):** Define la regla general de que cualquier proyector debe saber cómo proyectar una película.
2. **El Cliente (`SalaCine`):** Ya no crea ningún proyector con `new`. Simplemente pide en su constructor que alguien le entregue un `Proyector` ya listo.
3. **El Inyector (`AdministradorCine`):** Es la clase encargada de tomar las decisiones. Decide si crear un `ProyectorDigital` o un `ProyectorIMAX`, se lo entrega (se lo inyecta) a la `SalaCine` y nos devuelve la sala armada.

La clase `Main` solo pide la sala al `AdministradorCine` y arranca la función.

---

## El "Por Qué" detrás de este cambio

### ¿Por qué esto sí es Inyección de Dependencias?
Porque le quitamos a la `SalaCine` la responsabilidad de fabricar sus propias herramientas. La sala ya no dice: *"yo me compro mi proyector"*, sino que dice: *"yo solo sé reproducir películas, que el administrador me entregue el proyector que quiera"*. 

El acto de pasarle ese objeto a través del constructor es la **Inyección**, y quitarle el control a la sala es la **Inversión de Control**.

---

### ¿Qué problemas reales resuelve?

#### 1. Elimina el código amarrado (Bajo Acoplamiento)
En la versión `v0`, la sala dependía totalmente de clases específicas. 
En la versión `v1`, a la sala no le importa qué tecnología le conectes mientras cumpla con la interfaz `Proyector`. Si agregamos una tecnología nueva (como `Proyector3D`), la clase `SalaCine` no se toca para nada; solo se le pasa el nuevo proyector desde el `AdministradorCine`.

#### 2. Hace que el código sea fácil de probar
En la versión mala, si querías hacer una prueba unitaria de la sala, estabas obligado a arrancar un proyector real con todo lo que eso implica. 
Con la inyección de dependencias, podemos crear un proyector falso "de mentira" (un Mock) en dos líneas, inyectárselo a la sala y probar si los horarios y nombres de las películas funcionan bien, sin depender de un equipo real.
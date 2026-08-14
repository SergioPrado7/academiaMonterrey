# 🍿 Sistema de Gestión - Cine San Pedro

Este es mi primer proyecto formal en Java. Como desarrollador junior, el objetivo principal de este sistema es poner en práctica los conceptos de Programación Orientada a Objetos (POO) que he estado aprendiendo, aplicándolos a un caso real de gestión de salas y venta de boletos.

## 📂 Estructura del Proyecto (Versiones)

Para demostrar mi aprendizaje paso a paso, decidí dividir el proyecto en dos etapas mediante paquetes:

*   **Versión 0 (`cinesanpedrocoahuila_v0`):** Es la arquitectura base. Aquí construí toda la lógica de las clases, la herencia y el polimorfismo, realizando las pruebas de venta de forma directa en el código para asegurar que la estructura funcionara correctamente.
*   **Versión 1 (`cinesanpedrocoahuila_v1`):** Es la versión interactiva y final. Tomé la base sólida de la v0 y la conecté a una interfaz de consola donde un usuario real puede operar la taquilla, elegir películas y comprar boletos en vivo.

## 🛠️ Conceptos de Java Implementados en el Proyecto

A continuación, explico qué conceptos apliqué, dónde se pueden observar en mi código y cómo los utilicé:

*   **Abstract:** En este proyecto implementé una clase abstracta en `Boleto.java`. La utilicé porque un "Boleto" general no se puede instanciar por sí solo (siempre debe ser básico o premium). Esto se observa en la declaración `public abstract class Boleto` y en la creación del método abstracto `calcularPrecio()`, el cual obliga a las clases hijas a definir su propio precio.
*   **Is-A (Herencia):** Lo implementé para crear los tipos específicos de boletos. Se puede observar en los archivos `BoletoBasico.java` y `BoletoPremium.java`, donde utilizo la palabra clave `extends Boleto` porque ambos tipos *son un* boleto y heredan de la clase padre.
*   **Has-A (Composición/Agregación):** Lo implementé en la estructura de mis clases principales. Por ejemplo, en `Sala.java`, se puede observar que una Sala *tiene una* `Pelicula` (`private Pelicula peliculaAsignada`) y *tiene una* colección de boletos (`private ArrayList<Boleto> boletosVendidos`).
*   **Constructores:** Los utilicé para inicializar los datos obligatorios de mis objetos desde el momento en que los creo. Por ejemplo, en `Pelicula.java`, el constructor `public Pelicula(String titulo, int duracionMins)` me permite establecer esos valores iniciales.
*   **Encapsulación (Getters):** La implementé manteniendo el estado de mis objetos seguro. Todas las propiedades de las clases (como `numeroSala` en `Sala.java`) están declaradas como `private`. Para poder leer esta información desde afuera, implementé métodos públicos como `getNumeroSala()`.
*   **Modificadores de Acceso:** Utilicé los siguientes según la necesidad de seguridad de los datos:
    *   `private`: En casi todas las variables de instancia de mis clases para restringir su acceso directo.
    *   `protected`: Lo utilicé específicamente en la variable `numeroAsiento` de la clase padre `Boleto.java` para permitir que las clases hijas (`BoletoBasico` y `BoletoPremium`) puedan acceder a este dato de forma directa.
    *   `public`: En todos los constructores y métodos que necesito ejecutar desde otras clases.
*   **Inmutabilidad (Final):** Utilicé la palabra reservada `final` en las variables que no deben cambiar nunca después de ser inicializadas por el constructor. Esto se observa claramente en `Cine.java` con las variables `nombreCine` y `ubicacionCine`, y en `Pelicula.java` con el `titulo` y la `duracionMins`.
*   **Polimorfismo:** Lo implementé en el cálculo de los precios. En `Principal.java`, recorro todos los boletos con un ciclo y ejecuto `b.calcularPrecio()`. Gracias al polimorfismo, el programa calcula automáticamente el total sumando $50 si el objeto es instancia de `BoletoBasico` o $100 si es instancia de `BoletoPremium`, sin que yo tenga que hacer validaciones extra para el precio.
*   **Cast:** Lo apliqué en la clase `Principal.java` cuando recorro las ventas de la sala. Como mi lista maneja objetos del tipo general `Boleto`, tuve que hacer un cast explícito `(BoletoPremium) b` al detectar la instancia premium, para poder invocar el método específico `premium.pedirComidaAsiento()`, el cual no existe en los boletos básicos.
*   **Generics:** Lo implementé en el manejo de mis colecciones. Esto se puede ver en `Sala.java` y en `Principal.java` al declarar las listas con `< >`, por ejemplo `ArrayList<Boleto>` y `ArrayList<Sala>`. Con esto me aseguro de que las colecciones sean fuertemente tipadas y solo acepten esos objetos en específico.
*   **Static:** Lo utilicé para definir el punto de entrada de la aplicación en `Principal.java`, declarando el método `public static void main(String[] args)`. Esto permite que la máquina virtual de Java ejecute el método a nivel de clase sin tener que instanciar un objeto `Principal`.
*   **Interacción y Ciclos (NUEVO en v1):** En el paquete `v1`, utilicé la clase `Scanner` para capturar la entrada del teclado. Además, controlé el flujo del programa con un ciclo `while` y una variable booleana, lo que permite que la taquilla se mantenga "abierta" recibiendo clientes reales hasta que se ingrese la orden de salida.

## 🏁 Conclusión

Con esta implementación, logré integrar y aplicar de forma práctica y funcional todos los conceptos fundamentales vistos hasta ahora, creando un sistema que opera desde la base arquitectónica hasta la interacción final con el usuario en consola. ¡Y eso es todo!

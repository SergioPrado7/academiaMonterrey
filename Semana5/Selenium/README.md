# Documentación del proyecto de automatización de Santander

## 1. Propósito del proyecto

Este proyecto automatiza recorridos por el sitio público de Santander México mediante Java, Selenium y TestNG. Abre Chrome, accede a la página principal, despliega menús y selecciona enlaces hacia secciones como créditos, cuentas, seguros, empresas y PyMes.

Su propósito es facilitar la revisión repetitiva de la navegación y registrar problemas que ocurran al interactuar con los elementos de la página. No requiere ingresar a una cuenta bancaria ni realiza operaciones financieras.

El proyecto utiliza el **patrón de diseño POM (Page Object Model)**, que separa la representación de la página web de los escenarios de prueba. En esta implementación, `SantanderHomePage` concentra los localizadores y las acciones de la página, `BasePage` proporciona operaciones reutilizables y `SantanderNavigationTest` define los escenarios de prueba. Esta organización facilita localizar los selectores y actualizar las acciones cuando cambia el sitio.

## 2. Caso de uso

**Caso de uso: revisión automatizada de enlaces del menú principal.**

Un integrante del equipo de pruebas necesita revisar diferentes accesos del sitio después de un cambio en la interfaz. En lugar de repetir manualmente la apertura de menús y enlaces, ejecuta la suite.

### Condiciones previas

- Tener instalado un JDK compatible con la compilación configurada para Java 21.
- Tener Maven disponible, o utilizar un entorno de desarrollo con integración de Maven.
- Tener TestNG disponible: Maven descarga la dependencia declarada en `pom.xml`. Para ejecutar la suite desde Eclipse con Run As > TestNG Suite, también se necesita tener instalado el complemento de TestNG en Eclipse.
- Tener Google Chrome instalado.
- Contar con conexión al sitio de Santander y, cuando sea necesario, a los servicios de descarga de dependencias y del controlador del navegador.

### Flujo del caso de uso

1. El usuario ejecuta la suite mediante Maven o TestNG.
2. Se abre Chrome y se carga `https://www.santander.com.mx/`.
3. El programa abre un menú, por ejemplo, Personas.
4. Selecciona un enlace, como Tarjetas de crédito.
5. Si detecta una nueva ventana o pestaña, cambia el control hacia ella.
6. Registra en consola el nombre del recorrido y el título obtenido.
7. Regresa al inicio y continúa con los otros enlaces.
8. Si ocurre un error, lo acumula y continúa con los siguientes recorridos del grupo.
9. Al terminar el grupo, informa si hubo fallos e intenta guardar una captura si la prueba falló.
10. Cierra el navegador y continúa con el siguiente método de prueba.

### Resultado

Se obtiene un registro de ejecución y reportes para identificar los grupos que finalizaron correctamente o presentaron errores. Las capturas disponibles ayudan a investigar el estado del navegador al momento de notificarse un fallo.

## 3. Tecnologías utilizadas

| Tecnología | Función dentro del proyecto |
|---|---|
| Java | Lenguaje con el que se implementan las clases, acciones y pruebas. |
| Selenium WebDriver | Controla el navegador y permite interactuar con los elementos del sitio. |
| ChromeDriver | Implementación de WebDriver que permite controlar Chrome. |
| TestNG | Organiza y ejecuta las pruebas, administra su preparación y cierre, y registra fallos. |
| Maven | Administra dependencias, compila el proyecto y coordina la ejecución de pruebas. |
| Maven Surefire | Ejecuta la suite de TestNG desde Maven. |
| SLF4J Simple | Proporciona soporte de registro para las bibliotecas que utilizan SLF4J. |

Selenium ejecuta las interacciones; TestNG determina cuáles pruebas correr y cómo reportar sus resultados; Maven reúne las dependencias y permite iniciar el proceso con un comando.

## 4. Estructura del proyecto

```text
selenium-santander-sergioprado/
├── pom.xml
├── testng.xml
├── README.md
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── base/
│   │       │   └── BasePage.java
│   │       ├── pages/
│   │       │   └── SantanderHomePage.java
│   │       └── utils/
│   │           └── DriverFactory.java
│   └── test/
│       └── java/
│           ├── base/
│           │   └── BaseTest.java
│           ├── listeners/
│           │   └── ScreenshotListener.java
│           └── tests/
│               └── SantanderNavigationTest.java
└── test-output/
    ├── index.html
    ├── emailable-report.html
    ├── testng-results.xml
    ├── testng-failed.xml
    ├── screenshots/
    ├── junitreports/
    ├── Automation Practice - POM/
    ├── Default suite/
    └── archivos de apoyo de los reportes
```

La carpeta `src` contiene el código fuente. La carpeta `test-output` contiene resultados generados durante ejecuciones. Los archivos y subcarpetas de resultados pueden variar según la forma de ejecución y el historial existente.

## 5. Carpeta src/main/java

Contiene las clases que implementan la infraestructura reutilizable de automatización y la representación del sitio. En este proyecto, `main` no contiene un método `main()` para iniciar el programa: la ejecución se inicia mediante las pruebas.

### utils/DriverFactory.java

**Responsabilidad:** crear y configurar el navegador.

Su método `createChromeDriver()` prepara las opciones de Chrome, crea una instancia de `ChromeDriver`, maximiza la ventana y devuelve el objeto como `WebDriver`.

Configura preferencias para desactivar funciones relacionadas con el administrador de contraseñas y agrega una opción para evitar la pantalla de elección de buscador.

También consulta la propiedad `headless`:

- Con `false`, Chrome se ejecuta mostrando su ventana.
- Con `true`, Chrome se ejecuta sin mostrar la ventana y configura un tamaño de 1920 × 1080.

Ejemplo de uso dentro del código:

```java
driver = DriverFactory.createChromeDriver();
```

Centralizar esta configuración evita repetirla en cada prueba. El código no especifica una ruta manual a ChromeDriver; Selenium Manager puede gestionar el controlador cuando sea necesario.

### base/BasePage.java

**Responsabilidad:** proporcionar operaciones comunes para las clases de página.

Es una clase abstracta. `SantanderHomePage` hereda de ella para reutilizar sus métodos.

Mantiene:

- `WebDriver`: controla el navegador.
- `WebDriverWait`: espera condiciones hasta un límite configurado de 12 segundos.
- `Actions`: permite preparar interacciones avanzadas, aunque los recorridos actuales no utilizan ese objeto.

Una espera de 12 segundos es un límite para alcanzar la condición; no significa que siempre se detenga durante todo ese tiempo.

| Método | Función |
|---|---|
| `find(By locator)` | Espera y devuelve el primer elemento visible que coincide con el localizador. |
| `click(By locator)` | Espera un elemento visible y habilitado, lo desplaza a la vista e intenta hacer clic. |
| `write(By locator, String value)` | Limpia un campo y escribe el valor indicado. |
| `text(By locator)` | Obtiene el texto de un elemento visible. |
| `selectByText(By locator, String value)` | Selecciona una opción por su texto en un elemento HTML `select`. |
| `isSelected(By locator)` | Consulta si un elemento está seleccionado. |
| `exists(By locator)` | Comprueba si existen coincidencias, sin esperar ni exigir visibilidad. |

El método `click()` intenta primero un clic normal. Ante determinados errores de interacción, utiliza JavaScript. Si el elemento quedó desactualizado porque cambió el DOM, intenta localizarlo nuevamente.

El **DOM** es la representación de los elementos HTML que Selenium consulta para encontrar botones, enlaces y campos.

Los métodos para escribir, seleccionar y leer elementos permiten ampliar el proyecto con otras interacciones, aunque las pruebas actuales se concentran en navegación.

### pages/SantanderHomePage.java

**Responsabilidad:** representar los accesos y acciones del menú principal de Santander.

Contiene dos partes:

1. **Localizadores:** describen cómo encontrar los elementos.
2. **Métodos de navegación:** utilizan esos localizadores para ejecutar recorridos.

Ejemplo de localizador por identificador:

```java
private static final By BTN_PERSONAS =
    By.id("firstLevel-mainItem-0-menu-button");
```

Ejemplo de localizador CSS:

```java
private static final By LNK_TARJETAS_CREDITO =
    By.cssSelector("a[href*='tarjetas-de-credito']");
```

El segundo busca un enlace cuyo atributo `href` contenga el texto `tarjetas-de-credito`. En otros selectores aparece `$=`, que significa que el atributo debe terminar con el texto indicado.

Un localizador describe la búsqueda; no almacena por sí mismo un elemento ya encontrado.

Ejemplo de acción:

```java
public void irATarjetasDeCredito() {
    abrirMenuPersonas();
    click(LNK_TARJETAS_CREDITO);
}
```

La prueba solicita la acción por su nombre y esta clase resuelve los clics necesarios. Si cambia el HTML, se revisan los localizadores correspondientes en esta clase.

## 6. Carpeta src/test/java

Contiene la preparación de las pruebas, los escenarios que se ejecutan y el mecanismo de captura de errores.

### base/BaseTest.java

**Responsabilidad:** administrar el navegador durante las pruebas.

Es una clase abstracta de la que hereda `SantanderNavigationTest`.

Define la dirección inicial:

```java
protected static final String HOME_URL =
    "https://www.santander.com.mx/";
```

Sus métodos principales son:

| Método | Función |
|---|---|
| `setUp()` | Se ejecuta antes de cada método de prueba y crea el navegador. |
| `iniciarDriver()` | Abre Chrome, carga el inicio y guarda el identificador de la ventana principal. |
| `volverAlInicio()` | Conserva una ventana, cierra las adicionales y carga nuevamente el inicio. |
| `obtenerVentanas()` | Obtiene los identificadores de las ventanas abiertas. |
| `ajustarVentanaDespuesDeNavegacion()` | Cambia a una nueva ventana si la detecta después del recorrido. |
| `reiniciarDriver()` | Intenta cerrar la sesión anterior y crea otra. |
| `tearDown()` | Intenta cerrar la sesión del navegador al terminar cada método de prueba. |
| `getDriver()` | Permite al listener obtener el navegador para capturar la pantalla. |

TestNG reconoce la preparación y el cierre mediante:

```java
@BeforeMethod(alwaysRun = true)
```

```java
@AfterMethod(alwaysRun = true)
```

Se crea una sesión de navegador por método marcado con `@Test`. Los enlaces de ese grupo comparten la sesión, salvo que el código necesite reiniciarla.

Para regresar al inicio se utiliza `driver.get(HOME_URL)`, no el botón Atrás. Esto permite comenzar cada recorrido desde la misma dirección.

### tests/SantanderNavigationTest.java

**Responsabilidad:** definir los grupos de recorridos y acumular sus errores.

Contiene nueve métodos de prueba, con prioridades del 1 al 9:

| Grupo | Cantidad de recorridos |
|---|---:|
| Personas: créditos | 6 |
| Personas: canales digitales | 4 |
| Personas: cuentas | 5 |
| Personas: inversiones y seguros | 9 |
| Personas: ayuda y beneficios | 15 |
| Empresas | 2 |
| PyMes | 11 |
| Banca Privada | 1 |
| Acerca del banco | 7 |
| **Total** | **60** |

Son 60 llamadas de navegación agrupadas en nueve pruebas de TestNG. Las prioridades ordenan los métodos, pero no crean dependencias entre ellos.

El método auxiliar `verificarNavegacion()` evita repetir la misma preparación y gestión de errores en cada recorrido. Recibe:

- Un objeto `SoftAssert` para acumular fallos.
- Un nombre descriptivo para el registro.
- Una acción de tipo `Consumer<SantanderHomePage>`.

Ejemplo:

```java
verificarNavegacion(
    softAssert,
    "Personas - Tarjetas de Crédito",
    SantanderHomePage::irATarjetasDeCredito
);
```

La expresión `SantanderHomePage::irATarjetasDeCredito` es una referencia a método: entrega la acción que deberá ejecutarse sobre el objeto de página.

Dentro del auxiliar, la instrucción:

```java
navegacion.accept(homePage);
```

ejecuta esa acción.

Si ocurre una excepción, se registra mediante `softAssert.fail()` y se continúa con el siguiente recorrido. Al finalizar el grupo, `softAssert.assertAll()` hace fallar la prueba si se acumularon errores.

Esto permite intentar todos los enlaces del grupo aunque uno presente problemas.

### listeners/ScreenshotListener.java

**Responsabilidad:** intentar guardar una captura cuando TestNG notifica el fallo de una prueba.

Implementa `ITestListener` y utiliza `onTestFailure()`.

Cuando recibe el evento:

1. Verifica que la instancia de prueba sea compatible con `BaseTest`.
2. Obtiene el navegador.
3. Comprueba que soporte `TakesScreenshot`.
4. Crea la carpeta `test-output/screenshots` si es necesario.
5. Guarda un archivo PNG con el nombre del método y una marca de tiempo.
6. Agrega la ruta y un enlace al registro del reporte.

Si no logra guardar la imagen, registra el error.

Como los fallos se acumulan con `SoftAssert`, la captura se intenta al notificarse el fallo del método completo. Puede mostrar un estado posterior al enlace que originó el problema; no se genera automáticamente una captura por cada recorrido fallido.

## 7. Archivo pom.xml

Es el archivo de configuración de Maven. Define la identidad del proyecto, las versiones de las dependencias y las herramientas de compilación y pruebas.

### Configuración principal

- `groupId`: `com.practice.selenium`.
- `artifactId`: `selenium-framework-pom-completo`.
- `version`: `1.0-SNAPSHOT`.
- Versión de compilación: Java 21.
- Codificación del proyecto: UTF-8.

### Dependencias

- `selenium-java`, versión `4.35.0`: automatización del navegador.
- `testng`, versión `7.11.0`, con alcance `test`: disponible para el código de pruebas.
- `slf4j-simple`, versión `2.0.17`: soporte de registro.

### Plugins

**Maven Compiler Plugin:** compila el código Java según la configuración del proyecto.

**Maven Surefire Plugin:** ejecuta las pruebas utilizando `testng.xml` y configura `test-output` como directorio de reportes.

### Propiedades de ejecución

- `headless`: controla si Chrome muestra una ventana. El código sí consulta esta propiedad.
- `forceFailure`: está declarada y se pasa a la ejecución, pero las clases Java actuales no la consultan. Activarla no provoca una falla intencional en esta versión.

El nombre `pom.xml` significa **Project Object Model** de Maven. Es distinto del patrón **Page Object Model** utilizado para organizar las clases de automatización.

## 8. Archivo testng.xml

Define la suite que ejecuta TestNG.

En este proyecto:

- La suite se llama `Automation Practice - POM`.
- La ejecución está configurada sin paralelismo.
- Se registra `listeners.ScreenshotListener`.
- Se selecciona la clase `tests.SantanderNavigationTest`.
- El bloque de pruebas se llama `Recorrido completo`.

Este archivo conecta los escenarios con el listener. Maven Surefire lo utiliza para determinar qué suite ejecutar.

El nombre de la suite conserva una denominación anterior, aunque la clase seleccionada corresponde a Santander.

## 9. Carpeta test-output

Contiene evidencias y reportes generados durante las ejecuciones. No forma parte del código fuente que implementa las acciones.

| Archivo o carpeta | Propósito |
|---|---|
| `index.html` | Permite consultar el reporte HTML de TestNG cuando está generado. |
| `emailable-report.html` | Presenta un reporte HTML resumido. |
| `testng-results.xml` | Almacena resultados en formato XML. |
| `testng-failed.xml` | Puede describir las pruebas fallidas para facilitar su repetición; debe revisarse que corresponda a la ejecución de interés. |
| `screenshots/` | Guarda las capturas que logra generar el listener. |
| `junitreports/` | Contiene resultados XML compatibles con herramientas que procesan el formato JUnit. |
| Carpetas de suites | Agrupan reportes de ejecuciones y configuraciones específicas. |
| Archivos CSS, JavaScript e imágenes | Proporcionan apariencia e interacción a los reportes HTML. |

La presencia de reportes compatibles con JUnit no significa que las pruebas estén escritas con JUnit: este proyecto utiliza TestNG.

Los archivos existentes pueden incluir ejecuciones anteriores y nombres de pruebas que ya no forman parte del código. Deben revisarse las fechas y la suite antes de interpretar un reporte.

La configuración de Maven dirige sus reportes a esta carpeta. Los archivos exactos pueden variar según se ejecute desde Maven o desde el entorno de desarrollo. Además, `mvn clean` no garantiza por sí solo eliminar esta carpeta personalizada situada fuera de `target`.

## 10. Ejecución y uso de Selenium y TestNG

### Ejecutar desde Maven

Abrir una terminal en la carpeta que contiene `pom.xml` y ejecutar:

```powershell
mvn clean test
```

Maven resuelve las dependencias necesarias, compila el código y ejecuta la suite mediante Surefire.

Para ejecutar Chrome sin mostrar una ventana:

```powershell
mvn clean test "-Dheadless=true"
```

### Ejecutar desde Eclipse

1. Importar la carpeta como un proyecto Maven existente.
2. Actualizar las dependencias con la opción Maven > Update Project.
3. Tener disponible la integración de TestNG.
4. Abrir `testng.xml`.
5. Ejecutar Run As > TestNG Suite.

### Cómo se utiliza Selenium

Selenium se utiliza desde las clases Java mediante:

- `driver.get(...)`: abrir una dirección.
- `By.id(...)` y `By.cssSelector(...)`: describir búsquedas de elementos.
- `findElements(...)`: localizar coincidencias.
- `WebDriverWait`: esperar elementos y condiciones.
- `click()`: hacer clic.
- `sendKeys(...)`: escribir en campos.
- `switchTo().window(...)`: cambiar la ventana controlada.
- `getTitle()`: leer el título.
- `TakesScreenshot`: obtener capturas.
- `quit()`: finalizar la sesión.

El proyecto agrupa estas operaciones dentro de sus clases base y objetos de página para reutilizarlas.

### Cómo se utiliza TestNG

TestNG participa mediante:

- `@Test`: identifica los métodos de prueba.
- `priority`: establece prioridades de ejecución.
- `@BeforeMethod`: prepara cada prueba.
- `@AfterMethod`: realiza el cierre.
- `SoftAssert`: acumula fallos antes de reportarlos al final del grupo.
- `ITestListener`: permite reaccionar al fallo de una prueba.
- `testng.xml`: selecciona la suite, sus clases y listeners.

### Consulta de resultados

Al finalizar, revisar la salida de consola y los reportes de la ejecución en `test-output`. Si hubo errores, consultar las capturas disponibles y los mensajes de excepción para investigar la causa.

## 11. Cómo ampliar el proyecto

Para incorporar un nuevo enlace:

1. Identificar su elemento en el HTML del sitio.
2. Agregar el localizador en `SantanderHomePage`.
3. Crear un método que abra el menú correspondiente y haga clic.
4. Agregar una llamada a `verificarNavegacion()` en el grupo apropiado.
5. Ejecutar la suite y revisar los resultados.

Para automatizar otra página con más interacciones, se puede crear una nueva clase que herede de `BasePage`. Para crear nuevos escenarios, se puede agregar una clase que herede de `BaseTest` y registrarla en `testng.xml`.

Para comprobar correctamente el destino de los enlaces, sería necesario agregar esperas y validaciones de URL, título o elementos exclusivos de cada página. Esa validación todavía no está implementada.

## 12. Consideraciones del código actual

- Los selectores dependen del HTML del sitio y pueden requerir ajustes cuando cambie.
- La detección de nuevas ventanas consulta las ventanas disponibles sin una espera explícita para su aparición.
- El clic mediante JavaScript puede permitir continuar aun cuando la interacción normal esté bloqueada; conviene considerar esto al interpretar resultados.
- Las capturas se producen por fallo del método de prueba, no por cada enlace.
- El README conserva referencias a una versión anterior con formularios y clases llamadas AutomationPractice. Esta documentación describe las clases actuales de Santander.
- Esta documentación se elaboró mediante revisión del código; no constituye evidencia de una ejecución exitosa ni de disponibilidad actual de los enlaces.


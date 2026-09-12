package base;

import java.util.LinkedHashSet;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverFactory;

public abstract class BaseTest {

    protected WebDriver driver;
    protected static final String HOME_URL = "https://www.santander.com.mx/";
    private String mainWindow;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        iniciarDriver();
    }

    private void iniciarDriver() {
        driver = DriverFactory.createChromeDriver();
        driver.get(HOME_URL);
        mainWindow = driver.getWindowHandle();
    }

    protected void volverAlInicio() {
        try {
            if (driver == null) {
                iniciarDriver();
                return;
            }

            Set<String> ventanas = new LinkedHashSet<>(driver.getWindowHandles());

            if (ventanas.isEmpty()) {
                System.out.println("[INFO] No quedan ventanas abiertas. Reiniciando navegador...");
                reiniciarDriver();
                return;
            }

            String ventanaObjetivo;

            if (mainWindow != null && ventanas.contains(mainWindow)) {
                ventanaObjetivo = mainWindow;
            } else {
                ventanaObjetivo = ventanas.iterator().next();
                mainWindow = ventanaObjetivo;
            }

            driver.switchTo().window(ventanaObjetivo);

            for (String ventana : ventanas) {
                if (!ventana.equals(ventanaObjetivo)) {
                    try {
                        driver.switchTo().window(ventana);
                        driver.close();
                    } catch (WebDriverException ignored) {
                    }
                }
            }

            driver.switchTo().window(ventanaObjetivo);
            driver.get(HOME_URL);

        } catch (WebDriverException error) {
            System.out.println("[INFO] La ventana de Chrome se perdió: " + error.getClass().getSimpleName());
            System.out.println("[INFO] Reiniciando navegador...");
            reiniciarDriver();
        }
    }

    protected Set<String> obtenerVentanas() {
        try {
            return new LinkedHashSet<>(driver.getWindowHandles());
        } catch (WebDriverException error) {
            return new LinkedHashSet<>();
        }
    }

    protected void ajustarVentanaDespuesDeNavegacion(Set<String> ventanasAntes) {
        Set<String> ventanasDespues = new LinkedHashSet<>(driver.getWindowHandles());

        if (ventanasDespues.isEmpty()) {
            throw new WebDriverException("Santander cerró todas las ventanas.");
        }

        for (String ventana : ventanasDespues) {
            if (!ventanasAntes.contains(ventana)) {
                driver.switchTo().window(ventana);
                return;
            }
        }

        try {
            String actual = driver.getWindowHandle();
            if (ventanasDespues.contains(actual)) {
                return;
            }
        } catch (WebDriverException ignored) {
        }

        driver.switchTo().window(ventanasDespues.iterator().next());
    }

    protected void reiniciarDriver() {
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception ignored) {
        }
        iniciarDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception ignored) {
            }
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
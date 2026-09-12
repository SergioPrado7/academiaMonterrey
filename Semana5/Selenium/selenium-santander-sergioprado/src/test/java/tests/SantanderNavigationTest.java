package tests;

import base.BaseTest;
import java.util.Set;
import java.util.function.Consumer;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.SantanderHomePage;

public class SantanderNavigationTest extends BaseTest {

    private void verificarNavegacion(
            SoftAssert softAssert,
            String nombre,
            Consumer<SantanderHomePage> navegacion) {

        try {
            volverAlInicio();
            SantanderHomePage homePage = new SantanderHomePage(driver);
            Set<String> ventanasAntes = obtenerVentanas();

            navegacion.accept(homePage);
            ajustarVentanaDespuesDeNavegacion(ventanasAntes);

            System.out.println("[OK] " + nombre + " - Llegamos a: " + driver.getTitle());

        } catch (Exception error) {
            System.err.println(
                "[ERROR] " 
                + nombre 
                + " - " 
                + error.getClass().getSimpleName() 
                + ": " 
                + error.getMessage()
            );

            softAssert.fail(
                nombre 
                + " falló -> " 
                + error.getClass().getSimpleName() 
                + ": " 
                + error.getMessage()
            );
        }
    }

    @Test(priority = 1)
    public void shouldNavigatePersonasCreditos() {
        SoftAssert softAssert = new SoftAssert();

        verificarNavegacion(softAssert, "Personas - Tarjetas de Crédito", SantanderHomePage::irATarjetasDeCredito);
        verificarNavegacion(softAssert, "Personas - Crédito Personal", SantanderHomePage::irACreditoPersonal);
        verificarNavegacion(softAssert, "Personas - Crédito Hipotecario", SantanderHomePage::irACreditoHipotecario);
        verificarNavegacion(softAssert, "Personas - Simulador Hipoteca", SantanderHomePage::irASimuladorHipoteca);
        verificarNavegacion(softAssert, "Personas - Crédito Automotriz", SantanderHomePage::irACreditoAuto);
        verificarNavegacion(softAssert, "Personas - Buró de Crédito", SantanderHomePage::irABuroCredito);

        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void shouldNavigatePersonasCanalesDigitales() {
        SoftAssert softAssert = new SoftAssert();

        verificarNavegacion(softAssert, "Personas - Santander Digital", SantanderHomePage::irASantanderDigital);
        verificarNavegacion(softAssert, "Personas - App Santander", SantanderHomePage::irAAppSantander);
        verificarNavegacion(softAssert, "Personas - Santander Web", SantanderHomePage::irASantanderWeb);
        verificarNavegacion(softAssert, "Personas - Límite por Transacción", SantanderHomePage::irALimiteTransaccion);

        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void shouldNavigatePersonasCuentas() {
        SoftAssert softAssert = new SoftAssert();

        verificarNavegacion(softAssert, "Personas - Cuentas", SantanderHomePage::irACuentas);
        verificarNavegacion(softAssert, "Personas - Cuenta Básica", SantanderHomePage::irACuentaBasica);
        verificarNavegacion(softAssert, "Personas - Cuenta Nómina", SantanderHomePage::irACuentaNomina);
        verificarNavegacion(softAssert, "Personas - Cuenta Cheques", SantanderHomePage::irACuentaCheques);
        verificarNavegacion(softAssert, "Personas - Portabilidad Nómina", SantanderHomePage::irAPortabilidadNomina);

        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void shouldNavigatePersonasInversionesYSeguros() {
        SoftAssert softAssert = new SoftAssert();

        verificarNavegacion(softAssert, "Personas - Fondos de Inversión", SantanderHomePage::irAFondosInversion);
        verificarNavegacion(softAssert, "Personas - Inversiones a Plazo", SantanderHomePage::irAInversionesPlazo);
        verificarNavegacion(softAssert, "Personas - Notas Estructuradas", SantanderHomePage::irANotasEstructuradas);

        verificarNavegacion(softAssert, "Personas - Seguro Auto", SantanderHomePage::irASeguroAuto);
        verificarNavegacion(softAssert, "Personas - Seguro Vida", SantanderHomePage::irASeguroVida);
        verificarNavegacion(softAssert, "Personas - Seguro Hogar", SantanderHomePage::irASeguroHogar);
        verificarNavegacion(softAssert, "Personas - Seguro Ahorro", SantanderHomePage::irASeguroAhorro);
        verificarNavegacion(softAssert, "Personas - Seguro Gastos Médicos", SantanderHomePage::irASeguroGastosMedicos);
        verificarNavegacion(softAssert, "Personas - Seguro Pertenencias", SantanderHomePage::irASeguroPertenencias);

        softAssert.assertAll();
    }

    @Test(priority = 5)
    public void shouldNavigatePersonasAyudaYBeneficios() {
        SoftAssert softAssert = new SoftAssert();

        verificarNavegacion(softAssert, "Personas - SuperLínea", SantanderHomePage::irASuperlinea);
        verificarNavegacion(softAssert, "Personas - Sucursales", SantanderHomePage::irASucursales);
        verificarNavegacion(softAssert, "Personas - Cajeros", SantanderHomePage::irACajeros);
        verificarNavegacion(softAssert, "Personas - Canales Alternos", SantanderHomePage::irACanalesAlternos);
        verificarNavegacion(softAssert, "Personas - Centro de Ayuda", SantanderHomePage::irACentroAyuda);
        verificarNavegacion(softAssert, "Personas - Centro de Seguridad", SantanderHomePage::irACentroSeguridad);
        verificarNavegacion(softAssert, "Personas - Tutoriales", SantanderHomePage::irATutoriales);
        verificarNavegacion(softAssert, "Personas - Términos y Condiciones", SantanderHomePage::irATerminosCondiciones);
        verificarNavegacion(softAssert, "Personas - Regulación", SantanderHomePage::irARegulacion);

        verificarNavegacion(softAssert, "Personas - Select", SantanderHomePage::irASelect);
        verificarNavegacion(softAssert, "Personas - Promociones", SantanderHomePage::irAPromociones);
        verificarNavegacion(softAssert, "Personas - Unique Rewards", SantanderHomePage::irAUniqueRewards);
        verificarNavegacion(softAssert, "Personas - Colectivos", SantanderHomePage::irAColectivos);
        verificarNavegacion(softAssert, "Personas - Mundo Hogar", SantanderHomePage::irAMundoHogar);
        verificarNavegacion(softAssert, "Personas - Cashback", SantanderHomePage::irACashback);

        softAssert.assertAll();
    }

    @Test(priority = 6)
    public void shouldNavigateEmpresasLinks() {
        SoftAssert softAssert = new SoftAssert();

        verificarNavegacion(softAssert, "Empresas - Empresas y Gobierno", SantanderHomePage::irAEmpresasYGobierno);
        verificarNavegacion(softAssert, "Empresas - Multinacionales", SantanderHomePage::irAMultinacionales);

        softAssert.assertAll();
    }

    @Test(priority = 7)
    public void shouldNavigatePymesLinks() {
        SoftAssert softAssert = new SoftAssert();

        verificarNavegacion(softAssert, "PyMes - Santander Pyme", SantanderHomePage::irASantanderPyme);
        verificarNavegacion(softAssert, "PyMes - Divisas y Coberturas", SantanderHomePage::irADivisasCoberturas);
        verificarNavegacion(softAssert, "PyMes - Cuentas", SantanderHomePage::irAPymeCuentas);
        verificarNavegacion(softAssert, "PyMes - Negocio Internacional", SantanderHomePage::irANegocioInternacional);
        verificarNavegacion(softAssert, "PyMes - Paquetes PyMes", SantanderHomePage::irAPaquetesPymes);
        verificarNavegacion(softAssert, "PyMes - Créditos", SantanderHomePage::irAPymeCreditos);
        verificarNavegacion(softAssert, "PyMes - Seguros", SantanderHomePage::irAPymeSeguros);
        verificarNavegacion(softAssert, "PyMes - Alianzas", SantanderHomePage::irALianzas);
        verificarNavegacion(softAssert, "PyMes - Negocio Transaccional", SantanderHomePage::irANegocioTransaccional);
        verificarNavegacion(softAssert, "PyMes - Ecosistema Financiero", SantanderHomePage::irAEcosistemaFinanciero);
        verificarNavegacion(softAssert, "PyMes - Inversiones", SantanderHomePage::irAPymeInversiones);

        softAssert.assertAll();
    }

    @Test(priority = 8)
    public void shouldNavigateBancaPrivadaLink() {
        SoftAssert softAssert = new SoftAssert();

        verificarNavegacion(softAssert, "Banca Privada", SantanderHomePage::irABancaPrivadaHome);

        softAssert.assertAll();
    }

    @Test(priority = 9)
    public void shouldNavigateAcercaDelBancoLinks() {
        SoftAssert softAssert = new SoftAssert();

        verificarNavegacion(softAssert, "Acerca - Fundación Santander", SantanderHomePage::irAFundacionSantander);
        verificarNavegacion(softAssert, "Acerca - Blog", SantanderHomePage::irABlog);
        verificarNavegacion(softAssert, "Acerca - Sostenibilidad", SantanderHomePage::irASostenibilidad);
        verificarNavegacion(softAssert, "Acerca - Educación Financiera", SantanderHomePage::irAEducacionFinanciera);
        verificarNavegacion(softAssert, "Acerca - Inversionistas", SantanderHomePage::irAInversionistas);
        verificarNavegacion(softAssert, "Acerca - Sala de Comunicación", SantanderHomePage::irASalaComunicacion);
        verificarNavegacion(softAssert, "Acerca - Bolsa de Trabajo", SantanderHomePage::irABolsaTrabajo);

        softAssert.assertAll();
    }
}
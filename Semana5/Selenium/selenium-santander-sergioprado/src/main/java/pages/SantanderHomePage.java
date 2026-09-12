package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SantanderHomePage extends BasePage {

    private static final By BTN_PERSONAS = By.id("firstLevel-mainItem-0-menu-button");
    private static final By BTN_EMPRESAS = By.id("firstLevel-mainItem-1-menu-button");
    private static final By BTN_PYMES = By.id("firstLevel-mainItem-2-menu-button");
    private static final By LNK_BANCA_PRIVADA_LINK = By.cssSelector("a[href*='/bp/home/']");
    private static final By BTN_ACERCA = By.id("firstLevel-mainItem-4-menu-button");

    private static final By LNK_TARJETAS_CREDITO = By.cssSelector("a[href*='tarjetas-de-credito']");
    private static final By LNK_CREDITO_PERSONAL = By.cssSelector("a[href*='creditos-personales']");
    private static final By LNK_CREDITO_HIPOTECARIO = By.cssSelector("a[href$='creditos-hipotecarios/']");
    private static final By LNK_SIMULADOR_HIPOTECA = By.cssSelector("a[href*='simulador-hipotecario']");
    private static final By LNK_CREDITO_AUTO = By.cssSelector("a[href*='credito-automotriz']");
    private static final By LNK_BURO_CREDITO = By.cssSelector("a[href*='buro-de-credito']");

    private static final By LNK_SANTANDER_DIGITAL = By.cssSelector("a[href$='santander-digital/']");
    private static final By LNK_APP_SANTANDER = By.cssSelector("a[href*='app-santander']");
    private static final By LNK_SANTANDER_WEB = By.cssSelector("a[href*='santander-web']");
    private static final By LNK_LIMITE_TRANSACCION = By.cssSelector("a[href*='limite-por-transaccion']");

    private static final By LNK_CUENTAS = By.cssSelector("a[href$='personas/cuentas/']");
    private static final By LNK_CUENTA_BASICA = By.cssSelector("a[href*='cuentas/basica/']");
    private static final By LNK_CUENTA_NOMINA = By.cssSelector("a[href*='basica-nomina']");
    private static final By LNK_CUENTA_CHEQUES = By.cssSelector("a[href*='cheque-saldo-promedio']");
    private static final By LNK_PORTABILIDAD_NOMINA = By.cssSelector("a[href*='portabilidad-de-nomina']");

    private static final By LNK_FONDOS_INVERSION = By.cssSelector("a[href*='#fondos-de-inversion']");
    private static final By LNK_INVERSIONES_PLAZO = By.cssSelector("a[href*='#inversiones-a-plazo']");
    private static final By LNK_NOTAS_ESTRUCTURADAS = By.cssSelector("a[href*='#notas-estructuradas']");

    private static final By LNK_SEGURO_AUTO = By.cssSelector("a[href*='seguros.html#auto']");
    private static final By LNK_SEGURO_VIDA = By.cssSelector("a[href*='seguros.html#vida']");
    private static final By LNK_SEGURO_HOGAR = By.cssSelector("a[href*='seguros.html#hogar']");
    private static final By LNK_SEGURO_AHORRO = By.cssSelector("a[href*='seguros.html#ahorro']");
    private static final By LNK_SEGURO_GASTOS_MEDICOS = By.cssSelector("a[href*='seguros.html#gastos-medicos']");
    private static final By LNK_SEGURO_PERTENENCIAS = By.cssSelector("a[href*='seguros.html#pertenencias']");

    private static final By LNK_SUPERLINEA = By.cssSelector("a[href*='superlinea.html']");
    private static final By LNK_SUCURSALES = By.cssSelector("a[href*='sucursales.html']");
    private static final By LNK_CAJEROS = By.cssSelector("a[href*='cajeros-automaticos.html']");
    private static final By LNK_CANALES_ALTERNOS = By.cssSelector("a[href*='operaciones-canales-alternos']");
    private static final By LNK_CENTRO_AYUDA = By.cssSelector("a[href*='centro-de-ayuda.html']");
    private static final By LNK_CENTRO_SEGURIDAD = By.cssSelector("a[href*='centro-de-seguridad']");
    private static final By LNK_TUTORIALES = By.cssSelector("a[href*='tutoriales.html']");
    private static final By LNK_TERMINOS_CONDICIONES = By.cssSelector("a[href*='terminos-y-condiciones.html']");
    private static final By LNK_REGULACION = By.cssSelector("a[href*='tramite-por-defuncion.html']");

    private static final By LNK_SELECT = By.cssSelector("a[href*='select.html']");
    private static final By LNK_PROMOCIONES = By.cssSelector("a[href$='promociones/']");
    private static final By LNK_UNIQUE_REWARDS = By.cssSelector("a[href*='uniquerewards']");
    private static final By LNK_COLECTIVOS = By.cssSelector("a[href*='colectivos.html']");
    private static final By LNK_MUNDO_HOGAR = By.cssSelector("a[href*='mundohogar']");
    private static final By LNK_CASHBACK = By.cssSelector("a[href*='cashback.html']");

    private static final By LNK_EMPRESAS_GOBIERNO = By.cssSelector("a[href*='bei/home.html']");
    private static final By LNK_MULTINACIONALES = By.cssSelector("a[href*='multinacionales.html']");

    private static final By LNK_SANTANDER_PYME = By.cssSelector("a[href$='/pyme/']");
    private static final By LNK_DIVISAS_COBERTURAS = By.cssSelector("a[href*='coberturas-y-cambios.html']");
    private static final By LNK_PYME_CUENTAS = By.cssSelector("a[href*='pyme/cuentas.html']");
    private static final By LNK_NEGOCIO_INTERNACIONAL = By.cssSelector("a[href*='negocio-internacional.html']");
    private static final By LNK_PAQUETES_PYMES = By.cssSelector("a[href*='paquetes-pymes.html']");
    private static final By LNK_PYME_CREDITOS = By.cssSelector("a[href*='pyme/creditos.html']");
    private static final By LNK_PYME_SEGUROS = By.cssSelector("a[href*='pyme/seguros.html']");
    private static final By LNK_ALIANZAS = By.cssSelector("a[href*='alianzas.html']");
    private static final By LNK_NEGOCIO_TRANSACCIONAL = By.cssSelector("a[href*='negocio-transaccional.html']");
    private static final By LNK_ECOSISTEMA_FINANCIERO = By.cssSelector("a[href*='ecosistemas-pyme.html']");
    private static final By LNK_PYME_INVERSIONES = By.cssSelector("a[href*='pyme/inversiones.html']");

    private static final By LNK_FUNDACION_SANTANDER = By.cssSelector("a[href*='fundacion-santander.html']");
    private static final By LNK_BLOG = By.cssSelector("a[href*='blog.html']");
    private static final By LNK_SOSTENIBILIDAD = By.cssSelector("a[href*='responsabilidad-social.html']");
    private static final By LNK_EDUCACION_FINANCIERA = By.cssSelector("a[href*='educacion-financiera']");
    private static final By LNK_INVERSIONISTAS = By.cssSelector("a[href*='ir/home/']");
    private static final By LNK_SALA_COMUNICACION = By.cssSelector("a[href*='sala_prensa']");
    private static final By LNK_BOLSA_TRABAJO = By.cssSelector("a[href*='bolsa-de-trabajo.html']");

    public SantanderHomePage(WebDriver driver) {
        super(driver);
    }

    private void abrirMenuPersonas() {
        click(BTN_PERSONAS);
    }

    private void abrirMenuEmpresas() {
        click(BTN_EMPRESAS);
    }

    private void abrirMenuPymes() {
        click(BTN_PYMES);
    }

    private void abrirMenuAcerca() {
        click(BTN_ACERCA);
    }

    public void irATarjetasDeCredito() {
        abrirMenuPersonas();
        click(LNK_TARJETAS_CREDITO);
    }

    public void irACreditoPersonal() {
        abrirMenuPersonas();
        click(LNK_CREDITO_PERSONAL);
    }

    public void irACreditoHipotecario() {
        abrirMenuPersonas();
        click(LNK_CREDITO_HIPOTECARIO);
    }

    public void irASimuladorHipoteca() {
        abrirMenuPersonas();
        click(LNK_SIMULADOR_HIPOTECA);
    }

    public void irACreditoAuto() {
        abrirMenuPersonas();
        click(LNK_CREDITO_AUTO);
    }

    public void irABuroCredito() {
        abrirMenuPersonas();
        click(LNK_BURO_CREDITO);
    }

    public void irASantanderDigital() {
        abrirMenuPersonas();
        click(LNK_SANTANDER_DIGITAL);
    }

    public void irAAppSantander() {
        abrirMenuPersonas();
        click(LNK_APP_SANTANDER);
    }

    public void irASantanderWeb() {
        abrirMenuPersonas();
        click(LNK_SANTANDER_WEB);
    }

    public void irALimiteTransaccion() {
        abrirMenuPersonas();
        click(LNK_LIMITE_TRANSACCION);
    }

    public void irACuentas() {
        abrirMenuPersonas();
        click(LNK_CUENTAS);
    }

    public void irACuentaBasica() {
        abrirMenuPersonas();
        click(LNK_CUENTA_BASICA);
    }

    public void irACuentaNomina() {
        abrirMenuPersonas();
        click(LNK_CUENTA_NOMINA);
    }

    public void irACuentaCheques() {
        abrirMenuPersonas();
        click(LNK_CUENTA_CHEQUES);
    }

    public void irAPortabilidadNomina() {
        abrirMenuPersonas();
        click(LNK_PORTABILIDAD_NOMINA);
    }

    public void irAFondosInversion() {
        abrirMenuPersonas();
        click(LNK_FONDOS_INVERSION);
    }

    public void irAInversionesPlazo() {
        abrirMenuPersonas();
        click(LNK_INVERSIONES_PLAZO);
    }

    public void irANotasEstructuradas() {
        abrirMenuPersonas();
        click(LNK_NOTAS_ESTRUCTURADAS);
    }

    public void irASeguroAuto() {
        abrirMenuPersonas();
        click(LNK_SEGURO_AUTO);
    }

    public void irASeguroVida() {
        abrirMenuPersonas();
        click(LNK_SEGURO_VIDA);
    }

    public void irASeguroHogar() {
        abrirMenuPersonas();
        click(LNK_SEGURO_HOGAR);
    }

    public void irASeguroAhorro() {
        abrirMenuPersonas();
        click(LNK_SEGURO_AHORRO);
    }

    public void irASeguroGastosMedicos() {
        abrirMenuPersonas();
        click(LNK_SEGURO_GASTOS_MEDICOS);
    }

    public void irASeguroPertenencias() {
        abrirMenuPersonas();
        click(LNK_SEGURO_PERTENENCIAS);
    }

    public void irASuperlinea() {
        abrirMenuPersonas();
        click(LNK_SUPERLINEA);
    }

    public void irASucursales() {
        abrirMenuPersonas();
        click(LNK_SUCURSALES);
    }

    public void irACajeros() {
        abrirMenuPersonas();
        click(LNK_CAJEROS);
    }

    public void irACanalesAlternos() {
        abrirMenuPersonas();
        click(LNK_CANALES_ALTERNOS);
    }

    public void irACentroAyuda() {
        abrirMenuPersonas();
        click(LNK_CENTRO_AYUDA);
    }

    public void irACentroSeguridad() {
        abrirMenuPersonas();
        click(LNK_CENTRO_SEGURIDAD);
    }

    public void irATutoriales() {
        abrirMenuPersonas();
        click(LNK_TUTORIALES);
    }

    public void irATerminosCondiciones() {
        abrirMenuPersonas();
        click(LNK_TERMINOS_CONDICIONES);
    }

    public void irARegulacion() {
        abrirMenuPersonas();
        click(LNK_REGULACION);
    }

    public void irASelect() {
        abrirMenuPersonas();
        click(LNK_SELECT);
    }

    public void irAPromociones() {
        abrirMenuPersonas();
        click(LNK_PROMOCIONES);
    }

    public void irAUniqueRewards() {
        abrirMenuPersonas();
        click(LNK_UNIQUE_REWARDS);
    }

    public void irAColectivos() {
        abrirMenuPersonas();
        click(LNK_COLECTIVOS);
    }

    public void irAMundoHogar() {
        abrirMenuPersonas();
        click(LNK_MUNDO_HOGAR);
    }

    public void irACashback() {
        abrirMenuPersonas();
        click(LNK_CASHBACK);
    }

    public void irAEmpresasYGobierno() {
        abrirMenuEmpresas();
        click(LNK_EMPRESAS_GOBIERNO);
    }

    public void irAMultinacionales() {
        abrirMenuEmpresas();
        click(LNK_MULTINACIONALES);
    }

    public void irASantanderPyme() {
        abrirMenuPymes();
        click(LNK_SANTANDER_PYME);
    }

    public void irADivisasCoberturas() {
        abrirMenuPymes();
        click(LNK_DIVISAS_COBERTURAS);
    }

    public void irAPymeCuentas() {
        abrirMenuPymes();
        click(LNK_PYME_CUENTAS);
    }

    public void irANegocioInternacional() {
        abrirMenuPymes();
        click(LNK_NEGOCIO_INTERNACIONAL);
    }

    public void irAPaquetesPymes() {
        abrirMenuPymes();
        click(LNK_PAQUETES_PYMES);
    }

    public void irAPymeCreditos() {
        abrirMenuPymes();
        click(LNK_PYME_CREDITOS);
    }

    public void irAPymeSeguros() {
        abrirMenuPymes();
        click(LNK_PYME_SEGUROS);
    }

    public void irALianzas() {
        abrirMenuPymes();
        click(LNK_ALIANZAS);
    }

    public void irANegocioTransaccional() {
        abrirMenuPymes();
        click(LNK_NEGOCIO_TRANSACCIONAL);
    }

    public void irAEcosistemaFinanciero() {
        abrirMenuPymes();
        click(LNK_ECOSISTEMA_FINANCIERO);
    }

    public void irAPymeInversiones() {
        abrirMenuPymes();
        click(LNK_PYME_INVERSIONES);
    }

    public void irABancaPrivadaHome() {
        click(LNK_BANCA_PRIVADA_LINK);
    }

    public void irAFundacionSantander() {
        abrirMenuAcerca();
        click(LNK_FUNDACION_SANTANDER);
    }

    public void irABlog() {
        abrirMenuAcerca();
        click(LNK_BLOG);
    }

    public void irASostenibilidad() {
        abrirMenuAcerca();
        click(LNK_SOSTENIBILIDAD);
    }

    public void irAEducacionFinanciera() {
        abrirMenuAcerca();
        click(LNK_EDUCACION_FINANCIERA);
    }

    public void irAInversionistas() {
        abrirMenuAcerca();
        click(LNK_INVERSIONISTAS);
    }

    public void irASalaComunicacion() {
        abrirMenuAcerca();
        click(LNK_SALA_COMUNICACION);
    }

    public void irABolsaTrabajo() {
        abrirMenuAcerca();
        click(LNK_BOLSA_TRABAJO);
    }
}
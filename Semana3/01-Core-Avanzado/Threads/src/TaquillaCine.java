import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TaquillaCine {
    // Esta variable es la que fallará porque es un número normal.
    // Si varios hilos o cajeros cómo tmabién se le conocen intentan sumarle al mismo tiempo, se van a estar estorbando unos a otros.
    private static int boletosSinProteccion = 0;

    // Esta variable es especial o mejor dicho es el AtomicInteger.
    // Es la que le dice a los hilos a tener un orden por así decirlo y sumar de uno en uno para no perder la cuenta.
    private static AtomicInteger boletosProtegidos = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Abriendo la taquilla del cine...");

        // Contratamos a 5 cajeros para que atiendan al mismo tiempo que se le conoce también como pool de 5 hilos
        ExecutorService cajeros = Executors.newFixedThreadPool(5);

        // Llegan 10,000 personas a comprar boletos de golpe
        for (int i = 0; i < 10000; i++) {
            cajeros.submit(() -> {
                // Los cajeros o hilos intentan sumar en la cuenta sin protección aquí es donde se desordenan y empieza la pérdidas de ventas.
                boletosSinProteccion++;

                // En este los cajeros o hilos suman en la cuenta protegida aquí si llevan un orden por eso siempre darán un buen resultado.
                boletosProtegidos.incrementAndGet();
            });
        }

        // Aquí decimos que ya no recibiremos más clientes (shutdown) y esperamos a que los cajeros terminen su fila (await)
        cajeros.shutdown();
        cajeros.awaitTermination(1, TimeUnit.MINUTES);

        // Revisamos el corte de caja al final del día
        System.out.println("\nCorte de caja - Esperábamos vender 10000 boletos. Aquí se muestran los Resultados:");
        System.out.println("Cuenta SIN protección o sin orden (int normal): " + boletosSinProteccion + " <- Faltan boletos porque los hilos chocan");
        System.out.println("Cuenta PROTEGIDA o con un orden (AtomicInteger): " + boletosProtegidos.get() + " <- Aquí como los hilos llevan un orden la cuenta siempre será exacta");
    }
}

public class GestorDeCobranza {

    public void intentarLiquidacionMaliciosa(CreditoCorporativo c) {
        System.out.println("\n[Gestor] Intentando alteración maliciosa...");
        System.out.println("[INFO] No se puede compilar 'c.saldoPendiente = 0' debido a que el atributo es privado.");

        System.out.println("[Gestor] Intentando inyectar un abono negativo (-500)...");
        c.abonarCapital(-500); 
    }

    public void aplicarAlivioFinanciero(CreditoCorporativo c) {
        System.out.println("\n[Gestor] Aplicando alivio financiero legítimo del 50%...");
        double descuento = c.getSaldoPendiente() * 0.50;
        c.abonarCapital(descuento);
    }
}
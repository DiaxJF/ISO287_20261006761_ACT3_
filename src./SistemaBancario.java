
public class SistemaBancario {

    public static void main(String[] args) {
        System.out.println("=== INICIO DE LA SIMULACIÓN BANCARIA ===\n");

        // 1. Instanciación usando el Constructor 1 (Estándar)
        CreditoCorporativo miCredito = new CreditoCorporativo("CORP-99", 10000, 5);
        System.out.println("Crédito creado: ID=" + miCredito.getId() + " | Monto=$" + miCredito.getMontoPrestado() + " | Tasa=" + miCredito.getTasaInteres() + "%");
        System.out.println("Saldo Inicial: $" + miCredito.getSaldoPendiente() + "\n");

        // 2. Simulación de Tiempo: Ciclo de capitalización de 5 periodos
        System.out.println("--- Iniciando ciclo de capitalización (5 periodos) ---");
        for (int i = 1; i <= 5; i++) {
            System.out.print("Periodo " + i + " -> ");
            miCredito.capitalizarIntereses();
        }

}
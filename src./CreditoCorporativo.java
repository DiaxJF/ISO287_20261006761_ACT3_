public class CreditoCorporativo {
    private final String id;
    private double montoPrestado;
    private double saldoPendiente;
    private double tasaInteres;

    public CreditoCorporativo(String id, double montoPrestado, double tasaInteres) {
        this.id = id;
        this.montoPrestado = montoPrestado;
        this.tasaInteres = tasaInteres;
        this.saldoPendiente = montoPrestado;
    }

    public CreditoCorporativo(String id, double montoPrestado, double tasaInteres, double saldoPendienteInicial) {
        this.id = id;
        this.montoPrestado = montoPrestado;
        this.tasaInteres = tasaInteres;
        if (saldoPendienteInicial >= 0) {
            this.saldoPendiente = saldoPendienteInicial;
        } else {
            this.saldoPendiente = 0;
            System.out.println("Alerta: Saldo inicial negativo no permitido. Asignado 0.");
        }
    }

    public java.lang.String getId() {
        return id;
    }

    public double getMontoPrestado() {
        return montoPrestado;
    }

    public double getSaldoPendiente() {
        return saldoPendiente;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public boolean isEsRiesgoso() {
        return this.saldoPendiente > (this.montoPrestado * 1.20);
    }

    public void abonarCapital(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("Operación rechazada: La cantidad a abonar debe ser positiva.");
            return;
        }
        
        if (this.saldoPendiente - cantidad < 0) {
            System.out.println("Operación rechazada: El abono excede el saldo pendiente.");
            return;
        }

        this.saldoPendiente -= cantidad;
        System.out.println("Abono exitoso de $" + cantidad + ". Nuevo saldo: $" + this.saldoPendiente);
    }

    public void capitalizarIntereses() {
        double interesCalculado = this.saldoPendiente * (this.tasaInteres / 100);
        this.saldoPendiente += interesCalculado;
        
        System.out.println("Intereses capitalizados: +$" + interesCalculado + " | Saldo: $" + this.saldoPendiente);

        if (this.isEsRiesgoso()) {
            System.out.println(" ALERTA DE SEGURIDAD: El crédito " + this.id + " ha superado el 120% de su capital original y ahora es RIESGOSO.");
        }
    }
}
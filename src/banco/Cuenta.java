package banco;

import javax.swing.JOptionPane;

// Definición de la clase Cuenta.
class Cuenta {
    // Variable de instancia privada para almacenar el número de cuenta.
    private String nodeCuenta;
    
    // Variable de instancia privada para almacenar el saldo de la cuenta.
    private double saldo = 0.0;
    
    // Variable de instancia privada para almacenar el tipo de cuenta (ej., corriente, ahorro).
    private String tipoDeCuenta;
    
    // Variable de instancia privada para almacenar el historial de movimientos. Se inicializa con un tamaño máximo de 10 movimientos.
    private Movimiento[] historialMovimientos = new Movimiento[10];
    
    // Variable de instancia privada para llevar el conteo de movimientos actuales.
    private int numeroMovimientos = 0;

    // Método público para obtener el valor del número de cuenta.
    public String getNodeCuenta() {
        return nodeCuenta;
    }

    // Método público para establecer un valor al número de cuenta.
    public void setNodeCuenta(String nodeCuenta) {
        this.nodeCuenta = nodeCuenta;
    }

    // Método público para obtener el saldo de la cuenta.
    public double getSaldo() {
        return saldo;
    }

    // Método público para establecer un valor al saldo de la cuenta.
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Método público para obtener el tipo de cuenta.
    public String getTipodeCuenta() {
        return tipoDeCuenta;
    }

    // Método público para establecer un valor al tipo de cuenta.
    public void setTipodeCuenta(String tipoDeCuenta) {
        this.tipoDeCuenta = tipoDeCuenta;
    }

    // Método público para agregar un movimiento al historial. Actualiza el saldo basado en el monto del movimiento.
    public void agregarMovimiento(Movimiento movimiento) {
        if (numeroMovimientos < historialMovimientos.length) {
            historialMovimientos[numeroMovimientos] = movimiento;
            numeroMovimientos++;
            saldo -= movimiento.getMonto(); // Actualiza el saldo basado en el monto del movimiento
        } else {
            // Muestra un mensaje de alerta si se ha alcanzado el límite de movimientos.
            JOptionPane.showMessageDialog(null, "Límite de movimientos alcanzado.");
        }
    }

    // Método público para mostrar el historial de movimientos en un cuadro de diálogo.
    public void mostrarHistorialMovimientos() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numeroMovimientos; i++) {
            sb.append(historialMovimientos[i].toString()).append("\n");
        }
        if (numeroMovimientos>0)
            // Muestra el historial de movimientos en un cuadro de diálogo.
            JOptionPane.showMessageDialog(null, sb.toString());
        else 
            JOptionPane.showMessageDialog(null, "No hay movimientos aun");

    }

    // Método público para proporcionar una representación en cadena de la cuenta.
    public String toString() {
        return "Cuenta: " + nodeCuenta + " | Tipo: " + tipoDeCuenta + " | Saldo: " + saldo;
    }
}
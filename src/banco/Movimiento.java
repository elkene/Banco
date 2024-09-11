package banco;

import java.util.Date;
// Definición de la clase abstracta Movimiento. Una clase abstracta no se puede instanciar directamente y 
//puede contener métodos abstractos que deben ser implementados por las subclases.
public abstract class Movimiento {
    // Variable de instancia privada para almacenar una referencia única para el movimiento.
    private String referencia;
    
    // Variable de instancia privada para almacenar el monto del movimiento.
    private double monto;
    
    // Variable de instancia privada para almacenar la fecha del movimiento.
    private Date fecha;

    // Método público para obtener el valor de la referencia.
    public String getReferencia() {
        return referencia;
    }

    // Método público para establecer un valor a la referencia.
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    // Método público para obtener el valor del monto.
    public double getMonto() {
        return monto;
    }

    // Método público para establecer un valor al monto.
    public void setMonto(double monto) {
        this.monto = monto;
    }

    // Método público para obtener la fecha del movimiento.
    public Date getFecha() {
        return fecha;
    }

    // Método público para establecer una fecha al movimiento.
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    // Método abstracto que debe ser implementado por las subclases. Define cómo se debe representar el movimiento en forma de cadena.
    public abstract String toString();
}

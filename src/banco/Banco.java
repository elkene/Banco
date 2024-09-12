package banco;
import javax.swing.JOptionPane;

class Banco {
    // Variable de instancia privada para almacenar una lista de clientes. Se inicializa con un tamaño máximo de 10 clientes.
    private Cliente[] listaDeClientes = new Cliente[10];
    
    // Variable de instancia privada para llevar el conteo de clientes actualmente registrados.
    private int numeroClientes = 0;

    // Método para agregar un cliente a la lista del banco.
    public void agregarCliente(Cliente cliente) {
        if (numeroClientes < listaDeClientes.length) {
            listaDeClientes[numeroClientes] = cliente;
            numeroClientes++;
        } else {
            // Muestra un mensaje de alerta si se ha alcanzado el límite de clientes.
            JOptionPane.showMessageDialog(null, "Límite de clientes alcanzado.");
        }
    }

    // Método para obtener un cliente por su nombre.
    public Cliente getCliente(String nombre) {
        for (int i = 0; i < numeroClientes; i++) {
            if (listaDeClientes[i].getNombre().equals(nombre)) {
                return listaDeClientes[i];
            }
        }
        return null; // Retorna null si no se encuentra el cliente.
    }

    // Método para obtener un cliente por su índice en la lista.
    public Cliente getCliente(int index) {
        if (index < numeroClientes) {
            return listaDeClientes[index];
        }
        return null; // Retorna null si el índice está fuera del rango.
    }

    // Método para obtener el número de clientes registrados.
    public int getNumeroClientes() {
        return numeroClientes;
    }

 
}
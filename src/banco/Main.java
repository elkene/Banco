package banco;
import javax.swing.JOptionPane;
import java.util.Date;

// Definición de la clase Main. Contiene el punto de entrada principal para la aplicación.
public class Main {
    public static void main(String[] args) {
        Main programa = new Main();
        programa.iniciarPrograma();
    }

    // Método para iniciar el programa, creando clientes, cuentas y configurando el banco.
    public void iniciarPrograma() {
        // Crear algunos clientes de ejemplo.
        Cliente clienteEjemplo = new Cliente();
        clienteEjemplo.setNombre("Juan Perez");
        clienteEjemplo.setCurp("JUAP800101HDFRLL00");
        clienteEjemplo.setCelular("5551234567");
        // Crear algunas cuentas de ejemplo.
        Cuenta cuentaEjemplo = new Cuenta();
        cuentaEjemplo.setNodeCuenta("12345");
        cuentaEjemplo.setTipodeCuenta("Ahorro");
        cuentaEjemplo.setSaldo(5000);


        Cliente clienteEjemplo2 = new Cliente();
        clienteEjemplo2.setNombre("Kenneth Armenta");
        clienteEjemplo2.setCurp("AEIK030618HSLRBNA9");
        clienteEjemplo2.setCelular("6731148022");

        Cuenta cuentaEjemplo2 = new Cuenta();
        cuentaEjemplo2.setNodeCuenta("1426");
        cuentaEjemplo2.setTipodeCuenta("Ahorro");
        cuentaEjemplo2.setSaldo(100000);
        
        // Agregar cuentas a los clientes.
        clienteEjemplo.agregarCuenta(cuentaEjemplo);
        clienteEjemplo2.agregarCuenta(cuentaEjemplo2);

        // Crear un objeto Banco y agregar clientes.
        Banco banco = new Banco();
        banco.agregarCliente(clienteEjemplo);
        banco.agregarCliente(clienteEjemplo2);

        // Iniciar el menú de opciones del programa.
        menu(banco);
    }

    // Método para mostrar el menú y manejar la entrada del usuario.
    private void menu(Banco banco) {
        int opcion = 0;
        while (opcion != 6) {
            // Mostrar el menú y leer la opción del usuario.
            opcion = Integer.parseInt(JOptionPane.showInputDialog("MENU \n" +
                "1. Crear Cliente \n" +
                "2. Crear Cuenta para Cliente \n" +
                "3. Hacer Movimiento \n" +
                "4. Mostrar Clientes \n" +
                "5. Mostrar Historial de Movimientos \n" +
                "6. Salir \n" +
                "Ingrese una opción:"));

            // Manejar la opción seleccionada por el usuario.
            switch (opcion) {
                case 1:
                    crearCliente(banco);
                    break;
                case 2:
                    crearCuenta(banco);
                    break;
                case 3:
                    hacerMovimiento(banco);
                    break;
                case 4:
                    mostrarClientes(banco);
                    break;
                case 5:
                    mostrarHistorialMovimientos(banco);
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Ingrese una opción válida...");
                    break;
            }
        }
    }

    // Método para crear un nuevo cliente y agregarlo al banco.
    private void crearCliente(Banco banco) {
        Cliente cliente = new Cliente();
        cliente.setNombre(JOptionPane.showInputDialog("Ingrese el nombre del cliente:"));
        cliente.setCurp(JOptionPane.showInputDialog("Ingrese el CURP del cliente:"));
        cliente.setCelular(JOptionPane.showInputDialog("Ingrese el número de celular del cliente:"));
        banco.agregarCliente(cliente);
        JOptionPane.showMessageDialog(null, "Cliente creado con éxito");
    }

    // Método para crear una nueva cuenta para un cliente existente.
    private void crearCuenta(Banco banco) {
        String nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente para agregar una cuenta:");
        Cliente cliente = banco.getCliente(nombreCliente);

        if (cliente != null) {
            Cuenta cuenta = new Cuenta();
            cuenta.setNodeCuenta(JOptionPane.showInputDialog("Ingrese el número de cuenta:"));
            cuenta.setTipodeCuenta(JOptionPane.showInputDialog("Ingrese el tipo de cuenta (Ahorro/Corriente):"));
            cliente.agregarCuenta(cuenta);
            JOptionPane.showMessageDialog(null, "Cuenta creada con éxito");
        } else {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
        }
    }

    // Método para mostrar el historial de movimientos de una cuenta específica de un cliente.
    private void mostrarHistorialMovimientos(Banco banco) {
        String nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
        Cliente cliente = banco.getCliente(nombreCliente);

        if (cliente != null) {
            String nodoCuenta = JOptionPane.showInputDialog("Ingrese el número de cuenta:");
            Cuenta cuenta = cliente.getCuenta(nodoCuenta);

            if (cuenta != null) {
                cuenta.mostrarHistorialMovimientos();
            } else {
                JOptionPane.showMessageDialog(null, "Cuenta no encontrada.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
        }
    }

    // Método para realizar un movimiento en una cuenta específica de un cliente.
    private void hacerMovimiento(Banco banco) {
        String nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
        Cliente cliente = banco.getCliente(nombreCliente);

        if (cliente != null) {
            String nodoCuenta = JOptionPane.showInputDialog("Ingrese el número de cuenta:");
            Cuenta cuenta = cliente.getCuenta(nodoCuenta);

            if (cuenta != null) {
                int tipoMovimiento = Integer.parseInt(JOptionPane.showInputDialog("Seleccione tipo de movimiento: \n" +
                    "1. Transferencia \n" +
                    "2. Transacción \n" +
                    "3. Pago"));

                Movimiento movimiento = null;
                switch (tipoMovimiento) {
                    case 1:
                        Transferencia transferencia = new Transferencia();
                        transferencia.setDestino(JOptionPane.showInputDialog("Ingrese cuenta destino:"));
                        movimiento = transferencia;
                        break;
                    case 2:
                        Transaccion transaccion = new Transaccion();
                        transaccion.setTipo(JOptionPane.showInputDialog("Ingrese el tipo de transacción (Depósito/Retiro):"));
                        movimiento = transaccion;
                        break;
                    case 3:
                        Pago pago = new Pago();
                        pago.setServicios(JOptionPane.showInputDialog("Ingrese el servicio a pagar:"));
                        movimiento = pago;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción inválida.");
                        return;
                }

                movimiento.setReferencia(JOptionPane.showInputDialog("Ingrese la referencia:"));
                movimiento.setFecha(new Date());
                movimiento.setMonto(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto:")));
                cuenta.agregarMovimiento(movimiento);
                JOptionPane.showMessageDialog(null, "Movimiento realizado con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "Cuenta no encontrada.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
        }
    }

    // Método para mostrar la lista de clientes del banco.
    private void mostrarClientes(Banco banco) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < banco.getNumeroClientes(); i++) {
            Cliente cliente = banco.getCliente(i);
            sb.append(cliente.toString()).append("\n");
        }

        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(null, sb.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No hay clientes registrados.");
        }
    }
}

// Definición de la clase Banco. Maneja una lista de clientes.
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

    // public static int ingresarvalor(String mensaje){
    //     int valor=0;
    //     boolean invalido=true;

    //     while(invalido);
    //         try{
    //             valor=Integer.parseInt(JOptionPane.showInputDialog(mensaje));

    //         }catch(NumberFormatException e){
    //             JOptionPane.showMessageDialog(null, "Valor invalido");
    //     }
    //     return valor;
    // }

}
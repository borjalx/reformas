package reformas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Reformas {

    static ArrayList<Cliente> clientes = new ArrayList<>();
    static int n = 0;

    public static void main(String[] args) {

        int op = 0;

        do {

            mostrarMenu();
            op = pedirNum("Elije una opción = ");

            switch (op) {
                case 1://Alta cliente
                    altaCliente();
                    break;
                case 2://Nuevo presupuesto
                    nuevoPresupuesto();
                    break;
                case 3://Presupuestos pendientes
                    presupuestosPen();
                    break;
                case 4://Listado presupuestos cliente
                    presupuestosCliente();
                    break;
                case 5://Listado presupuestos rechazados
                    presupuestosRechazados();
                    break;
                case 6://Listado clientes con presupuesto
                    clientesPresupuesto();
                    break;
                case 7://Cambiar estado presupuesto
                    cambiarEstado();
                    break;
                case 8://Salir
                    break;
            }

        } while (op > 0 && op < 9);

        System.out.println("Hasta la próxima!");

    }

    public static void mostrarMenu() {
        System.out.println("--------MENÚ-------");
        System.out.println("- 1. Alta cliente");
        System.out.println("- 2. Nuevo presupuesto");
        System.out.println("- 3. Presupuesto pendientes");
        System.out.println("- 4. Listado de presupuestos de un cliente determinado");
        System.out.println("- 5. Listado de presupuestos rechazados");
        System.out.println("- 6. Listado de clientes con presupuestos");
        System.out.println("- 7. Cambiar estado de un presupuesto");
        System.out.println("- 8. Salir");
        System.out.println("--------MENÚ-------");
    }

    public static int pedirNum(String mensaje) {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        boolean error = true;
        int res = 0;
        do {
            System.out.println(mensaje);
            try {
                res = Integer.parseInt(buffer.readLine());
                if (res > 0) {
                    error = false;
                }

            } catch (IOException io) {
                System.out.println(io);
            } catch (NumberFormatException nm) {
                System.out.println(nm);
            }

        } while (error);

        return res;
    }

    public static int pedirEstado() {
        int estado = 0;
        boolean error = true;
        do {
            estado = pedirNum("Estado (1.Pendiente/2.Aceptado/3.Rechazado) = ");

        } while (error);
        estado = pedirNum("Estado del presupuesto = ");
        return estado;
    }

    public static String pedirTexto(String mensaje) {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        boolean error = true;
        String res = "";
        do {
            System.out.println(mensaje);
            try {
                res = buffer.readLine();
                if (res.equals("")) {
                    System.out.println("Dale chicha a esto");
                } else {
                    error = false;
                }
            } catch (Exception e) {
                System.out.println("Error de entrada y/o salida de datos");
            }
        } while (error);
        return res;
    }

    public static boolean esFiel() {
        boolean res = true;
        int n;
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        try {
            boolean error = true;

            do {

                n = pedirNum("Es un cliente VIP/fiel (1.Sí/2.No) = ");
                if (n != 1 || n != 2) {
                    System.out.println("(1.Sí/2.No) =");
                } else {
                    if (n == 1) {
                        System.out.println("Es cliente VIP");
                        res = true;

                    } else if (n == 2) {
                        System.out.println("NO es cliente VIP");
                        res = false;
                    }
                    error = false;
                }

            } while (error);

        } catch (Exception e) {
        }
        return res;
    }

    public static int pedirTel() {
        int res = 0;
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        boolean error = true;
        int contador = 0;
        do {
            try {
                res = pedirNum("Número de teléfono = ");
            } catch (Exception e) {
            }
            //Si es un número de 9 dígitos
            if (res > 99999999 && res < 1000000000) {
                //Comprobamos que no está repetido
                for (Cliente clients : clientes) {
                    if (res == clients.getTelefono()) {
                        contador++;
                    }
                }

                if (contador > 0) {
                    System.out.println("Número repetido");
                } else {
                    error = false;
                }
            }

        } while (error);

        return res;
    }

    public static void altaCliente() {
        // Se solicitan los datos
        // nos aseguramos que son correctos
        // y que no se repitan los números de tél.

        String nom = pedirTexto("Nombre del cliente = ");
        String cognom = pedirTexto("Apellido del cliente = ");
        boolean fidel = esFiel();
        int telefon = pedirTel();

        Cliente nClient = new Cliente(nom, cognom, telefon, fidel);
        clientes.add(nClient);

    }

    public static void nuevoPresupuesto() {
        Cliente c = new Cliente();
        int tel = pedirTel();
        boolean encontrado = false;
        Presupuesto p;
        for (Cliente clients : clientes) {
            if (tel == clients.getTelefono()) {
                System.out.println("Cliente encontrado");
                //después de encontrar al cliente
                //le pedimos la información del presupuesto
                n++;
                int nPresupuesto = n;
                String concepto = pedirTexto("Concepto = ");
                double preu = pedirNum("Precio = ");
                double iva = (preu * (0.2)) + preu;
                double preuNet;
                if (clients.isFidelidad()) {
                    preuNet = iva - (iva * 0.5);
                } else {
                    preuNet = iva;
                }
                int estat = pedirEstado();

                p = new Presupuesto(nPresupuesto, concepto, preuNet, estat);
                clients.presupuestos.add(p);

            } else {
                System.out.println("Cliente no encontrado");
            }
        }
    }

    public static void presupuestosPen() {
        String presPen = "";
        for (Cliente clients : clientes) {
            for (Presupuesto pres : clients.presupuestos) {
                if (pres.getEstado() == 1) {
                    System.out.println("Cliente => " + clients.getNombre() + " " + clients.getApellido()
                            + " / número presupuesto = " + pres.getNumeroPresupuesto()
                            + " / concepto = " + pres.getConcepto());
                }
            }
        }
    }

    public static void mostrarClientes() {

        if (clientes.isEmpty()) {
            System.out.println("No hay clientes creados");
        } else {
            for (Cliente clients : clientes) {
                clients.toString();
            }
        }

    }

    public static void presupuestosCliente() {
        mostrarClientes();

        int nt = pedirTel();

        for (Cliente clients : clientes) {
            if (nt == clients.getTelefono()) {
                String nom = clients.getNombre();
                String cognom = clients.getApellido();

                System.out.println("Cliente " + cognom + " , " + nom);
                for (Presupuesto pres : clients.getPresupuestos()) {
                    pres.toString();
                }
            } else {
                System.out.println("Cliente no encontrado");
            }
        }

    }

    public static void presupuestosRechazados() {
        String presPen = "";
        for (Cliente clients : clientes) {
            for (Presupuesto pres : clients.presupuestos) {
                if (pres.getEstado() == 3) {
                    System.out.println("Cliente => " + clients.getNombre() + " " + clients.getApellido()
                            + " / número presupuesto = " + pres.getNumeroPresupuesto()
                            + " / concepto = " + pres.getConcepto());
                }
            }
        }
    }

    public static void clientesPresupuesto() {
        for (Cliente clients : clientes) {
            clients.toString();
            int nAceptados = 0;
            for (Presupuesto pres : clients.presupuestos) {
                if (pres.getEstado() == 2) {
                    nAceptados++;
                }
            }
            System.out.println("Nº presupuestos aceptados = " + nAceptados);
        }
    }

    public static void mostrarPresupuestos() {
        for (Cliente cliente : clientes) {
            cliente.presupuestos.toString();
        }
    }

    public static void cambiarEstado() {
        mostrarPresupuestos();
        // Pedimos número presupuesto
        // Si no existe se avisa y se sale
        // Si existe se pide el nuevo estado y se modifica        

        int np = pedirNum("Número de presupuesto");
        int l = 0;
        for (Cliente cliente : clientes) {
            l = cliente.presupuestos.size();
        }

        if (np > l) {
            System.out.println("Número erroneo");
        }else{
            for (Cliente cliente : clientes) {
                for (Presupuesto pres : cliente.presupuestos) {
                    if(np == pres.getNumeroPresupuesto()){
                        int est = pedirEstado();
                        pres.setEstado(est);
                    }
                }
            }
        }

    }

}

package logica;

import entidades.*;
import datos.*;
import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author deerfox@debian
 */
public class ClienteBL {

    private static ArrayList<Cliente> lista = new ArrayList<>();

    public static int insertarCliente(String codigo, String paterno, String materno,
            String nombre, String dni, String ciudad, String direccion,
            String telefono, String email) {
        if (codigo.trim().length() == 5 && paterno.trim().length() > 0 && paterno.trim().length() <= 25
                && materno.trim().length() > 0 && materno.trim().length() <= 25
                && nombre.trim().length() > 0 && nombre.trim().length() <= 30
                && dni.trim().length() == 8
                && ciudad.trim().length() > 0 && ciudad.trim().length() <= 30
                && direccion.trim().length() > 0 && direccion.trim().length() <= 50
                && telefono.trim().length() > 0 && telefono.trim().length() <= 20
                && email.trim().length() > 0 && email.trim().length() <= 50) {
            if (buscarCliente(codigo) == null) {
                Cliente cliente = new Cliente(codigo, paterno, materno, nombre,
                        dni, ciudad, direccion, telefono, email);
                String mensaje = ClienteDAL.insertarCliente(cliente);
                if (mensaje == null) {
                    showMessageDialog(null, "Se ha registrado el cliente", "Operación exitosa", 1);
                    return 0;
                } else {
                    showMessageDialog(null, mensaje, "Error en la base de datos", 0);
                    return 1;
                }
            } else {
                showMessageDialog(null, "Un cliente con ese código ya está registrado", "Error", 0);
                return 2;
            }
        } else {
            showMessageDialog(null, "Datos no válidos", "Error", 0);
            return 3;
        }
    }

    public static Cliente buscarCliente(String codigo) {
        if (codigo.trim().length() == 5) {
            return ClienteDAL.buscarCliente(codigo);
        } else {
            return null;
        }
    }

    public static ArrayList<Cliente> listarCliente() {
        return ClienteDAL.listarCliente();
    }

    public static String actualizarCliente(String codigo, String paterno, String materno,
            String nombre, String dni, String ciudad, String direccion,
            String telefono, String email) {
        String mensaje;
        if (paterno.trim().length() > 0 && paterno.trim().length() <= 25
                && materno.trim().length() > 0 && materno.trim().length() <= 25
                && nombre.trim().length() > 0 && nombre.trim().length() <= 30
                && dni.trim().length() == 8
                && ciudad.trim().length() > 0 && ciudad.trim().length() <= 30
                && direccion.trim().length() > 0 && direccion.trim().length() <= 50
                && telefono.trim().length() > 0 && telefono.trim().length() <= 20
                && email.trim().length() > 0 && email.trim().length() <= 50) {
            Cliente cliente = new Cliente(codigo, paterno, materno, nombre,
                    dni, ciudad, direccion, telefono, email);
            mensaje = ClienteDAL.actualizarCliente(cliente);
            if (mensaje == null) {
                mensaje = "Datos actualizados";
            }
        } else {
            mensaje = "Datos inválidos. Revíselos e inténtelo nuevamente.";
        }
        return mensaje;
    }

    public static ArrayList<Cliente> obtenerCliente(String codigo) {
        if (codigo.trim().length() == 2) {
            lista = ClienteDAL.obtenerCliente(codigo);
            if (lista.size() > 0) {
                return lista;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}

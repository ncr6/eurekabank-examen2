package logica;

import entidades.*;
import datos.*;
import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author deerfox@debian
 */
public class EmpleadoBL {

    private static ArrayList<Empleado> lista = new ArrayList<>();

    public static int insertarEmpleado(String codigo, String paterno, String materno,
            String nombre, String ciudad, String direccion, String usuario, String clave,
            String sucucodigo) {
        if (codigo.trim().length() == 4 && paterno.trim().length() > 0 && paterno.trim().length() <= 25
                && materno.trim().length() > 0 && materno.trim().length() <= 25
                && nombre.trim().length() > 0 && nombre.trim().length() <= 30
                && ciudad.trim().length() > 0 && ciudad.trim().length() <= 30
                && direccion.trim().length() > 0 && direccion.trim().length() <= 50
                && usuario.trim().length() > 0 && usuario.trim().length() <= 15
                && clave.trim().length() > 0 && clave.trim().length() <= 15
                && clave.trim().length() == 3) {
            if (buscarEmpleado(codigo) == null) {
                Empleado empleado = new Empleado(codigo, paterno, materno, nombre,
                        ciudad, direccion, usuario, clave, sucucodigo);
                String mensaje = EmpleadoDAL.insertarEmpleado(empleado);
                if (mensaje == null) {
                    showMessageDialog(null, "Se ha registrado el empleado", "Operación exitosa", 1);
                    return 0;
                } else {
                    showMessageDialog(null, mensaje, "Error en la base de datos", 0);
                    return 1;
                }
            } else {
                showMessageDialog(null, "Un empleado con ese código ya está registrado", "Error", 0);
                return 2;
            }
        } else {
            showMessageDialog(null, "Datos no válidos", "Error", 0);
            return 3;
        }
    }

    public static Empleado buscarEmpleado(String codigo) {
        if (codigo.trim().length() == 4) {
            return EmpleadoDAL.buscarEmpleado(codigo);
        } else {
            return null;
        }
    }

    public static ArrayList<Empleado> listarEmpleado() {
        return EmpleadoDAL.listarEmpleado();
    }

    public static String actualizarEmpleado(String codigo, String paterno, String materno,
            String nombre, String ciudad, String direccion, String usuario, String clave,
            String sucucodigo) {
        String mensaje;
        if (paterno.trim().length() > 0 && paterno.trim().length() <= 25
                && materno.trim().length() > 0 && materno.trim().length() <= 25
                && nombre.trim().length() > 0 && nombre.trim().length() <= 30
                && ciudad.trim().length() > 0 && ciudad.trim().length() <= 30
                && direccion.trim().length() > 0 && direccion.trim().length() <= 50
                && usuario.trim().length() > 0 && usuario.trim().length() <= 15
                && clave.trim().length() > 0 && clave.trim().length() <= 15
                && sucucodigo.trim().length() == 3) {
            Empleado empleado = new Empleado(codigo, paterno, materno, nombre,
                    ciudad, direccion, usuario, clave, sucucodigo);
            mensaje = EmpleadoDAL.actualizarEmpleado(empleado);
            if (mensaje == null) {
                mensaje = "Datos actualizados";
            }
        } else {
            mensaje = "Datos inválidos. Revíselos e inténtelo nuevamente.";
        }
        return mensaje;
    }

    public static ArrayList<Empleado> obtenerEmpleado(String codigo) {
        if (codigo.trim().length() == 4) {
            lista = EmpleadoDAL.obtenerEmpleado(codigo);
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

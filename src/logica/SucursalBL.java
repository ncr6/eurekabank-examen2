package logica;

import entidades.*;
import datos.*;
import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author deerfox@debian
 */
public class SucursalBL {

    private static ArrayList<Sucursal> lista = new ArrayList<>();

    public static int insertarSucursal(String codigo, String nombre, String ciudad, String direccion) {
        if (codigo.trim().length() == 3 && nombre.trim().length() > 0 && nombre.trim().length() <= 50
                && ciudad.trim().length() > 0 && ciudad.trim().length() <= 30
                && direccion.trim().length() > 0 && direccion.trim().length() <= 50) {
            if (buscarSucursal(codigo) == null) {
                Sucursal sucursal = new Sucursal(codigo, nombre, ciudad, direccion, 0, 0);
                String mensaje = SucursalDAL.insertarSucursal(sucursal);
                if (mensaje == null) {
                    showMessageDialog(null, "Se ha registrado la sucursal", "Operación exitosa", 1);
                    return 0;
                } else {
                    showMessageDialog(null, mensaje, "Error en la base de datos", 0);
                    return 1;
                }
            } else {
                showMessageDialog(null, "Una sucursal con ese código ya está registrada", "Error", 0);
                return 2;
            }
        } else {
            showMessageDialog(null, "Datos no válidos", "Error", 0);
            return 3;
        }
    }

    public static Sucursal buscarSucursal(String codigo) {
        if (codigo.trim().length() == 3) {
            return SucursalDAL.buscarSucursal(codigo);
        } else {
            return null;
        }
    }

    public static ArrayList<Sucursal> listarSucursal() {
        return SucursalDAL.listarSucursal();
    }

    public static String actualizarSucursal(String codigo, String nombre, String ciudad, String direccion) {
        String mensaje;
        if (nombre.trim().length() > 0 && nombre.trim().length() <= 50
                && ciudad.trim().length() > 0 && ciudad.trim().length() <= 30
                && direccion.trim().length() > 0 && direccion.trim().length() <= 50) {
            Sucursal sucursal = new Sucursal(codigo, nombre, ciudad, direccion, 0, 0);
            mensaje = SucursalDAL.actualizarSucursal(sucursal);
            if (mensaje == null) {
                mensaje = "Datos actualizados";
            }
        } else {
            mensaje = "Datos inválidos. Revíselos e inténtelo nuevamente.";
        }
        return mensaje;
    }

    public static ArrayList<Sucursal> obtenerSucursal(String codigo) {
        if (codigo.trim().length() == 2) {
            lista = SucursalDAL.obtenerSucursal(codigo);
            if (lista.size() > 0) {
                return lista;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
    
    public static ArrayList<String> obtenerSucucodigos() {
        return SucursalDAL.obtenerSucucodigos();
    }
}

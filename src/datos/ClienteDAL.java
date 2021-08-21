package datos;

import entidades.*;
import java.util.*;
import java.sql.*;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author deerfox@debian
 */
public class ClienteDAL {

    private static Connection cn = null;
    private static PreparedStatement ps = null;
    private static Statement st = null;
    private static ResultSet rs = null;

    public static String insertarCliente(Cliente cliente) {
        String mensaje = null;
        try {
            cn = Conexion.realizarConexion();
            String sql = "INSERT INTO cliente VALUES(?,?,?,?,?,?,?,?,?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, cliente.getCodigo());
            ps.setString(2, cliente.getPaterno());
            ps.setString(3, cliente.getMaterno());
            ps.setString(4, cliente.getNombre());
            ps.setString(5, cliente.getDni());
            ps.setString(6, cliente.getCiudad());
            ps.setString(7, cliente.getDireccion());
            ps.setString(8, cliente.getTelefono());
            ps.setString(9, cliente.getEmail());
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            mensaje = ex.getMessage();
        } finally {
            try {
                ps.close();
                cn.close();
            } catch (SQLException ex) {
                mensaje = ex.getMessage();
            }
        }
        return mensaje;
    }

    public static Cliente buscarCliente(String codigo) {
        try {
            cn = Conexion.realizarConexion();
            String sql = "SELECT * FROM cliente WHERE cliecodigo = ?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Cliente(rs.getString("cliecodigo"),
                        rs.getString("cliepaterno"),
                        rs.getString("cliematerno"),
                        rs.getString("clienombre"),
                        rs.getString("cliedni"),
                        rs.getString("clieciudad"),
                        rs.getString("cliedireccion"),
                        rs.getString("clietelefono"),
                        rs.getString("clieemail")
                );
            }
        } catch (ClassNotFoundException | SQLException ex) {
            showMessageDialog(null, ex.getMessage(), "Error", 0);
        } finally {
            try {
                rs.close();
                ps.close();
                cn.close();
            } catch (SQLException ex) {
                showMessageDialog(null, ex.getMessage(), "Error", 0);
            }
        }
        return null;
    }

    public static ArrayList<Cliente> listarCliente() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            cn = Conexion.realizarConexion();
            st = cn.createStatement();
            String sql = "SELECT * FROM cliente";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                clientes.add(new Cliente(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8),
                        rs.getString(9)));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            showMessageDialog(null, ex.getMessage(), "Error", 0);
        } finally {
            try {
                rs.close();
                st.close();
                cn.close();
            } catch (SQLException ex) {
                showMessageDialog(null, ex.getMessage(), "Error", 0);
            }
        }
        return clientes;
    }

    public static String actualizarCliente(Cliente cliente) {
        String mensaje = null;
        try {
            cn = Conexion.realizarConexion();
            String sql = "UPDATE cliente SET cliepaterno = ?, "
                    + "cliematerno = ?,  clienombre = ?, cliedni = ?, "
                    + "clieciudad = ?, cliedireccion = ?, clietelefono = ?, "
                    + "clieemail = ? WHERE cliecodigo = ?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, cliente.getPaterno());
            ps.setString(2, cliente.getMaterno());
            ps.setString(3, cliente.getNombre());
            ps.setString(4, cliente.getDni());
            ps.setString(5, cliente.getCiudad());
            ps.setString(6, cliente.getDireccion());
            ps.setString(7, cliente.getTelefono());
            ps.setString(8, cliente.getEmail());
            ps.setString(9, cliente.getCodigo());
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            mensaje = ex.getMessage();
        } finally {
            try {
                ps.close();
                cn.close();
            } catch (SQLException ex) {
                mensaje = ex.getMessage();
            }
        }
        return mensaje;
    }

    public static ArrayList<Cliente> obtenerCliente(String codigo) {
        ArrayList<Cliente> cliente = new ArrayList<>();
        try {
            cn = Conexion.realizarConexion();
            String sql = "SELECT * FROM cliente WHERE cliecodigo = ?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            while (rs.next()) {
                cliente.add(new Cliente(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8),
                        rs.getString(9)));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            showMessageDialog(null, ex.getMessage(), "Error", 0);
        } finally {
            try {
                rs.close();
                ps.close();
                cn.close();
            } catch (SQLException ex) {
                showMessageDialog(null, ex.getMessage(), "Error", 0);
            }
        }
        return cliente;
    }
}

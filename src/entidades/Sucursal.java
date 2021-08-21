package entidades;

/**
 *
 * @author deerfox@debian
 */

public class Sucursal implements Comparable<Sucursal> {

    private String codigo;
    private String nombre;
    private String ciudad;
    private String direccion;
    private int contcuenta;
    private int emplcont;

    public Sucursal(String codigo, String nombre, String ciudad,
           String direccion, int contcuenta, int emplcont) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.contcuenta = contcuenta;
        this.emplcont = emplcont;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getContcuenta() {
        return contcuenta;
    }

    public void setContcuenta(int contcuenta) {
        this.contcuenta = contcuenta;
    }
    
    public int getEmplcont() {
        return emplcont;
    }

    public void setEmplcont(int emplcont) {
        this.emplcont = emplcont;
    }
    
    @Override
    public int compareTo(Sucursal suc) {
        return this.getCodigo().compareToIgnoreCase(suc.getCodigo());
    }

}

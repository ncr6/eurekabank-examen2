package entidades;

import java.util.Date;

/**
 *
 * @author deerfox@debian
 */
public class Cuenta implements Comparable<Cuenta> {

    private String codigo;
    private String monecodigo;
    private String sucucodigo;
    private String emplcreador;
    private String cliecodigo;
    private float saldo;
    private Date creacion;
    private String estado;
    private int contmov;
    private String clave;

    public Cuenta(String codigo, String monecodigo, String sucucodigo,
           String emplcreador, String cliecodigo, float saldo, Date creacion,
           String estado, int contmov, String clave) {
        this.codigo = codigo;
        this.monecodigo = monecodigo;
        this.sucucodigo = sucucodigo;
        this.emplcreador = emplcreador;
        this.cliecodigo = cliecodigo;
        this.saldo = saldo;
        this.creacion = creacion;
        this.estado = estado;
        this.contmov = contmov;
        this.clave = clave;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMonecodigo() {
        return monecodigo;
    }

    public void setMonecodigo(String monecodigo) {
        this.monecodigo = monecodigo;
    }

    public String getSucucodigo() {
        return sucucodigo;
    }

    public void setSucucodigo(String sucucodigo) {
        this.sucucodigo = sucucodigo;
    }

    public String getEmplcreador() {
        return emplcreador;
    }

    public void setEmplcreador(String emplcreador) {
        this.emplcreador = emplcreador;
    }

    public String getCliecodigo() {
        return cliecodigo;
    }

    public void setCliecodigo(String cliecodigo) {
        this.cliecodigo = cliecodigo;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Date getCreacion() {
        return creacion;
    }

    public void setCreacion(Date creacion) {
        this.creacion = creacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getContmov() {
        return contmov;
    }

    public void setContmov(int contmov) {
        this.contmov = contmov;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public int compareTo(Cuenta c) {
        return Float.compare(this.getSaldo(), c.getSaldo());
    }

}

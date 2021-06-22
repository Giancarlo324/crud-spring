package co.com.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="identificacion")
    private int identificacion;

    @Column(name="contigo_tipo_identificacion")
    private int contigoTipoIdentificacion;

    @Column(name="codigo_estado")
    private int codigoEstado;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public int getContigoTipoIdentificacion() {
        return contigoTipoIdentificacion;
    }

    public void setContigoTipoIdentificacion(int contigoTipoIdentificacion) {
        this.contigoTipoIdentificacion = contigoTipoIdentificacion;
    }

    public int getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(int codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public Persona(int codigo, String nombre, String apellido, Date fechaNacimiento, String username, String password, int identificacion, int contigoTipoIdentificacion, int codigoEstado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.username = username;
        this.password = password;
        this.identificacion = identificacion;
        this.contigoTipoIdentificacion = contigoTipoIdentificacion;
        this.codigoEstado = codigoEstado;
    }

    public Persona() { super(); }
}

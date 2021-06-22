package co.com.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name ="tipo_identificacion")
public class TipoIdentificacion {

    @Id
    private int codigo;

    @Column(name="nombre")
    private String nombre;

    @CreationTimestamp
    @Column(name="fecha_creacion")
    private Timestamp fechaCreacion;

    @Column(name="usuario_creacion")
    private String usuarioCreacion;

    @UpdateTimestamp
    @Column(name="fecha_modificacion", updatable = false)
    private Timestamp fechaModificacion;

    @Column(name="usuario_modificacion")
    private String usuarioModificacion;

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

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public Timestamp getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Timestamp fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public TipoIdentificacion(int codigo, String nombre, Timestamp fechaCreacion, String usuarioCreacion, Timestamp fechaModificacion, String usuarioModificacion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaModificacion = fechaModificacion;
        this.usuarioModificacion = usuarioModificacion;
    }

    public TipoIdentificacion() { super(); }
}

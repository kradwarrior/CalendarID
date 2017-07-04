package co.com.calendarioid.persistence.model;

import java.util.Date;

/**
 * Created by desarrollo on 13/06/2017.
 */

public class Movimiento {

    private Integer id;
    private String descripcion;
    private String color;
    private Integer idCategoria;
    private String tipoMovimiento;
    private Date fecha;
    private String repeticionMensual;
    private Date fechaInicio;
    private Date fechaFin;
    private String diaNotificacion;
    private Date horaNotificacion;
    private Date fechaCreacion;
    private Date fechaModificación;
    private Integer idCartera;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getRepeticionMensual() {
        return repeticionMensual;
    }

    public void setRepeticionMensual(String repeticionMensual) {
        this.repeticionMensual = repeticionMensual;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDiaNotificacion() {
        return diaNotificacion;
    }

    public void setDiaNotificacion(String diaNotificacion) {
        this.diaNotificacion = diaNotificacion;
    }

    public Date getHoraNotificacion() {
        return horaNotificacion;
    }

    public void setHoraNotificacion(Date horaNotificacion) {
        this.horaNotificacion = horaNotificacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificación() {
        return fechaModificación;
    }

    public void setFechaModificación(Date fechaModificación) {
        this.fechaModificación = fechaModificación;
    }

    public Integer getIdCartera() {
        return idCartera;
    }

    public void setIdCartera(Integer idCartera) {
        this.idCartera = idCartera;
    }
}

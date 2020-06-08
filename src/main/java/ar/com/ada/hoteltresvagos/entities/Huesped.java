package ar.com.ada.hoteltresvagos.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.NaturalId;

import ar.com.ada.hoteltresvagos.excepciones.*;

@Entity
@Table(name = "huesped")
public class Huesped {
    @Id
    @Column(name = "huesped_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int huespedId;
    private String nombre;
    @NaturalId // permite hacer una busqueda con el campo
    private int dni;
    private String direccion;


    @OneToMany(mappedBy = "huesped" ,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Reserva> reservas = new ArrayList<>();

    public Huesped(String nombre) {
        this.nombre = nombre;
    }

    public Huesped() {
    }

    public int getHuespedId() {
        return huespedId;
    }

    public void setHuespedId(int huespedId) {
        this.huespedId = huespedId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(int dni) throws HuespedDNIException {

        if (dni < 0) {
            // no se ejecuta nada mas despues del throw
            throw new HuespedDNIException(this, "ocurrio un error con el DNI");

        }
        this.dni = dni;
    }

    public int getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return "Huesped [dni=" + dni + ", nombre=" + nombre + "]";
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

}
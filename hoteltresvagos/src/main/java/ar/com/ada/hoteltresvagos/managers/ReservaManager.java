package ar.com.ada.hoteltresvagos.managers;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import ar.com.ada.hoteltresvagos.entities.*;

public class ReservaManager {

    protected SessionFactory sessionFactory;

    public void setup() {

        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure() // configures settings
                                                                                                  // from
                                                                                                  // hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception ex) {
            StandardServiceRegistryBuilder.destroy(registry);
            throw ex;
        }

    }

    public void exit() {
        sessionFactory.close();
    }

    public Reserva read(int reservaId) {
        Session session = sessionFactory.openSession();

        Reserva reserva = session.get(Reserva.class, reservaId);//busca en la tabla Huesped a algun huesped que tenga ese id

        session.close();

        return reserva;
    }

    public void update(Reserva reserva) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.update(reserva);

        session.getTransaction().commit();
        session.close();
    }

    public void delete(Reserva reserva) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.delete(reserva);

        session.getTransaction().commit();
        session.close();
    }

    public List<Reserva> reservaBuscarTodos() {

        Session session = sessionFactory.openSession();

        /// NUNCA HARCODEAR SQLs nativos en la aplicacion.
        // ESTO es solo para nivel educativo
        Query query = session.createNativeQuery("SELECT * FROM reserva", Reserva.class);
        //query = session.createQuery("From Obse")
        @SuppressWarnings("unchecked")
        List<Reserva> todos = query.getResultList();

        return todos;

    }

    public List<Reserva> buscarPorId(int reservaID) {

        Session session = sessionFactory.openSession();

        // SQL Injection vulnerability exposed.
        // Deberia traer solo aquella del nombre y con esto demostrarmos que trae todas
        // si pasamos
        // como nombre: "' or '1'='1"
        Query query = session.createNativeQuery("SELECT * FROM reserva where reserva_id = '" + reservaID + "'", Reserva.class);
        @SuppressWarnings("unchecked")
        List<Reserva> reservas = query.getResultList();

        return reservas;

    }

    public List<Reserva> buscarReservaPorNombreDeHuesped(String nombre) {

        Session session = sessionFactory.openSession();

        // SQL Injection vulnerability exposed.
        // Deberia traer solo aquella del nombre y con esto demostrarmos que trae todas
        // si pasamos
        // como nombre: "' or '1'='1"
        Query query = session.createNativeQuery("SELECT * FROM reserva r inner join huesped h on r.huesped_id = h.huesped_id where h.nombre = '" + nombre + "'", Reserva.class);
        @SuppressWarnings("unchecked")
        List<Reserva> reservasDeHuesped = query.getResultList();

        return reservasDeHuesped;

    }

	public void create(Reserva reserva) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(reserva);

        session.getTransaction().commit();
        session.close();
    }
    
}
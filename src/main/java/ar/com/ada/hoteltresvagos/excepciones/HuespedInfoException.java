package ar.com.ada.hoteltresvagos.excepciones;

import ar.com.ada.hoteltresvagos.entities.*;

/**
 * HuespedInfoException
 */
public class HuespedInfoException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    public HuespedInfoException(Huesped huesped, String mensaje) {

        super(huesped.getNombre() + ":" + mensaje);
    }
}
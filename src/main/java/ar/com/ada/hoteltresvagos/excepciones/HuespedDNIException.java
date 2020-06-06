package ar.com.ada.hoteltresvagos.excepciones;

import ar.com.ada.hoteltresvagos.entities.*;

/**
 * HuespedDNIException
 */
public class HuespedDNIException extends HuespedInfoException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public HuespedDNIException(Huesped huesped, String mensaje) {
        super(huesped, mensaje);
    }

}
package com.iunis.adventclub;



import com.iunis.adventclub.domain.Status;

import java.io.Serializable;

public final class DomainKeys implements Serializable {
    private DomainKeys() {
    }

    public static final Status ESTATUS_GENERAL_ACTIVO = new Status(1L);
    public static final Status ESTATUS_GENERAL_INACTIVO = new Status(2L);

}
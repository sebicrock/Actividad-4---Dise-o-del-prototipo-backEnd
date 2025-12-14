package com.bank.bank.imp.impCreateCreditCard;

import org.springframework.stereotype.Service;
import com.bank.bank.dto.dtoResquest.dtoRequestCreateCreditCard.DtoRequestCreateCreditCard;

@Service
public class ImpTotalCreditLimitCreditCard {

    /**
     * Calcula el límite total de crédito del cliente en tarjetas existentes.
     * Esto se puede usar para ajustar el cupo estimado de la nueva tarjeta.
     */
    public double totalCreditLimitCreditCard(DtoRequestCreateCreditCard dtoRequest) {
        if (dtoRequest == null) {
            return 0.0;
        }

        // Si no tiene tarjetas activas, el total es 0
        Double total = dtoRequest.getTotalCreditLimit() != null ? dtoRequest.getTotalCreditLimit() : 0.0;

        // Aquí se podría agregar lógica adicional si hubiera un listado de tarjetas
        // Por ejemplo, sumar el límite de cada tarjeta activa:
        // total += tarjetasActivas.stream().mapToDouble(t -> t.getCreditLimit()).sum();

        return total;
    }
}

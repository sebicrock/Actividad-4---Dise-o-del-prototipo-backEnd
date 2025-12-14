package com.bank.bank.imp.impCreateCreditCard;

import org.springframework.stereotype.Service;
import com.bank.bank.dto.dtoResquest.dtoRequestCreateCreditCard.DtoRequestCreateCreditCard;

@Service
public class ImpMonthlyLoanPayment {

    /**
     * Calcula el pago mensual total de préstamos del cliente.
     * Actualmente solo devuelve el valor ingresado en el DTO (puede extenderse para más lógica).
     */
    public Double monthlyLoanPayment(DtoRequestCreateCreditCard dtoRequest) {
        if (dtoRequest == null) {
            return 0.0;
        }

        // Si no hay préstamos activos o el valor es nulo, devolver 0
        Double pagoMensual = dtoRequest.getMonthlyLoanPayment() != null ? dtoRequest.getMonthlyLoanPayment() : 0.0;

        // Aquí se podrían agregar más cálculos si hubiera una lista de préstamos
        // Por ejemplo, sumar cada pago mensual de cada préstamo:
        // pagoMensual += prestamos.stream().mapToDouble(p -> p.getMonthlyPayment()).sum();

        return pagoMensual;
    }
}

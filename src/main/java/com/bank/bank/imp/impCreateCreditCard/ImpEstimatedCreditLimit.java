package com.bank.bank.imp.impCreateCreditCard;

import org.springframework.stereotype.Service;
import com.bank.bank.dto.dtoResquest.dtoRequestCreateCreditCard.DtoRequestCreateCreditCard;

@Service
public class ImpEstimatedCreditLimit {

    // Configuración de límites por tipo de tarjeta
    private static final double CLASICA_MIN = 500_000;
    private static final double CLASICA_MAX = 5_000_000;
    private static final double ORO_MIN = 2_000_000;
    private static final double ORO_MAX = 15_000_000;
    private static final double PLATINUM_MIN = 5_000_000;
    private static final double PLATINUM_MAX = 50_000_000;

    public Double estimatedCreditLimit(DtoRequestCreateCreditCard dtoRequest) {

        if (dtoRequest.getMonthlyIncome() == null || dtoRequest.getMonthlyIncome() < 1_300_000
                || dtoRequest.getCardType() == null) {
            return 0.0;
        }

        double ingreso = dtoRequest.getMonthlyIncome();
        double gastos = dtoRequest.getMonthlyExpenses() != null ? dtoRequest.getMonthlyExpenses() : 0;
        double cuotasPrestamos = dtoRequest.getMonthlyLoanPayment() != null ? dtoRequest.getMonthlyLoanPayment() : 0;

        // Capacidad de endeudamiento: 40% del ingreso disponible
        double ingresoNeto = ingreso - gastos - cuotasPrestamos;
        double capacidadMensual = ingresoNeto * 0.4;

        // Estimación inicial del cupo: 20 veces la capacidad mensual
        double cupoBase = capacidadMensual * 20;

        // Ajustar según tipo de tarjeta
        switch (dtoRequest.getCardType()) {
            case "CLASICA":
                cupoBase = Math.min(cupoBase, CLASICA_MAX);
                cupoBase = Math.max(cupoBase, CLASICA_MIN);
                break;
            case "ORO":
                cupoBase = cupoBase * 1.5;
                cupoBase = Math.min(cupoBase, ORO_MAX);
                cupoBase = Math.max(cupoBase, ORO_MIN);
                break;
            case "PLATINUM":
                cupoBase = cupoBase * 2;
                cupoBase = Math.min(cupoBase, PLATINUM_MAX);
                cupoBase = Math.max(cupoBase, PLATINUM_MIN);
                break;
            default:
                cupoBase = 0;
        }

        // Ajuste por antigüedad laboral
        if ("0-6".equals(dtoRequest.getTimeInJob())) {
            cupoBase *= 0.7;
        } else if ("60+".equals(dtoRequest.getTimeInJob())) {
            cupoBase *= 1.2;
        }

        // Ajuste si tiene otras tarjetas
        if ("SI".equalsIgnoreCase(dtoRequest.getHasCreditCards())
                && dtoRequest.getTotalCreditLimit() != null && dtoRequest.getTotalCreditLimit() > 0) {
            double factorReduccion = 1 - (dtoRequest.getTotalCreditLimit() / (ingreso * 12)) * 0.1;
            cupoBase *= Math.max(factorReduccion, 0.8);
        }

        // Redondear a múltiplos de 100,000
        cupoBase = Math.round(cupoBase / 100_000) * 100_000;

        return cupoBase;
    }
}

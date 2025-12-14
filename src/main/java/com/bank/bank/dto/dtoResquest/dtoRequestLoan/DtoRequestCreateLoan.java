package com.bank.bank.dto.dtoResquest.dtoRequestLoan;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

import java.util.List;
import lombok.Data;

@Data
public class DtoRequestCreateLoan {

    @NotNull(message = "El ID del cliente es obligatorio")
    private Long clienteId;

    @NotBlank(message = "El nombre es obligatorio")
    private String firstName;

    @NotBlank(message = "El apellido es obligatorio")
    private String lastName;

    @NotBlank(message = "El tipo de documento es obligatorio")
    private String documentType;

    @NotBlank(message = "El número de documento es obligatorio")
    private String documentNumber;

    @Email(message = "El correo electrónico no es válido")
    @NotBlank(message = "El correo electrónico es obligatorio")
    private String email;

    @Pattern(regexp = "\\d{10}", message = "El teléfono debe tener 10 dígitos")
    private String phone;

    @NotNull(message = "El monto del préstamo es obligatorio")
    @Min(value = 1000000, message = "El monto mínimo del préstamo es $1,000,000 COP")
    @Max(value = 100000000, message = "El monto máximo del préstamo es $100,000,000 COP")
    private Long loanAmount;

    @NotNull(message = "El plazo del préstamo es obligatorio")
    private Long loanTerm;

    @NotBlank(message = "El destino del préstamo es obligatorio")
    private String loanPurpose;

    @NotBlank(message = "El tipo de empleo es obligatorio")
    private String employmentType;

    @NotNull(message = "Los ingresos mensuales son obligatorios")
    @Min(value = 1300000, message = "Los ingresos mensuales deben ser al menos 1 SMMLV ($1,300,000)")
    private Long monthlyIncome;

    @NotBlank(message = "El nombre de la empresa es obligatorio")
    private String companyName;

    @NotBlank(message = "La antigüedad laboral es obligatoria")
    private String timeInJob;

    @NotBlank(message = "El tipo de cuenta para desembolso es obligatorio")
    private String accountType;

    @NotBlank(message = "El número de cuenta es obligatorio")
    @Size(min = 10, message = "El número de cuenta debe tener al menos 10 dígitos")
    private String accountNumber;

    @NotBlank(message = "El banco de la cuenta es obligatorio")
    private String bankName;

    // Referencias
    @NotNull(message = "Se debe incluir al menos una referencia")
    @Size(min = 2, message = "Deben existir dos referencias")
    private List<ReferenceDto> references;

    @AssertTrue(message = "Debe aceptar los términos y condiciones")
    private boolean acceptTerms;

    // Campos calculados (opcional incluirlos si quieres que lleguen al backend)
    private Double monthlyPayment;
    private Double interestRate;
    private Double totalInterest;
    private Double totalAmount;

    @Data
    public static class ReferenceDto {
        @NotBlank(message = "El nombre de la referencia es obligatorio")
        private String name;

        @Pattern(regexp = "\\d{7,10}", message = "El teléfono de la referencia debe tener entre 7 y 10 dígitos")
        private String phone;

        @NotBlank(message = "La relación con la referencia es obligatoria")
        private String relationship;
    }

}

package com.bank.bank.dto.dtoResquest;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class DtoRequestCreateRecurringSavingsAccount {

    @NotBlank
    private String goalType;
    private String customGoal;
    @NotNull @Positive
    private Double targetAmount;
    @NotNull @Positive
    private Long termMonths;
    @NotNull
    private Long sourceAccount;
    @NotNull @Min(1) @Max(28)
    private Long debitDay;
    private Boolean allowExtraDeposits;
    private Boolean autoRenew;
    private Boolean notifications;
    @NotNull
    private Long idCliente;
    



}

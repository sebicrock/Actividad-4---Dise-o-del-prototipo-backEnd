package com.bank.bank.dto.dtoResquest.dtoRequestClient;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class DtoRequestClient {

    @NotBlank(message = "Los nombres no pueden ser nulos")
    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚáéíóúñÑ ]+$", message = "El nombre solo puede contener letras y espacios")
    private String fullNames;

    @NotBlank(message = "Los apellidos no pueden ser nulos")
    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚáéíóúñÑ ]+$", message = "Los apellidos solo pueden contener letras y espacios")
    private String fullSurNames;

    @NotBlank(message = "El tipo de documento no puede ser nulo")
    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚáéíóúñÑ]+$", message = "El tipo de documento solo puede contener letras")
    private String documentType;

    @NotBlank(message = "El número de documento no puede ser nulo")
    @Pattern(regexp = "\\d+", message = "El número de documento debe contener solo números")
    private String documentNumber;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull(message = "La fecha de cumpleaños no puede ser nula")
    private LocalDate birthDate;

    @NotBlank(message = "el genero no puede ser nulo")
    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚáéíóúñÑ]+$", message = "el genero solo puede contener letras" )
    private String gender;

    @NotNull(message = "La edad no puede ser nula")
    @Min(value = 1, message = "La edad debe ser mayor a 1")
    private Long age;

    @NotNull(message = "El número de teléfono no puede ser nulo")
    @Digits(integer = 10, fraction = 0, message = "El número de teléfono debe tener máximo 10 dígitos")
    private Long mobilePhone;

    @Email(message = "El formato del correo electrónico no es válido")
    @NotBlank(message = "El correo no puede ser nulo")
    private String email;


    @NotBlank(message = "la direccion no puede ser nulo")
    private String address;

    @NotBlank(message = "la ciudad no puede ser nulo")
    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚáéíóúñÑ]+$", message = "la ciudad solo puede contener letras")
    private String city;

    @NotBlank()
    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚáéíóúñÑ]+$", message = "el departamento solo puede contener letras")
    private String department;

    @NotNull(message = "El ingreso no puede ser nulo")
    @Positive(message = "El ingreso debe ser mayor que cero")
    private double income;

    @NotBlank(message = "El estado laboral no puede ser nulo")
    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚáéíóúñÑ]+$", message = "El estado laboral solo puede contener letras")
    private String employmentStatus;

    @NotBlank(message = "La ocupacion no puede ser nula")
    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚáéíóúñÑ]+$", message = "La opcupacion laboral solo puede tener letras")
    private String occupation;

    @NotBlank(message = "El nombre de la compañia no puede ser nulo")
    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚáéíóúñÑ]+$", message = "El nombre de la compañia solo puede tener letras")
    private String companyName;

    // Aquí permites que venga uno o varios usuarios
    @NotEmpty(message = "Debe enviarse al menos un usuario")
    @Valid
    private List<DtoRequestUser> user;
}

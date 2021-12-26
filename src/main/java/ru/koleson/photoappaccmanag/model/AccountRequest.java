package ru.koleson.photoappaccmanag.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class AccountRequest {
    @NotNull
    private String firstName;

    @NotNull
    private String lastName;
}

package ru.koleson.photoappaccmanag.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionMessage {

    private Date timestamp;

    private String message;
}


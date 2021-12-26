package ru.koleson.photoappaccmanag.exception;

import java.io.Serial;

public class AccountException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -5882465783904843287L;

    public AccountException(String message) {
        super(message);
    }

}

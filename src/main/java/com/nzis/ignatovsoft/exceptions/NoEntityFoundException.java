package com.nzis.ignatovsoft.exceptions;

import java.sql.SQLException;

public class NoEntityFoundException extends SQLException {

    public NoEntityFoundException(String message) {
        super(message);
    }

    public NoEntityFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoEntityFoundException(Throwable cause) {
        super(cause);
    }
}

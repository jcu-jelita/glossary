package glossary.global.exception;

/**
 * Created by Pavel Máca <maca.pavel@gmail.com> on 05.07.2017.
 */
public abstract class GlossaryException extends Exception {
    public GlossaryException() {
    }

    public GlossaryException(String message) {
        super(message);
    }

    public GlossaryException(String message, Throwable cause) {
        super(message, cause);
    }

    public GlossaryException(Throwable cause) {
        super(cause);
    }

    public GlossaryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

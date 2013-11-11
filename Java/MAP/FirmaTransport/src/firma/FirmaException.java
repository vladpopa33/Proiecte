package firma;

/**
 * Created by IntelliJ IDEA.
 * User: grigo
 * Date: Nov 16, 2011
 * Time: 11:52:47 PM
 */
public class FirmaException extends Exception{
    public FirmaException() {
    }

    public FirmaException(String message, Throwable cause) {
        super(message, cause);
    }

    public FirmaException(String message) {
        super(message);
    }
}

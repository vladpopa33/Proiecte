package firma.repository;

/**
 * Created by IntelliJ IDEA.
 * User: grigo
 * Date: Nov 16, 2011
 * Time: 11:53:41 PM
 */
public class RepositoryException extends RuntimeException{
    public RepositoryException() {
    }

    public RepositoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public RepositoryException(String message) {
        super(message);
    }
}

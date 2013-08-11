
package com.bluestome.android.databases.exception;

/**
 * @ClassName: DBException
 * @Description: TODO
 * @author bluestome
 * @date 2013-8-10 上午10:09:28
 */
public class DBException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DBException() {
        super();
    }

    public DBException(String message) {
        super(message);
    }

    public DBException(Throwable cause) {
        super(cause);
    }

    public DBException(String message, Throwable cause) {
        super(message, cause);
    }
}

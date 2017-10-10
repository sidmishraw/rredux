/**
 * Project: RRedux
 * Package: rredux.core
 * File: BadActionException.java
 * 
 * @author sidmishraw
 *         Last modified: Oct 9, 2017 11:30:56 PM
 */
package rredux.core;

/**
 * @author sidmishraw
 *
 *         Qualified Name: rredux.core.BadActionException
 *
 */
public class BadActionException extends Exception {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * 
     */
    public BadActionException() {
        // TODO Auto-generated constructor stub
    }
    
    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public BadActionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }
    
    /**
     * @param message
     * @param cause
     */
    public BadActionException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }
    
    /**
     * @param message
     */
    public BadActionException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }
    
    /**
     * @param cause
     */
    public BadActionException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }
    
}

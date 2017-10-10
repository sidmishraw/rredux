/**
 * Project: RRedux
 * Package: rredux.core
 * File: Action.java
 * 
 * @author sidmishraw
 *         Last modified: Oct 9, 2017 10:08:02 AM
 */
package rredux.core;

/**
 * <p>
 * <i>Action</i> represents the actions that change the <i>State</i> of the
 * <i>Store</i>. The <i>State</i> of the <i>Store</i> cannot be changed by any
 * other means.
 * 
 * @author sidmishraw
 *
 *         Qualified Name: rredux.core.Action
 *
 */
public interface Action {
    
    /**
     * Provides the type of the {@link Action}. This is used by the
     * <i>Reducer</i> to move the <i>Store</i> from its <i>current State</i> to
     * the <i>new State</i>.
     * 
     * @return The type of {@link Action}
     */
    public String type();
}

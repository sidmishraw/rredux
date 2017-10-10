/**
 * Project: RRedux
 * Package: rredux.core
 * File: Listener.java
 * 
 * @author sidmishraw
 *         Last modified: Oct 9, 2017 10:15:20 AM
 */
package rredux.core;

import java.util.Observer;

/**
 * <p>
 * A {@link Listener} listens to the change in <i>State</i> of the <i>Store</i>.
 * The Listener is notified of the changed when an <i>Action</i> is successfully
 * dispatched.
 * 
 * @author sidmishraw
 *
 *         Qualified Name: rredux.core.Listener
 *
 */
public abstract class Listener implements Observer {
    
    /**
     * <p>
     * The reference to the <i>Store</i> that the {@link Listener} is currently
     * observing for changes.
     */
    private Store store;
    
    /**
     * <p>
     * Unsubscribes the {@link Listener} from the <i>Store</i>
     */
    public final void unsubscribe() {
        
        this.store.deleteObserver(this);
    }
    
    /**
     * <p>
     * Sets the reference to the {@link Store} so that the {@link Listener} can
     * unsubscribe from the {@link Store}'s subscription set.
     * 
     * @param store
     *            The {@link Store} the {@link Listener} is listening to
     */
    public final void setStore(Store store) {
        
        this.store = store;
    }
}

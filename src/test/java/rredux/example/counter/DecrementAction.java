/**
 * Project: RRedux
 * Package: rredux.example.counter
 * File: DecrementAction.java
 * 
 * @author sidmishraw
 *         Last modified: Oct 9, 2017 11:39:58 PM
 */
package rredux.example.counter;

import rredux.core.Action;
import rredux.core.State;
import rredux.core.Store;

/**
 * <p>
 * This {@link Action} decrements the Integral {@link State} of the
 * {@link Store}
 * 
 * @author sidmishraw
 *
 *         Qualified Name: rredux.example.counter.DecrementAction
 *
 */
public class DecrementAction implements Action {
    
    /*
     * (non-Javadoc)
     * 
     * @see rredux.core.Action#type()
     */
    @Override
    public String type() {
        
        return "DECREMENT";
    }
    
}

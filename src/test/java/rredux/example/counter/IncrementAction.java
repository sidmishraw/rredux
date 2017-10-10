/**
 * Project: RRedux
 * Package: rredux.example.counter
 * File: IncrementAction.java
 * 
 * @author sidmishraw
 *         Last modified: Oct 9, 2017 11:39:26 PM
 */
package rredux.example.counter;

import rredux.core.Action;
import rredux.core.State;
import rredux.core.Store;

/**
 * This {@link Action} increments the Integral {@link State} of the
 * {@link Store}
 * 
 * @author sidmishraw
 *
 *         Qualified Name: rredux.example.counter.IncrementAction
 *
 */
public class IncrementAction implements Action {
    
    /*
     * (non-Javadoc)
     * 
     * @see rredux.core.Action#type()
     */
    @Override
    public String type() {
        
        return "INCREMENT";
    }
    
}

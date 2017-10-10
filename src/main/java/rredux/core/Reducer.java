/**
 * Project: RRedux
 * Package: rredux.core
 * File: Reducer.java
 * 
 * @author sidmishraw
 *         Last modified: Oct 9, 2017 10:12:10 AM
 */
package rredux.core;

/**
 * <p>
 * The {@link Reducer} represents the logic that is used for changing the
 * <i>State</i> of the <i>Store</i> according to the dispatched <i>Action</i>.
 * 
 * @author sidmishraw
 *
 *         Qualified Name: rredux.core.Reducer
 *
 */
public interface Reducer {
    
    /**
     * <p>
     * Consumes the {@link Action} and computes the new State from the Action
     * and current State combination.
     * 
     * @param currentState
     *            The current state of the Store
     * @param action
     *            The dispatched action
     * @return The new state
     */
    public State apply(State currentState, Action action);
}

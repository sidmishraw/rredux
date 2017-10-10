/**
 * Project: RRedux
 * Package: rredux.core
 * File: Store.java
 * 
 * @author sidmishraw
 *         Last modified: Oct 9, 2017 10:21:46 AM
 */
package rredux.core;

import java.util.Objects;
import java.util.Observable;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * The {@linkplain Store} is the focal point. It contains the
 * {@linkplain State}, the {@linkplain Reducer} and the {@linkplain Listener}s.
 * 
 * <p>
 * The Store, uses its dispatcher to consume {@linkplain Action}s, then
 * depending on the {@link Action} and current {@link State}, it uses its
 * {@link Reducer} to compute the next {@link State}.
 * 
 * <p>
 * It then notifies all its observers or {@link Listener}s about the change in
 * {@link State}.
 * 
 * <p>
 * There is only 1 {@link Store} for the entire application.
 * 
 * @author sidmishraw
 *
 *         Qualified Name: rredux.core.Store
 *
 */
public class Store extends Observable {
    
    /***** Logging *******/
    private static final Logger    logger         = LoggerFactory.getLogger(Store.class);
    /***** Logging *******/
    
    /**
     * <p>
     * Represents the current {@link State} of the {@link Store}.
     */
    private State                  state;
    
    /**
     * <p>
     * Represents the current {@link Reducer} used by the {@link Store} for
     * {@link State} computation.
     */
    private Reducer                reducer;
    
    /**
     * <p>
     * The singleton {@link Store}
     */
    private static Optional<Store> singletonStore = Optional.ofNullable(null);
    
    /**
     * Made the constructor private to get Singleton {@link Store}
     */
    private Store() {}
    
    /**
     * <p>
     * Creates a {@link Store} with the {@link Reducer} and empty {@link State}
     * 
     * @param reducer
     *            The {@link Reducer} used by the {@link Store} to compute
     *            {@link State} by consuming dispatched {@link Action}s
     * 
     * @return The {@link Store}'s instance
     */
    public static Store createStore(final Reducer reducer) {
        
        if (!singletonStore.isPresent()) {
            
            singletonStore = Optional.of(new Store());
        }
        
        singletonStore.get().reducer = reducer;
        singletonStore.get().state = null;
        
        return singletonStore.get();
    }
    
    /**
     * <p>
     * Creates a {@link Store} with the {@link Reducer} and an initial state
     * {@link State}
     * 
     * @param reducer
     *            The {@link Reducer} used by the {@link Store} to compute
     *            {@link State} by consuming dispatched {@link Action}s
     * @param initialState
     *            The initialState of the Store
     * 
     * @return The {@link Store}'s instance
     * @see Store#createStore(Reducer)
     */
    public Store createStore(Reducer reducer, final State initialState) {
        
        if (!singletonStore.isPresent()) {
            
            singletonStore = Optional.of(new Store());
        }
        
        singletonStore.get().reducer = reducer;
        singletonStore.get().state = initialState;
        
        return singletonStore.get();
    }
    
    /**
     * <p>
     * Gets the current {@link State} of the {@link Store}
     * 
     * @return The current {@link State} of the {@link Store}
     */
    public State getState() {
        
        return this.state;
    }
    
    /**
     * <p>
     * Adds the {@link Listener} to the {@link Store#nextListeners}, enables the
     * {@link Listener} to receive updates about the {@link Store}'s
     * {@link State} changes.
     * 
     * @param listener
     *            The {@link Listener} the needs to listen to {@link Store}'s
     *            {@link State} changes
     */
    public void subscribe(Listener listener) {
        
        this.addObserver(listener);
    }
    
    /**
     * <p>
     * The dispatcher of the {@link Store}. This consumes the incoming
     * {@link Action} and takes care of calling the {@link Reducer} to compute
     * the next {@link State} of the {@link Store} based on the consumed
     * {@link Action}.
     * 
     * <p>
     * It also takes care of notifying the {@link Listener}s about the
     * {@link State} change.
     * 
     * @param action
     *            The dispatched {@link Action} to be consumed
     * 
     * @return The action just passes through
     */
    public Action dispatch(final Action action) throws BadActionException {
        
        if (Objects.isNull(action.type()) || action.type().isEmpty()) {
            
            logger.error("Action is not valid");
            
            throw new BadActionException("Action is not valid");
        }
        
        // compute the next state from the current state and dispatched action
        this.state = this.reducer.apply(this.state, action);
        
        // notify listeners
        this.setChanged();
        
        this.notifyObservers();
        // notify listeners
        
        return action;
    }
}

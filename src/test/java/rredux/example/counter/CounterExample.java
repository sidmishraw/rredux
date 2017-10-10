/**
 * Project: RRedux
 * Package: rredux.example.counter
 * File: CounterExample.java
 * 
 * @author sidmishraw
 *         Last modified: Oct 9, 2017 11:41:49 PM
 */
package rredux.example.counter;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rredux.core.Action;
import rredux.core.BadActionException;
import rredux.core.State;
import rredux.core.Store;

/**
 * <p>
 * Main driver of the RRedux's Counter example. This will illustrate the use of
 * RRedux.
 * 
 * @author sidmishraw
 *
 *         Qualified Name: rredux.example.counter.CounterExample
 *
 */
public class CounterExample {
    
    private static final Logger logger = LoggerFactory.getLogger(CounterExample.class);
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        
        logger.info("Starting counter example...");
        
        // Get the store with the reducer and empty initial state
        Store store = Store.createStore((State s, Action a) -> {
            
            IntegralState cState = (IntegralState) s;
            
            if (Objects.isNull(cState)) {
                
                cState = new IntegralState(null);
            }
            
            switch (a.type()) {
                
                case "INCREMENT": {
                    
                    return new IntegralState(cState.getValue() + 1);
                }
                
                case "DECREMENT": {
                    
                    return new IntegralState(cState.getValue() - 1);
                }
                
                default: {
                    
                    return cState;
                }
            }
            
        });
        
        // subscribe the listeners or observers
        store.subscribe(new SampleListener1());
        store.subscribe(new SampleListener2());
        
        // start dispatching actions
        try {
            store.dispatch(new IncrementAction());
            store.dispatch(new IncrementAction());
            store.dispatch(new IncrementAction());
            store.dispatch(new IncrementAction());
            store.dispatch(new IncrementAction());
            store.dispatch(new IncrementAction());
            store.dispatch(new IncrementAction());
            store.dispatch(new DecrementAction());
            store.dispatch(new DecrementAction());
            store.dispatch(new DecrementAction());
            store.dispatch(new IncrementAction());
        } catch (BadActionException e) {
            
            logger.error(e.getMessage(), e);
        }
    }
    
}

# RRedux

*RRedux* is a pure Java implementation of `Redux` to provide predictive state transitions.

### UML
For UML, refer to the [`rredux.mdj`](./rredux.mdj)

### RRedux usage example:
Below is the sample code for using the RRedux library for `State` management. For details refer to the `rredux.example.counter` package under [src/test/java](./src/test/java)
 
```java
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
```


### Requirements:
* Java 8(v1.8.0_144 or above)
* Eclipse v4.5 or above
* Project Lombok eclipse plugin
* Buildship Gradle plugin for Eclipse
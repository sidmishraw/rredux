/**
 * Project: RRedux
 * Package: rredux.example.counter
 * File: IntegralState.java
 * 
 * @author sidmishraw
 *         Last modified: Oct 9, 2017 11:44:35 PM
 */
package rredux.example.counter;

import java.util.Objects;

import lombok.Getter;
import rredux.core.State;

/**
 * <p>
 * The {@link IntegralState} used in the counter example.
 * 
 * <p>
 * The {@link IntegralState} is immutable.
 * 
 * @author sidmishraw
 *
 *         Qualified Name: rredux.example.counter.IntegralState
 *
 */
public class IntegralState implements State {
    
    /**
     * The value of the {@link IntegralState}
     */
    private @Getter Integer value;
    
    /**
     * Makes a new {@link IntegralState}
     * 
     * @param value
     *            The value of the {@link IntegralState}
     */
    public IntegralState(Integer value) {
        
        if (Objects.isNull(value)) {
            
            this.value = 0;
        } else {
            
            this.value = value;
        }
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        
        return String.format("IntegralState:: value: %d", this.value);
    }
}

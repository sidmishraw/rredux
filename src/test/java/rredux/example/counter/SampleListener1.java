/**
 * Project: RRedux
 * Package: rredux.example.counter
 * File: SampleListener1.java
 * 
 * @author sidmishraw
 *         Last modified: Oct 9, 2017 11:51:04 PM
 */
package rredux.example.counter;

import java.util.Observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rredux.core.Listener;
import rredux.core.Store;

/**
 * <p>
 * A sample {@link Listener} used to demonstrate the pub-sub pattern used in
 * RRedux.
 * 
 * @author sidmishraw
 *
 *         Qualified Name: rredux.example.counter.SampleListener1
 *
 */
public class SampleListener1 extends Listener {
    
    /******* For logging **********/
    private static final Logger logger = LoggerFactory.getLogger(SampleListener1.class);
    
    /******* For logging **********/
    
    /*
     * (non-Javadoc)
     * 
     * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
     */
    @Override
    public void update(Observable o, Object arg) {
        
        logger.info(String.format("From withing SampleListener#1:: Store has updated its state to :: %d",
                ((IntegralState) ((Store) o).getState()).getValue()));
    }
    
}

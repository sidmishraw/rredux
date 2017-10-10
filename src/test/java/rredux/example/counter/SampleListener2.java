/**
 * Project: RRedux
 * Package: rredux.example.counter
 * File: SampleListener2.java
 * 
 * @author sidmishraw
 *         Last modified: Oct 9, 2017 11:55:38 PM
 */
package rredux.example.counter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Observable;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rredux.core.Listener;
import rredux.core.State;
import rredux.core.Store;

/**
 * @author sidmishraw
 *
 *         Qualified Name: rredux.example.counter.SampleListener2
 *
 */
public class SampleListener2 extends Listener {
    
    /****** logging stuff **************/
    private static final Logger  logger = LoggerFactory.getLogger(SampleListener2.class);
    /****** logging stuff **************/
    
    /**
     * <p>
     * Uses this to track the various {@link State} transitions of the
     * {@link Store}
     */
    private TreeMap<Long, State> stateHistoryTable;
    
    private SimpleDateFormat     formatter;
    
    /**
     * 
     */
    public SampleListener2() {
        
        this.stateHistoryTable = new TreeMap<>();
        this.formatter = new SimpleDateFormat("mm/dd/YYYY :: hh:MM:ss:SSS");
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
     */
    @Override
    public void update(Observable o, Object arg) {
        
        this.stateHistoryTable.put((new Date().getTime()), ((Store) o).getState());
        
        replayHistory();
    }
    
    /**
     * <p>
     * Replays the history
     */
    private void replayHistory() {
        
        logger.info(String.format("Replaying history for the %d time:: \n", this.stateHistoryTable.size()));
        
        for (Map.Entry<Long, State> entry : this.stateHistoryTable.entrySet()) {
            
            logger.info(String.format("State:: %s -> %s", this.formatter.format(new Date(entry.getKey())),
                    entry.getValue().toString()));
        }
    }
    
}

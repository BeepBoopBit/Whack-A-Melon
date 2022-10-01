
package SpawnerLibrary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


public class ImageSpawner {
    private GridPanel _grid = null;
    private int _frequecyDelay = 500;
    Timer _frequencyTimer = null;
    
    // Constructors
    public ImageSpawner(){}
    
    // Relevant Methods
    public void attachGridPanel(GridPanel myGrid){
        _grid = myGrid;
    }
    
    // Can change runtime
    public void delay(int delay){
        int myDelay = _frequencyTimer.getDelay() + delay;
        _frequencyTimer.setDelay(myDelay);
    }
    public void accelerate(int accelerate){
        int myAccelerate = _frequencyTimer.getDelay() - accelerate;
        _frequencyTimer.setDelay(myAccelerate);
    }
    
    // Should be call before calling start() method
    // can't change in runtime. Change using changeDelay() method
    public void setFrequencyDelay(int frequencyDelay){
        _frequecyDelay = frequencyDelay;
    }
    
    // Main
    public void start(){
        if(_frequencyTimer == null){
            _frequencyTimer = new Timer(_frequecyDelay, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    spawn();
                }
            });
        }
        _frequencyTimer.start();
    }
    
    // Spawing
    private void spawn(){
        _grid.changeState();
    }
    
}

package playground.chapter4_ComposingObjects;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.NotThreadSafe;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Problem with this is class is holding the lock while firing the event in
 * the method fireKeyPressedEvent
 */
public class VisualComponentBad {
    @GuardedBy("this")
    private final List<KeyListener> keyListeners = new ArrayList<>();
    @GuardedBy("this")
    private final List<MouseListener> mouseListeners = new ArrayList<>();

    public synchronized void addKeyListener(KeyListener kl){
        keyListeners.add(kl);
    }
    public synchronized void addMouseListener(MouseListener ml){
        mouseListeners.add(ml);
    }

    protected synchronized void fireKeyPressedEvent(KeyEvent ev){
        for(KeyListener listener : keyListeners)
            listener.keyPressed(ev);
    }//etc
}

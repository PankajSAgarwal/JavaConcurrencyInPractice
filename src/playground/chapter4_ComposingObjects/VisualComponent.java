package playground.chapter4_ComposingObjects;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class VisualComponent {
    private final Set<KeyListener> keyListeners = new CopyOnWriteArraySet<>();

    private final Set<MouseListener> mouseListeners = new CopyOnWriteArraySet<>();

    public void addKeyListener(KeyListener kl){
        keyListeners.add(kl);
    }

    public void addMouseListener(MouseListener ml){
        mouseListeners.add(ml);
    }

    protected void fireKeyPressedEvent(KeyEvent ev){
        for(KeyListener listener : keyListeners){
            listener.keyPressed(ev);
        }
    }//etc.
}

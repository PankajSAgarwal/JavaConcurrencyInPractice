package playground.chapter4_ComposingObjects;

import net.jcip.annotations.Immutable;

@Immutable
public class Point {
    private final int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

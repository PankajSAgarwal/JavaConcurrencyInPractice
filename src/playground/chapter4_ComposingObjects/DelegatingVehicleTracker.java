package playground.chapter4_ComposingObjects;

import net.jcip.annotations.ThreadSafe;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@ThreadSafe
public class DelegatingVehicleTracker {
    private final ConcurrentMap<String,Point> locations;
    private final Map<String,Point> unmodifiableMap;

    public DelegatingVehicleTracker(Map<String, Point> points) {
        this.locations = new ConcurrentHashMap<>(points);
        this.unmodifiableMap = Collections.unmodifiableMap(locations);
    }
    public Map<String,Point> getLocations(){
        return unmodifiableMap;
    }

    public Point getLocation(String id){
        Point result = locations.get(id);
        if (result == null) {

            throw new IllegalArgumentException(
                    "invalid vehicle name: " + id
            );
        }

        return result;
    }

    public void setLocations(String id,int x, int y){
        Point point = new Point(x,y);
        if(locations.replace(id,point) == null)
            throw new IllegalArgumentException("Invalid vehicle name :" + id);
    }

}

package playground.chapter4_ComposingObjects;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Design ideas for MonitorVehicleTracker
 * 1. We use the JavaMonitor pattern for thread safety
 * - All fields are private
 * - None of the internal mutable objects are ever published ,instead clones are returned
 * 2. Some Design approach
 * - The MonitorVehicleTracker is for a fixed set of vehicles
 * - When we call getLocation() or setLocation() on an unknown id , we throw an Illegal Argument exception
 */

@ThreadSafe
public class MonitorVehicleTracker {
    @GuardedBy("this")
    private final Map<String,MutablePoint> locations;

    public MonitorVehicleTracker(Map<String, MutablePoint> locations) {
        this.locations = deepCopy(locations);
    }

    private static Map<String,MutablePoint> deepCopy(
            Map<String,MutablePoint> m){
        Map<String,MutablePoint> result = new HashMap<>();
        for(Map.Entry<String,MutablePoint> e: m.entrySet()){
            result.put(e.getKey(), new MutablePoint(e.getValue()));
        }
        return Collections.unmodifiableMap(result);
    }

    public synchronized Map<String,MutablePoint> getLocations(){
        return deepCopy(locations);
    }

    public synchronized MutablePoint getLocation(String id){
        return new MutablePoint(findLocation(id));
    }

    public synchronized void setLocations(String id, int x, int y){
        MutablePoint loc = findLocation(id);
        loc.x = x;
        loc.y = y;
    }

    private MutablePoint findLocation(String id){
        MutablePoint loc = locations.get(id);
        if(loc == null)
            throw new IllegalArgumentException("No such id :" + id);
        return loc;
    }
}

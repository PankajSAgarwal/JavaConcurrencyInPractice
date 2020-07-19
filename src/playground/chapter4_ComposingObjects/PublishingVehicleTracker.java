package playground.chapter4_ComposingObjects;

import net.jcip.annotations.ThreadSafe;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ThreadSafe
public class PublishingVehicleTracker {
    private final Map<String,SafePoint> locations;
    private final Map<String,SafePoint> unmodifiableMap;

    public PublishingVehicleTracker(Map<String, SafePoint> locations) {
        this.locations = new ConcurrentHashMap<>(locations);
        this.unmodifiableMap = Collections.unmodifiableMap(this.locations);
    }

    public Map<String, SafePoint> getLocations() {
        return unmodifiableMap;
    }
    public SafePoint getLocation(String id){
        return findVehicle(id);
    }

    public void setLocation(String id, int x, int y){
        findVehicle(id).set(x,y);
    }

    private SafePoint findVehicle(String id) {
        SafePoint result = locations.get(id);
        if(result == null)
            throw new IllegalArgumentException(
                    "Invalid vehicle name : " + id
            );
        return result;
    }
}

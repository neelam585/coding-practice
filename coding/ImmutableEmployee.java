import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class ImmutableEmployee {
    private final int eId;
    private final Map<String, Integer> enames;

    public ImmutableEmployee(int eId, Map<String, Integer> enames) {
        this.eId = eId;
        // Defensive copy to ensure immutability
        this.enames = Collections.unmodifiableMap(Map.copyOf(enames));
    }

    public int getEId() {
        return eId;
    }

    public Map<String, Integer> getEnames() {
        return enames;
    }
}

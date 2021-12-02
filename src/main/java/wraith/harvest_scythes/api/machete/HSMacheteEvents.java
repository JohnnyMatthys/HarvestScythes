package wraith.harvest_scythes.api.machete;

import wraith.harvest_scythes.api.event.HarvestEvent;
import wraith.harvest_scythes.api.event.SingleHarvestEvent;

import java.util.HashSet;

public final class HSMacheteEvents {

    private HSMacheteEvents() {}

    private static final HashSet<IMacheteSingleHarvestListener> SINGLE_HARVEST_LISTENERS = new HashSet<>();
    private static final HashSet<IMacheteHarvestListener> HARVEST_LISTENERS = new HashSet<>();

    public static void addSingleHarvestListener(IMacheteSingleHarvestListener listener) {
        SINGLE_HARVEST_LISTENERS.add(listener);
    }

    public static void addHarvestListener(IMacheteHarvestListener listener) {
        HARVEST_LISTENERS.add(listener);
    }

    public static void removeSingleHarvestListener(IMacheteSingleHarvestListener listener) {
        SINGLE_HARVEST_LISTENERS.remove(listener);
    }

    public static void removeHarvestListener(IMacheteHarvestListener listener) {
        HARVEST_LISTENERS.remove(listener);
    }

    // Called when a single crop is harvested
    public static void onSingleHarvest(SingleHarvestEvent event) {
        for (var listener : SINGLE_HARVEST_LISTENERS) {
            listener.onSingleHarvest(event);
        }
    }

    // Called when multiple crops are harvested
    public static void onHarvest(HarvestEvent event) {
        for (var listener : HARVEST_LISTENERS) {
            listener.onHarvest(event);
        }
    }

}

package Zepto.strategies;

import java.util.Map;

import Zepto.managers.InventoryManager;

// Refill on a fixed weekly schedule instead of on a threshold.
public class WeeklyReplenishStrategy implements ReplenishStrategy {

    public WeeklyReplenishStrategy() {
    }

    @Override
    public void replenish(InventoryManager manager, Map<Integer, Integer> itemsToReplenish) {
        System.out.println("[WeeklyReplenish] Weekly replenishment triggered for inventory.");
    }
}

package Zepto.strategies;

import java.util.Map;

import Zepto.managers.InventoryManager;

// Strategy Pattern: the rule for HOW stock gets refilled is pluggable.
public interface ReplenishStrategy {
    void replenish(InventoryManager manager, Map<Integer, Integer> itemsToReplenish);
}

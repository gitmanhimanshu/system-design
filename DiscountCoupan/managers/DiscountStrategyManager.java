package DiscountCoupan.managers;

import DiscountCoupan.enums.StrategyType;
import DiscountCoupan.strategies.*;

public class DiscountStrategyManager {
    private static DiscountStrategyManager instance;

    private DiscountStrategyManager() {}

    public static synchronized DiscountStrategyManager getInstance() {
        if (instance == null) {
            instance = new DiscountStrategyManager();
        }
        return instance;
    }

    public DiscountStrategy getStrategy(StrategyType type, double val1, double val2) {
        switch (type) {
            case FLAT:
                return new FlatDiscountStrategy(val1);
            case PERCENTAGE:
                return new PercentageDiscountStrategy(val1);
            case PERCENTAGE_WITH_CAP:
                return new percentageWithCapStrategy(val1, val2);
            default:
                throw new IllegalArgumentException("Unknown type: " + type);
        }
    }
}
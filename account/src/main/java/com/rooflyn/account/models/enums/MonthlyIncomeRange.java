package com.rooflyn.account.models.enums;

public enum MonthlyIncomeRange {
    BELOW_50000("₦0 - ₦49,999"),
    RANGE_50000_TO_99999("₦50,000 - ₦99,999"),
    RANGE_100000_TO_199999("₦100,000 - ₦199,999"),
    RANGE_200000_TO_399999("₦200,000 - ₦399,999"),
    RANGE_400000_TO_599999("₦400,000 - ₦599,999"),
    RANGE_600000_TO_999999("₦600,000 - ₦999,999"),
    ABOVE_1000000("₦1,000,000 and above");

    private final String label;

    MonthlyIncomeRange(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}


package com.issderrar.kpi

object KpiFactory { // "object" is Singleton Pattern

    fun getKpi(kpiType: KpiType): KpiStrategy = when(kpiType) {
        KpiType.AVERAGE_BASKET -> AverageBasketCalculator()
        KpiType.COST_PER_CLICK -> CostPerClickCalculator()
        KpiType.RATE_PER_CLICK -> RatePerClickCalculator()
        KpiType.ROI -> ROICalculator()
        KpiType.ROI_PER_DEVICE -> ROIPerDevicePerMonthCalculator()
        KpiType.TURNOVER_PER_DEVICE -> TurnoverPerDeviceCalculator()
        KpiType.TURNOVER_PER_MONTH_PER_YEAR -> TurnoverPerMonthPerYearCalculator()
    }
}
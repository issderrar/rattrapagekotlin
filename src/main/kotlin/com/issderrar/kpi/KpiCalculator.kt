package com.issderrar.kpi

import com.issderrar.Device

class KpiCalculator(private val strategy: KpiStrategy, private val devices: List<Device>) {

    fun computeKpi() {
        strategy.computeKpi(devices)
    }
}
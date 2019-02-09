package com.issderrar.kpi

import com.issderrar.Device

class ROICalculator: KpiStrategy {
    override fun computeKpi(devices: List<Device>) {
        val roi = devices.sumBy { it.ca } / (devices.sumBy { it.cost }).toDouble()
        println("Ca total=${devices.sumBy { it.ca }}")
        println("Coût total=${devices.sumBy { it.cost }}")
        println("ROI=$roi")
    }
}
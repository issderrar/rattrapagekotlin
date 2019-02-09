package com.issderrar.kpi

import com.issderrar.Device

class RatePerClickCalculator: KpiStrategy {
    override fun computeKpi(devices: List<Device>) {
        val clicrate = (devices.sumBy {it.clics} / (devices.sumBy{ it.impressions}).toDouble()) * 100
        println("Nombre total de clic = ${devices.sumBy {it.clics}}")
        println("Nombre total de impressions = ${devices.sumBy {it.impressions}}")
        println("Taux de clic = $clicrate %")
        println()
    }
}
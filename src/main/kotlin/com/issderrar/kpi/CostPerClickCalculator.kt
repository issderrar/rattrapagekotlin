package com.issderrar.kpi

import com.issderrar.Device

class CostPerClickCalculator: KpiStrategy {
    override fun computeKpi(devices: List<Device>) {
        val costperclick = (devices.sumBy { it.cost }) / (devices.sumBy { it.clics }).toDouble()
        println("Coût total= ${devices.sumBy { it.cost }}")
        println("Nombre total de clics= ${devices.sumBy { it.clics }}")
        println("Chaque clic reviens à très exactement= $costperclick ")
    }
}
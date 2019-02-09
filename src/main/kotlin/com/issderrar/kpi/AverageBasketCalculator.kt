package com.issderrar.kpi

import com.issderrar.Device

class AverageBasketCalculator : KpiStrategy {
    override fun computeKpi(devices: List<Device>) {
        val averagebasket = devices.sumBy { it.ca } / devices.sumBy { it.commande}
            println("Le panier moyen est égal à (Chiffres d'affaires/commandes) = $averagebasket ")

    }
}
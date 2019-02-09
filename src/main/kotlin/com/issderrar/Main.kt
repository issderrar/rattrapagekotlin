package com.issderrar

import com.issderrar.kpi.KpiCalculator
import com.issderrar.kpi.KpiFactory
import com.issderrar.kpi.KpiType
import java.util.*

fun main() {
    val dataFileReader = DataFileReader()

    val devices = dataFileReader.readFile()
        .filter { it.commande + it.impressions + it.clics + it.cost + it.pm + it.ca > 0 } // Supprime les lignes vides (cad les lignes avec que des 0)

    val kpiToCalculators = mapOf(
        KpiType.AVERAGE_BASKET to KpiCalculator(KpiFactory.getKpi(KpiType.AVERAGE_BASKET), devices),
        KpiType.COST_PER_CLICK to KpiCalculator(KpiFactory.getKpi(KpiType.COST_PER_CLICK), devices),
        KpiType.RATE_PER_CLICK to KpiCalculator(KpiFactory.getKpi(KpiType.RATE_PER_CLICK), devices),
        KpiType.ROI to KpiCalculator(KpiFactory.getKpi(KpiType.ROI), devices),
        KpiType.ROI_PER_DEVICE to KpiCalculator(KpiFactory.getKpi(KpiType.ROI_PER_DEVICE), devices),
        KpiType.TURNOVER_PER_DEVICE to KpiCalculator(KpiFactory.getKpi(KpiType.TURNOVER_PER_DEVICE), devices),
        KpiType.TURNOVER_PER_MONTH_PER_YEAR to KpiCalculator(
            KpiFactory.getKpi(KpiType.TURNOVER_PER_MONTH_PER_YEAR),
            devices
        )
    )

    displayMenu()
    readInput(kpiToCalculators)
}

fun displayMenu() {
    println("Afficher les KPI:")
    println("1. Le chiffre d’affaires par mois par année")
    println("2. Le chiffre d’affaires par appareil")
    println("3. Le panier moyen : Chiffre d’affaires / Commandes")
    println("4. Le coût par clic : Coût / Clics")
    println("5. Le taux de clic : (Clics /impression) * 100")
    println("6. Le ROI : CA Total / Coût ")
    println("7. Le ROI segmenté par appareil et par mois (uniquement sur 2017)")
    println("8. QUITTER")
    println()
}

fun readInput(kpiToCalculators: Map<KpiType, KpiCalculator>) {
    val scanner = Scanner(System.`in`)

    try {
        do {
            val number = scanner.nextInt()

            if (number != 8) {
                val type = KpiType.values()[number - 1]
                kpiToCalculators[type]?.computeKpi()

                clearScreen()
                displayMenu()
            }
        } while (number != 8)

        clearScreen()
        println("Bye!")
    } catch (e: Exception) {
        readInput(kpiToCalculators)
    }
}

fun clearScreen() {
    val os = System.getProperty("os.name")
    if (os.contains("Windows")) {
        Runtime.getRuntime().exec("cls")
    } else {
        Runtime.getRuntime().exec("clear")
    }
}
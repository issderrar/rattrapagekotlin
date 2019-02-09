package com.issderrar.kpi

import com.issderrar.Device
import com.jakewharton.fliptables.FlipTable

class TurnoverPerMonthPerYearCalculator : KpiStrategy {

    override fun computeKpi(devices: List<Device>) {

        val turnoverGroupedByYear = devices.groupBy { it.year }
        turnoverGroupedByYear.forEach { year, devices ->

            val turnoverGroupedByMonth = devices.groupBy { it.month }

            val headers = arrayOf("Mois", "CA")
            val count = turnoverGroupedByMonth.size
            val data = Array(size = count) { Array(size = 2) { "" } } // String[count][2]

            var index = 0
            turnoverGroupedByMonth.forEach { month, devicesMonth ->
                val row = data[index]
                row[0] = "$month"
                row[1] = "${devicesMonth.sumBy { it.ca }}"
                index++
            }

            val outerHeaders = arrayOf("Annees", "CA par mois")
            val size = devices.groupBy { it.year }.size
            val outerData = Array(size = size) { Array(size = 2) { "" } } // String[size][2]

            val row = outerData[0]
            row[0] = "$year"
            row[1] = FlipTable.of(headers, data)

            println(FlipTable.of(outerHeaders, outerData))
        }
    }
}
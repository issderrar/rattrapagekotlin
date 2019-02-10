package com.issderrar.kpi

import com.issderrar.Device
import com.jakewharton.fliptables.FlipTable

class ROIPerDevicePerMonthCalculator : KpiStrategy {
    override fun computeKpi(devices: List<Device>) {
        val RoiGroupedByDevice = devices.groupBy { it.device }
        RoiGroupedByDevice.forEach { device, devices ->

            val RoiGroupedByMonth = devices.groupBy { it.month }

            val headers = arrayOf("Mois", "ROI")
            val count = RoiGroupedByMonth.size
            val data = Array(size = count) { Array(size = 2) { "" } } // String[count][2]

            var index = 0
            RoiGroupedByMonth.forEach { month, devicesMonth ->
                val row = data[index]
                row[0] = "$month"
                row[1] = "${(devicesMonth.sumBy { it.ca })/(devicesMonth.sumBy{it.cost}.toDouble())}"
                index++
            }
            val outerHeaders = arrayOf("Appareil", "CA par mois")
            val size = devices.groupBy { it.device }.size
            val outerData = Array(size = size) { Array(size = 2) { "" } } // String[size][2]

            val row = outerData[0]
            row[0] = "$device"
            row[1] = FlipTable.of(headers, data)

            println(FlipTable.of(outerHeaders, outerData))
        }
    }
}

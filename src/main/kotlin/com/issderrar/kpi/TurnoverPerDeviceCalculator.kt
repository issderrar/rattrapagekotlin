package com.issderrar.kpi

import com.issderrar.Device
import com.jakewharton.fliptables.FlipTable

class TurnoverPerDeviceCalculator : KpiStrategy {
    override fun computeKpi(devices: List<Device>) {
        val headers = arrayOf("Appareil", "CA")
        val count = devices.groupBy { it.device }.count()
        val data = Array(size = count) { Array(size = 2) { "" } } // String[count][2]
        var index = 0

        val turnoverGroupedByDevice = devices.groupBy { it.device }
        turnoverGroupedByDevice.forEach { device, items ->
            val row = data[index]
            row[0] = "$device"
            row[1] = "${items.sumBy { it.ca }}"
            index++
        }
        println(FlipTable.of(headers, data))
        println()
    }
}
package com.issderrar.kpi

import com.issderrar.Device

interface KpiStrategy {
    fun computeKpi(devices: List<Device>)
}
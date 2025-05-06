package com.example.bostatask.feature.data.model

data class CityModel(
    val `data`: List<Data>,
    val message: String,
    val success: Boolean
)

data class Data(
    val cityCode: String,
    val cityId: String,
    val cityName: String,
    val cityOtherName: String,
    val districts: List<District>,
    val dropOffAvailability: Boolean,
    val pickupAvailability: Boolean,
    var isExpanded: Boolean = false
)

data class District(
    val coverage: String,
    val districtId: String,
    val districtName: String,
    val districtOtherName: String,
    val dropOffAvailability: Boolean,
    val isBusy: Boolean,
    val notAllowedBulkyOrders: Boolean,
    val pickupAvailability: Boolean,
    val zoneId: String,
    val zoneName: String,
    val zoneOtherName: String
)
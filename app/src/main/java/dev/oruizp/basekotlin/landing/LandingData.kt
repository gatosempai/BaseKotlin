package dev.oruizp.basekotlin.landing

data class LandingData(
    val title: String = "",
    val feature: LandingFeature = LandingFeature.ROOM
)
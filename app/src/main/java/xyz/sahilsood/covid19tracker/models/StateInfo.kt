package xyz.sahilsood.covid19tracker.models


class StateInfo : ArrayList<StateInfo.StateInfoItem>() {
    data class StateInfoItem(
        val covid19Site: String,
        val covid19SiteOld: String,
        val covid19SiteSecondary: String,
        val fips: String,
        val name: String,
        val notes: String,
        val pui: String,
        val pum: Boolean,
        val state: String,
        val twitter: String
    )
}
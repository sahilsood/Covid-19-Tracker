package xyz.sahilsood.covid19tracker.models


import com.google.gson.annotations.SerializedName

data class Summary(
    @SerializedName("Countries")
    val countries: List<Country>? = emptyList(),
    @SerializedName("Date")
    val date: String? = "",
    @SerializedName("Global")
    val global: Global
) {
    data class Country(
        @SerializedName("Country")
        val country: String? = "",
        @SerializedName("CountryCode")
        val countryCode: String? = "",
        @SerializedName("Date")
        val date: String? = "",
        @SerializedName("NewConfirmed")
        val newConfirmed: Int? = 0,
        @SerializedName("NewDeaths")
        val newDeaths: Int? = 0,
        @SerializedName("NewRecovered")
        val newRecovered: Int? = 0,
        @SerializedName("Slug")
        val slug: String? = "",
        @SerializedName("TotalConfirmed")
        val totalConfirmed: Int? = 0,
        @SerializedName("TotalDeaths")
        val totalDeaths: Int? = 0,
        @SerializedName("TotalRecovered")
        val totalRecovered: Int? = 0
    )

    data class Global(
        @SerializedName("NewConfirmed")
        val newConfirmed: Int? = 0,
        @SerializedName("NewDeaths")
        val newDeaths: Int? = 0,
        @SerializedName("NewRecovered")
        val newRecovered: Int? = 0,
        @SerializedName("TotalConfirmed")
        val totalConfirmed: Int? = 0,
        @SerializedName("TotalDeaths")
        val totalDeaths: Int? = 0,
        @SerializedName("TotalRecovered")
        val totalRecovered: Int? = 0
    )
}
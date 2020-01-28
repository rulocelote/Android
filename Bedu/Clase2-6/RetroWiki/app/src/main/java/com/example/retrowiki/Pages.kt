package com.example.retrowiki

import com.google.gson.annotations.SerializedName

data class Pages (
    @SerializedName("pages") var pages:TipoPage
) {}
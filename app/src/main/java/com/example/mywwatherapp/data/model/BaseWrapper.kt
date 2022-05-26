package com.example.mywwatherapp.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
 data class BaseWrapper <T>(
       val data :T
  )
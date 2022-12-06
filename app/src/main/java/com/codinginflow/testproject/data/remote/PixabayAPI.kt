package com.codinginflow.testproject.data.remote

import com.codinginflow.testproject.util.Constants
import com.codinginflow.testproject.data.remote.responses.ImageResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayAPI {

    @GET("/api/")
    suspend fun searchForImage(
        @Query("q") searchQuery: String,
        @Query("key") apiKey: String = Constants.API_KEY
    ): Response<ImageResponse>
}
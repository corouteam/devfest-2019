package com.github.corouteam.devfestlevante_2019

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {
        private var retrofit: Retrofit? = null

        private fun getClient(): Retrofit {
            if (retrofit == null) {

                val okHttpClientBuilder = OkHttpClient.Builder()

                val gson = GsonBuilder()
                    .create()

                retrofit = Retrofit.Builder()
                    .baseUrl("https://www.episodate.com")
                    .client(okHttpClientBuilder.build())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
            }

            return retrofit!!
        }

        fun getWebservice(): Webservice {
            return getClient().create(Webservice::class.java)
        }
    }
}
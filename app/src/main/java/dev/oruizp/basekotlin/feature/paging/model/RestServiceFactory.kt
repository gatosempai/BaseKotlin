package dev.oruizp.basekotlin.feature.paging.model

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestServiceFactory {

    /**
     * Creates a retrofit service from an arbitrary class (clazz)
     *
     * @param clazz    Java interface of the retrofit service
     * @param endPoint REST endpoint url
     * @return retrofit service with defined endpoint
     */
    fun <T> createRetrofitService(clazz: Class<T>?, endPoint: String = ""): T {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client =
            OkHttpClient.Builder().addInterceptor(interceptor).build()
        val restAdapter = Retrofit.Builder()
            .baseUrl(endPoint)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return restAdapter.create(clazz)
    }
}
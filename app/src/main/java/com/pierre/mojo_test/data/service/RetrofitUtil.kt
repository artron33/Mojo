package com.pierre.mojo_test.data.service

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

object RetrofitUtil {
    private val loggingInterceptor: HttpLoggingInterceptor by lazy {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        interceptor
    }

    fun buildRestAdapter(
        context: Context,
        endPoint: String,
        isTrackingRequest: Boolean
    ): Retrofit {
        val timeoutClient = getTimeOutedClient(
            context,
            loggingInterceptor,
            isTrackingRequest
        )

        return Retrofit.Builder()
            .baseUrl(endPoint)
            .client(timeoutClient)
            .addConverterFactory(GsonConverterFactory.create(GsonUtils.gson))
            .build()
    }

    private fun getTimeOutedClient(
        context: Context,
        httpLoggingInterceptor: HttpLoggingInterceptor,
        isTrackingRequest: Boolean
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)

        return builder.build()
    }
}

/**
 * We really want no cache here
 * Apps can @override the BASE_URL, when Apps re-define
 * the
 * <string name="base_url">"http://nextBaseUrl.com"</String>
 */
fun Context.getRetrofitWithCacheNotEnabled(): Retrofit {
    return RetrofitUtil.buildRestAdapter(
        this,
        "https://ptitchevreuil.github.io/mojo",
        false
    )
}


object GsonUtils {
    val gson: Gson = GsonBuilder()
        .create()
}
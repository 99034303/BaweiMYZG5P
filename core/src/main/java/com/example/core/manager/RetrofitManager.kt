package com.example.core.manager

import com.example.core.BuildConfig
import com.example.core.app.BaseApp
import com.zy.net.api.TokenApi
import com.zy.net.common.Constant
import com.zy.storage.SPUtils
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitManager {
    private lateinit var retrofit:Retrofit

    init {
        getRetrofit()
    }
     fun getRetrofit(){
        retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASEURL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(getClient())
            .build()
    }

    private fun getClient(): OkHttpClient {
        var okhttp = OkHttpClient.Builder()
            .readTimeout(1,TimeUnit.MINUTES)
            .writeTimeout(1,TimeUnit.MINUTES)
            .addInterceptor(gethttplog())
            .addInterceptor(createTokenIntereptor())
            .build()
        return okhttp

    }

//    private fun getMyInterce(): Interceptor {
//        return Interceptor {
//            val request = it.request()
//            val build = request.newBuilder()
//                .addHeader("Authorization","bearer ")
//                .addHeader("content-type","application/json")
//                .build()
//            it.proceed(build)
//        }
//    }
    /**
     * 处理后台Token
     */
    private fun createTokenIntereptor(): Interceptor {
        val interceptor= Interceptor {

//            it.proceed(it.request())
            val request = it.request()
            var response:Response?

            val localToken = SPUtils.get(BaseApp.appContext, Constant.Token_KEY, "") as String
            if (localToken.isNotBlank()){
                response = doRequest(it, createNewRequest(request, localToken))
            }else{
                response = it.proceed(request)
            }
            if (check401(response!!)){
                requestNewToken(chain = it, request = request)
            }else{
                response
            }

//
        }

        return interceptor
    }

    private fun requestNewToken(chain: Interceptor.Chain,request: Request):Response{
        val token = requestToken();
        val response = doRequest(chain, createNewRequest(request, token))
        SPUtils.put(BaseApp.appContext,Constant.Token_KEY,token)
        return response
    }

    private fun doRequest(chain: Interceptor.Chain,request: Request):Response{

        return chain.proceed(request)
    }

    private fun createNewRequest(request: Request, token:String):Request{
        val newBuilder =
            request.newBuilder().addHeader("Authorization", "bearer $token")

        val newRequest = newBuilder.build()
        return newRequest
    }

    private fun requestToken():String {
        val tokenApi = create(TokenApi::class.java)
        val token = tokenApi.getToken("password", BuildConfig.VERIFYCODE, "")
        val result = token!!.execute()
        return result.body()?.getAccess_token()?:""
    }

    private fun check401(response: Response): Boolean {
        if (response.code()==401){
            return true
        }
        return false
    }


    private fun gethttplog(): Interceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }
    fun <T> create(service:Class<T>):T{
        return retrofit.create(service)
    }

}
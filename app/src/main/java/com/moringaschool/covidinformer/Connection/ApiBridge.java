package com.moringaschool.covidinformer.Connection;

import static com.moringaschool.covidinformer.BuildConfig.x_rapidapi_key;
import static com.moringaschool.covidinformer.Constant.RAPID_BASE_URL;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiBridge {
   private static Retrofit retrofit = null;

   public static ApiConn getClient() {
       if (retrofit == null) {
           OkHttpClient okHttpClient = new OkHttpClient.Builder()
                   .addInterceptor(new Interceptor() {
                       @Override
                       public Response intercept(Chain chain) throws IOException {
                           Request newRequest = chain.request().newBuilder()
                                   .addHeader("authorization", x_rapidapi_key)
                                   .build();
                           return chain.proceed(newRequest);
                       }
                   })
                   .build();
           retrofit = new Retrofit.Builder()
                   .baseUrl(RAPID_BASE_URL)
                   .client(okHttpClient)
                   .addConverterFactory(GsonConverterFactory.create())
                   .build();
       }
       return retrofit.create(ApiConn.class);
   }
}

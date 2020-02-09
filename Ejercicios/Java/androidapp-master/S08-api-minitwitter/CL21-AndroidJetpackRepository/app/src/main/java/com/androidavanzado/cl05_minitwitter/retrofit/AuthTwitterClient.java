package com.androidavanzado.cl05_minitwitter.retrofit;

import com.androidavanzado.cl05_minitwitter.common.Constantes;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AuthTwitterClient {
    private static AuthTwitterClient instance = null;
    private AuthTwitterService miniTwitterService;
    private Retrofit retrofit;

    public AuthTwitterClient() {
        // Incluir en la cabecera de la petición el TOKEN que autoriza al usuario
        //El interceptor lo usaremos para adjuntar a cada peticion la informaicon del token
        //en la cabecera del interceptor
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.addInterceptor(new AuthInterceptor());
        OkHttpClient cliente = okHttpClientBuilder.build();

        retrofit = new Retrofit.Builder()
                .baseUrl(Constantes.API_MINITWITTER_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(cliente)
                .build();

        miniTwitterService = retrofit.create(AuthTwitterService.class);
    }

    // Patrón Singleton
    public static AuthTwitterClient getInstance() {
        if(instance == null) {
            instance = new AuthTwitterClient();
        }
        return instance;
    }

    public AuthTwitterService getAuthTwitterService() {
        return miniTwitterService;
    }


}

package ru.strongit.wunderweather;

import android.app.Application;

import java.util.concurrent.TimeUnit;


import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
//import ru.strongit.wunderweather.modelGeoCode.GoogleMapsApi;


/**
 * Created by user on 07.06.17.
 */

public class WunderWeatherApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        init_stetho();

    }

    public static class OkHttpClientBuilder {
        protected static OkHttpClient configureClient() {
            OkHttpClient client = null;
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.readTimeout(180, TimeUnit.SECONDS);
            builder.addNetworkInterceptor(new StethoInterceptor());
            client = builder.build();
            return client;
        }

        public static OkHttpClient createClient() {
            return configureClient();
        }
    }

    private void init_stetho() {
        // Create an InitializerBuilder
        Stetho.InitializerBuilder initializerBuilder = Stetho.newInitializerBuilder(this);

        // Enable Chrome DevTools
        initializerBuilder.enableWebKitInspector(
                Stetho.defaultInspectorModulesProvider(this)
        );

        // Enable command line interface
        initializerBuilder.enableDumpapp(
                Stetho.defaultDumperPluginsProvider(this)
        );

        // Use the InitializerBuilder to generate an Initializer
        Stetho.Initializer initializer = initializerBuilder.build();

        // Initialize Stetho with the Initializer
        Stetho.initialize(initializer);

        OkHttpClient okClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
    }
}

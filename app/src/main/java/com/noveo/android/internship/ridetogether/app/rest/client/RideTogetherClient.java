package com.noveo.android.internship.ridetogether.app.rest.client;

import com.google.gson.*;
import com.noveo.android.internship.ridetogether.app.rest.service.EventsService;
import com.noveo.android.internship.ridetogether.app.rest.service.RoutesService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.lang.reflect.Type;
import java.util.Date;

/**
 * Created by arty on 19.03.16.
 */
public class RideTogetherClient {
    private static final String BASE_URL = "http://private-27d7ee-ridetogetherapi.apiary-mock.com/";
    private static final RideTogetherClient instance = new RideTogetherClient();
    private EventsService eventsService;
    private RoutesService routesService;
    private Retrofit retrofit;

    private RideTogetherClient() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(java.util.Date.class, new JsonSerializer<java.util.Date>() {
            @Override
            public JsonElement serialize(java.util.Date src, Type typeOfSrc, JsonSerializationContext context) {
                return new JsonPrimitive(src.getTime() / 1000);
            }
        });

        builder.registerTypeAdapter(java.util.Date.class, new JsonDeserializer<java.util.Date>() {
            @Override
            public java.util.Date deserialize(com.google.gson.JsonElement p1, java.lang.reflect.Type p2,
                                              com.google.gson.JsonDeserializationContext p3) {
                return new java.util.Date(p1.getAsLong() * 1000);
            }
        });
        Gson gson = builder.create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        eventsService = retrofit.create(EventsService.class);
        routesService = retrofit.create(RoutesService.class);
    }

    public static RideTogetherClient getInstance() {
        return instance;
    }

    public EventsService getEventsService() {
        return eventsService;
    }

    public RoutesService getRoutesService() {
        return routesService;
    }
}
package com.example.net.utils;

import com.google.gson.Gson;

public class GsonUtils {
    private Gson gson;
    private GsonUtils(){}
    private static class GsonUtilsHandler{
        private static GsonUtils INSTANCE = new GsonUtils();
    }

    public static GsonUtils getInstance(){
        return GsonUtilsHandler.INSTANCE;
    }


    public synchronized Gson getGson(){
        if (gson == null){
            gson = new Gson();
        }
        return gson;
    }
}

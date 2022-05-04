package me.sakuratao.cps_watcher.api;

import org.jetbrains.annotations.NotNull;

public class APIProvide {

    private static API api = null;

    public APIProvide() {
    }

    @NotNull
    public static API getApi() {

        if (api == null){
            throw new NullPointerException("ERROR#API_NOTFOUND");
        }

        return api;
    }

    public static void setApi(API var) {
        api = var;
    }

}

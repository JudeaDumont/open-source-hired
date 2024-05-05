package com.example.servlets.V2;

import com.example.model.KnownPhrasesPool.KnownPhrasesPool;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;


@Path("api/v2/keypool")
public class KeyPoolConfiguration {

    public KeyPoolConfiguration() {

    }

    //Testing purposes only, will clobber the pool with a new one
    @POST
    @Path("set")
    public String setKeyPool(
            @FormDataParam("keyPool") String keyPool) {

        KnownPhrasesPool.setFromJson(keyPool);

        return "Success";
    }

    //this is more for tests that require a pool reset to huge.
    @GET
    @Path("loadProdPool")
    public String loadProdPool() {
        KnownPhrasesPool.loadProdPool();
        return "Success";
    }
}

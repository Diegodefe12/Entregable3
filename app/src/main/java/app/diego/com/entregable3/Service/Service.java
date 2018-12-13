package app.diego.com.entregable3.Service;

import app.diego.com.entregable3.Model.POJO.Obra;
import app.diego.com.entregable3.Model.POJO.ObrasContainer;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {

        @GET("x858r")
        Call<ObrasContainer> getObrasContainer();
}

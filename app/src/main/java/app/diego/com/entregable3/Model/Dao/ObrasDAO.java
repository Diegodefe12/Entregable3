package app.diego.com.entregable3.Model.Dao;

import java.util.List;

import app.diego.com.entregable3.Model.POJO.Obra;
import app.diego.com.entregable3.Model.POJO.ObrasContainer;
import app.diego.com.entregable3.Service.Service;
import app.diego.com.entregable3.Util.ResultListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ObrasDAO extends ObrasRetrofit {

    private static final String BASE_URL = "https://api.myjson.com/bins/";
    private Service service;

    public ObrasDAO() {
        super(BASE_URL);
        service = retrofit.create(Service.class);
    }

    public void getObrasContainer(final ResultListener<ObrasContainer> listenerDeLaView) {
        //Creo la llamada pidiendosela al service, pasandole por parámetro el dato necesario
        Call<ObrasContainer> call = service.getObrasContainer();
        //Encolo la llamada
        call.enqueue(new Callback<ObrasContainer>() {
            @Override
            //Método que se ejecuta si salió bien
            public void onResponse(Call<ObrasContainer> call, Response<ObrasContainer> response) {
                //Recibo la información en el parámetro response, dentro del body
                //le aviso al controller, ejecutando el método finish del listener
                // y pasandole por parámetro la información correspondiente
                listenerDeLaView.finish(response.body());
            }

            @Override
            public void onFailure(Call<ObrasContainer> call, Throwable t) {
                t.printStackTrace();
            }

        });


    }
}

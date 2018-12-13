package app.diego.com.entregable3.Controller;

import java.util.List;

import app.diego.com.entregable3.Model.Dao.ObrasDAO;
import app.diego.com.entregable3.Model.POJO.Obra;
import app.diego.com.entregable3.Model.POJO.ObrasContainer;
import app.diego.com.entregable3.Util.ResultListener;

public class ObrasController {

    public void getObrasContainer(final ResultListener<ObrasContainer> listenerDeLaView){
        //Instancio un DAO
        ObrasDAO obrasDAO = new ObrasDAO();
        //Pido al DAO
        obrasDAO.getObrasContainer(new ResultListener<ObrasContainer>() {
            @Override
            //Método que se ejecuta cuando el DAO me avisa que el pedido terminó
            public void finish(ObrasContainer result) {
                //Recibo la información y le aviso a la vista,
                //ejecutando el método finish del listener y pasandole por parámetro
                //la información correspondiente
                listenerDeLaView.finish(result);
            }
        });

    }

}

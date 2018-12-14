package app.diego.com.entregable3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import app.diego.com.entregable3.Adapter.ObrasAdapter;
import app.diego.com.entregable3.Controller.ObrasController;
import app.diego.com.entregable3.Model.POJO.ObrasContainer;
import app.diego.com.entregable3.Util.ResultListener;

public class MainActivity extends AppCompatActivity {
    private TextView textViewPrueba;
    private ObrasAdapter adapter;
    private RecyclerView recyclerViewObras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*
        pegarFragment(new HomeFragment());


*/

        getObras();

        recyclerViewObras = findViewById(R.id.activityMain_recyclerView);



        adapter = new ObrasAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerViewObras.setLayoutManager(linearLayoutManager);
        recyclerViewObras.setAdapter(adapter);
        recyclerViewObras.setHasFixedSize(true);




    }

/*    public void pegarFragment(Fragment unFragment) {

        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainActivityContenedor, unFragment).commit();

    }*/

    public void getObras() {
        //Instancio un controller
        ObrasController obrasController = new ObrasController();
        //Pido al controller pasandole el listener del tipo del resultado esperado
        obrasController.getObrasContainer(new ResultListener<ObrasContainer>() {
            @Override
            //Método que se ejecuta cuando el controller me avisa que el pedido terminó
            public void finish(ObrasContainer result) {
                //Recibo la información correspondiente
                adapter.setListaDeObras(result.getPaints());
            }
        });
    }
}

package app.diego.com.entregable3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import app.diego.com.entregable3.Adapter.ObrasAdapter;
import app.diego.com.entregable3.Controller.ObrasController;
import app.diego.com.entregable3.Model.POJO.Obra;
import app.diego.com.entregable3.Model.POJO.ObrasContainer;
import app.diego.com.entregable3.Util.ResultListener;

public class MainActivity extends AppCompatActivity implements ObrasAdapter.ListenerObrasAdapter{
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



        adapter = new ObrasAdapter(this);
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
        ObrasController obrasController = new ObrasController();
        obrasController.getObrasContainer(new ResultListener<ObrasContainer>() {
            @Override
            public void finish(ObrasContainer result) {
                adapter.setListaDeObras(result.getPaints());
            }
        });
    }


    @Override
    public void informarSeleccionado(Obra obra) {

        Intent intent = new Intent(MainActivity.this, DetalleActivity.class);

        Bundle bundle = new Bundle();

        bundle.putSerializable(DetalleActivity.KEY_OBRA,obra);
        intent.putExtras(bundle);
        startActivity(intent);
    }


}

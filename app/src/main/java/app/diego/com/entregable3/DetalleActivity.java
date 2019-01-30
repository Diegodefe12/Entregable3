package app.diego.com.entregable3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import app.diego.com.entregable3.Model.POJO.Obra;

public class DetalleActivity extends AppCompatActivity {
    public static final String KEY_OBRA = "object_obra";
    private TextView name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        name = findViewById(R.id.detalleActivity_TextView_nombreArtista);

        Intent unIntent = getIntent();
        Bundle unBundle = unIntent.getExtras();
        Obra obra = (Obra) unBundle.getSerializable(KEY_OBRA);

        name.setText(obra.getName());





    }
}

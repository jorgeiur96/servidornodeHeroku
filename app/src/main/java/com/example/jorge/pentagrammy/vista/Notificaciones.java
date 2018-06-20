package com.example.jorge.pentagrammy.vista;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jorge.pentagrammy.R;
import com.example.jorge.pentagrammy.adaptadores.RestAPIAdapter;
import com.example.jorge.pentagrammy.modelo.UsuarioResponse;
import com.example.jorge.pentagrammy.restApi.EndPoints;
import com.google.firebase.iid.FirebaseInstanceId;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Notificaciones extends AppCompatActivity {
EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaciones);
        e1 =(EditText)findViewById(R.id.txtiduser);
    }


    public  void  lanzarNotificacion(View v){

           /* Intent i = new Intent(this, MainActivity.class);

            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, PendingIntent.FLAG_ONE_SHOT);

            Uri sonido = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

            NotificationCompat.Builder notificacion = new NotificationCompat.Builder(this, CHANNEL_ID)
                    .setSmallIcon(R.drawable.icono)
                    .setContentTitle("Notificacion")
                    .setContentText("hola mundo")
                    .setSound(sonido)
                    .setContentIntent(pendingIntent)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setAutoCancel(true);
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(0, notificacion.build());*/


        String token = FirebaseInstanceId.getInstance().getToken();
        String idUsuarioIntagram=e1.getText()+"";
        Log.d("Token",token);

        RestAPIAdapter restAPIAdapter =new RestAPIAdapter();
        EndPoints endPoints =restAPIAdapter.establecerConexionRestApi();
        final Call<UsuarioResponse> usuarioResponseCall =endPoints.registrarTokenId(token,idUsuarioIntagram);


        usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {

                UsuarioResponse usuarioResponse= response.body();
                Log.d("ID_FIREBASE",usuarioResponse.getId_dispositivo());
                Log.d("Usuario_FIREBASE",usuarioResponse.getId_usuario_instagram());


            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {

            }
        });

mensaje(v,"datos  guardados");



    }
    public  void mensaje(View v,String men){

        Snackbar.make(v, men, Snackbar.LENGTH_LONG)
                .show();

    }



}

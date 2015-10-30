package kumo.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.j256.ormlite.android.AndroidConnectionSource;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Console;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConversacionActivity extends AppCompatActivity {

    private RecyclerView recView;

    public ConversacionActivity() {
        // Required empty public constructor
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversacion);

        recView = (RecyclerView) findViewById(R.id.RecView);
        recView.setHasFixedSize(true);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


       try {

           DatabaseHelper databaseHelper = OpenHelperManager.getHelper(this,DatabaseHelper.class);

           Dao<Usuario, Integer> usuarioDao = databaseHelper.getDao();

           Usuario usu = new Usuario();
           usu.id = 2;
           usu.Nombre = "Albert";
           usu.Apellidos = "Rubio";
           usu.DNI = "4123123";
           usu.Imagen_Perfil = "asdasdsad";

          // usuarioDao.create(usu);

           Usuario usu2 = usuarioDao.queryForId(2);

           Log.d("Account", usu2.Nombre);

           /*String databaseUrl = "jdbc:h2:mem:account";
           // create a connection source to our database
           ConnectionSource connectionSource = new AndroidConnectionSource(databaseUrl);
           accountDao = DaoManager.createDao(connectionSource, Usuario.class);

           TableUtils.createTableIfNotExists(connectionSource, Usuario.class);

           Usuario usu = new Usuario();
           usu.id = "123";
           usu.Nombre = "Albert";

           accountDao.create(usu);

           Usuario usu2 = accountDao.queryForId("123");

           Log.d("Account", usu2.Nombre);

           connectionSource.close();*/


       }catch(Exception x){

           Log.d("objeto",x.getMessage());
       }


        HashMap<String, String> params = new HashMap<String, String>();

        /*final JsonObject jsonObject = new JsonObject();


        //Sense parametres
        GsonRequest<Usuario[]> getPersons =
                new GsonRequest<Usuario[]>(Request.Method.POST,"https://www.kmed.es/Android_API/Home/Usuario", Usuario[].class,params,jsonObject,

                        new Response.Listener<Usuario[]>() {
                            @Override
                            public void onResponse(Usuario[] response) {
                                List<Usuario> persons = Arrays.asList(response);

                                final AdapterUsuarioListado adaptador = new AdapterUsuarioListado(persons);

                                recView.setAdapter(adaptador);

                                recView.setLayoutManager(
                                        new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
                            }

                        }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("objeto",error.getMessage());
                        // TODO deal with error
                    }
                });

        HttpCola.getInstance(this).addToRequestQueue(getPersons);
*/
        //Amb parametres


         final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_codigo_acceso", "nmonfulleda");
        jsonObject.addProperty("_prefijo", "34");
        jsonObject.addProperty("_movil", "650595821");



        GsonRequest<Configuracion[]> getPersons =
                new GsonRequest<Configuracion[]>(Request.Method.POST,"http://localhost:32765/Usuarios/obt_aplicaciones", Configuracion[].class,params,jsonObject,

                        new Response.Listener<Configuracion[]>() {
                            @Override
                            public void onResponse(Configuracion[] response) {
                                List<Configuracion> persons = Arrays.asList(response);

                                configuraciones_respuesta(persons);
                                /*final AdapterConfiguracionListado adaptador = new AdapterConfiguracionListado(persons);

                                recView.setAdapter(adaptador);

                                recView.setLayoutManager(
                                        new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));*/

                            }

                        }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("objeto",error.getMessage());
                        // TODO deal with error
                    }
                });

        HttpCola.getInstance(this).addToRequestQueue(getPersons);

    }

    protected void configuraciones_respuesta(List<Configuracion> _configuracion)
    {

        final AdapterConfiguracionListado adaptador = new AdapterConfiguracionListado(_configuracion);

        recView.setAdapter(adaptador);

        recView.setLayoutManager(
                new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));


        HashMap<String, String> params = new HashMap<String, String>();



        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_id_aplicacion", _configuracion.get(0).Id_Aplicacion);
        jsonObject.addProperty("_id_usuario", _configuracion.get(0).Id_Usuario);
        jsonObject.addProperty("_id_usuario_clase", _configuracion.get(0).Id_Usuario_Clase);
        jsonObject.addProperty("_clave", "nmonfulleda");



        GsonRequest<Usuario> getPersons2 =
                new GsonRequest<Usuario>(Request.Method.POST,"http://localhost:32765/Usuarios/autentificar", Usuario.class,params,jsonObject,

                        new Response.Listener<Usuario>() {
                            @Override
                            public void onResponse(Usuario response) {
                                Usuario persons = response;
                                //List<Usuario> persons = Arrays.asList(response);

                                Log.d("acabem","hem pintat tot");

                                /*final AdapterConfiguracionListado adaptador = new AdapterConfiguracionListado(persons);

                                recView.setAdapter(adaptador);

                                recView.setLayoutManager(
                                        new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));*/

                            }

                        }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("objeto",error.getMessage());
                        // TODO deal with error
                    }
                });

        HttpCola.getInstance(this).addToRequestQueue(getPersons2);
    }

}


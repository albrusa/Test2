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

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Console;
import java.util.Arrays;
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

       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        GsonRequest<Usuario[]> getPersons =
                new GsonRequest<Usuario[]>("https://www.kmed.es/Android_API/Home/Usuario", Usuario[].class,

                        new Response.Listener<Usuario[]>() {
                            @Override
                            public void onResponse(Usuario[] response) {
                                List<Usuario> persons = Arrays.asList(response);

                                final AdapterUsuarioListado adaptador = new AdapterUsuarioListado(persons);

                                recView.setAdapter(adaptador);

                                recView.setLayoutManager(
                                        new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

                                /*FeedReaderDbHelper usdbh = new FeedReaderDbHelper(getApplicationContext(), "myapplication.db", null, 1);

                                SQLiteDatabase db = usdbh.getWritableDatabase();

                                if(db != null)
                                {
                                    String json = new Gson().toJson(persons);

                                    db.execSQL("INSERT INTO Cache (id, texto) " + "VALUES (" + 1 + ", '" + json +"')");

                                }*/
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
}


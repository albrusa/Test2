package kumo.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ConversacionesListado extends Fragment {

    private RecyclerView recView;

    private ArrayList<xElementoList> datos;

    public ConversacionesListado() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View _view =  inflater.inflate(R.layout.fragment_conversaciones_listado, container, false);

        recView = (RecyclerView) _view.findViewById(R.id.RecView);
        recView.setHasFixedSize(true);

        datos = new ArrayList<xElementoList>();
        for(int i=0; i<50; i++)
            datos.add(new xElementoList("Conversacion " + i, "Subtítulo conversacion " + i));

        final AdapterElementoListado adaptador = new AdapterElementoListado(datos);

        recView.setAdapter(adaptador);

        recView.setLayoutManager(
                new LinearLayoutManager(_view.getContext(), LinearLayoutManager.VERTICAL, false));

        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ConversacionActivity.class);

                Bundle b = new Bundle();
                //  b.putString("EXTRA_MESSAGE", editText.getText().toString());

              //  intent.putExtras(b);
                startActivity(intent);
            }
        });


        return _view;
    }
}
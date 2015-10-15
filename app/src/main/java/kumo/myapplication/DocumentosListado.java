package kumo.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by alber on 14/10/2015.
 */
public class DocumentosListado  extends Fragment {

    private RecyclerView recView;

    private ArrayList<xElementoList> datos;

    public DocumentosListado() {
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
            datos.add(new xElementoList("Documento " + i, "Subtítulo documento " + i));

        final AdapterElementoListado adaptador = new AdapterElementoListado(datos);

        recView.setAdapter(adaptador);

        recView.setLayoutManager(
                new LinearLayoutManager(_view.getContext(), LinearLayoutManager.VERTICAL, false));

        //recView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        recView.setItemAnimator(new DefaultItemAnimator());

        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("DemoRecView", "Conversacion " + recView.getChildLayoutPosition(v));
            }
        });

        return _view;
    }
}

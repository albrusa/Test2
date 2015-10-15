package kumo.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by alber on 14/10/2015.
 */
public class AdapterElementoListado extends RecyclerView.Adapter<AdapterElementoListado.AdapterElementoViewHolder> implements View.OnClickListener{

    private ArrayList<xElementoList> datos;
    private View.OnClickListener listener;

    public AdapterElementoListado(ArrayList<xElementoList> datos) {
        this.datos = datos;
    }

    public static class AdapterElementoViewHolder
            extends RecyclerView.ViewHolder {

        private TextView txtTitulo;
        private TextView txtSubtitulo;

        public AdapterElementoViewHolder(View itemView) {
            super(itemView);

            txtTitulo = (TextView)itemView.findViewById(R.id.LblTitulo);
            txtSubtitulo = (TextView)itemView.findViewById(R.id.LblSubTitulo);
        }

        public void bindTitular(xElementoList t) {
            txtTitulo.setText(t.getTitulo());
            txtSubtitulo.setText(t.getSubtitulo());
        }
    }

    @Override
    public AdapterElementoViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.elemento_listado_item, viewGroup, false);

        AdapterElementoViewHolder tvh = new AdapterElementoViewHolder(itemView);

        itemView.setOnClickListener(this);

        return tvh;
    }

    @Override
    public void onBindViewHolder(AdapterElementoViewHolder viewHolder, int pos) {
        xElementoList item = datos.get(pos);

        viewHolder.bindTitular(item);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null)
            listener.onClick(view);
    }

}

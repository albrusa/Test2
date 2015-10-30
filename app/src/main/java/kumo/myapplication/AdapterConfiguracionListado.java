package kumo.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

/**
 * Created by alber on 14/10/2015.
 */
public class AdapterConfiguracionListado extends RecyclerView.Adapter<AdapterConfiguracionListado.AdapterElementoViewHolder> implements View.OnClickListener{

    private List<Configuracion> datos;
    private View.OnClickListener listener;

    public AdapterConfiguracionListado(List<Configuracion> datos) {
        this.datos = datos;
    }

    public static class AdapterElementoViewHolder
            extends RecyclerView.ViewHolder {

        private TextView txtTitulo;
        private TextView txtSubtitulo;
        RequestQueue mRequestQueue;
        NetworkImageView mNetworkImageView;
        ImageLoader mImageLoader;
        private static final String IMAGE_URL =
                "http://developer.android.com/images/training/system-ui.png";



        public AdapterElementoViewHolder(View itemView) {
            super(itemView);

            txtTitulo = (TextView)itemView.findViewById(R.id.LblTitulo);
            txtSubtitulo = (TextView)itemView.findViewById(R.id.LblSubTitulo);
            mNetworkImageView = (NetworkImageView) itemView.findViewById(R.id.networkImageView);


        }

        public void bindTitular(Configuracion t) {
            txtTitulo.setText(t.Aplicacion);
            txtSubtitulo.setText(t.Id_Aplicacion);

            ImageLoader.ImageCache imageCache = new LruBitmapCache(itemView.getContext());

            mImageLoader = HttpCola.getInstance(itemView.getContext()).getImageLoader();

            if(t.Ruta_Imagen_Aplicacion != null && t.Ruta_Imagen_Aplicacion != "")
            {
                mNetworkImageView.setImageUrl(t.Ruta_Imagen_Aplicacion, mImageLoader);
            }


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
        Configuracion item = datos.get(pos);

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

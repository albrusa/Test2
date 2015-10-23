package kumo.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alber on 14/10/2015.
 */
public class AdapterUsuarioListado extends RecyclerView.Adapter<AdapterUsuarioListado.AdapterElementoViewHolder> implements View.OnClickListener{

    private List<Usuario> datos;
    private View.OnClickListener listener;

    public AdapterUsuarioListado(List<Usuario> datos) {
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

        public void bindTitular(Usuario t) {
            txtTitulo.setText(t.Nombre);
            txtSubtitulo.setText(t.Apellidos);

            ImageLoader.ImageCache imageCache = new LruBitmapCache(itemView.getContext());

            mImageLoader = HttpCola.getInstance(itemView.getContext()).getImageLoader();

            if(t.Imagen != null && t.Imagen != "")
            {
                mNetworkImageView.setImageUrl(t.Imagen, mImageLoader);
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
        Usuario item = datos.get(pos);

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

package kumo.myapplication;

/**
 * Created by alber on 14/10/2015.
 */
public class xElementoList {

    private String titulo;
    private String subtitulo;

    public xElementoList(String tit, String sub){
        titulo = tit;
        subtitulo = sub;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getSubtitulo(){
        return subtitulo;
    }
}

package kumo.myapplication;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by dev_2 on 16/10/2015.
 */

@DatabaseTable(tableName = "Usuario")
public class Usuario {

    @DatabaseField(id = true)
    Integer id;


    String Codigo_Acceso;
    String Clave;

    @DatabaseField
    String Nombre;

    @DatabaseField
    String Apellidos;

    String Prefijo;
    String Tlf_Movil;
    String Correo;
    String Idioma;

    @DatabaseField
    String DNI;

    @DatabaseField
    String Imagen_Perfil;

    public Usuario(){

    }

}
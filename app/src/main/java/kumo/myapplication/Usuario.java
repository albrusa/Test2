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

    @DatabaseField
    String Nombre;

    @DatabaseField
    String Apellidos;

    @DatabaseField
    String DNI;

    @DatabaseField
    String Imagen;

    public Usuario(){

    }

}

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.sqlite.Config_BD;

public class BaseDatos extends SQLiteOpenHelper {

    public BaseDatos (Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super (context, name, factory, version);
    }
    public void onCreate(SQLiteDatabase base_datos){
        /*String table_autor = "CREATE TABLE autor(" +
                "pk_autor INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre varchar(100)not null, " +
                "primer_apellido varchar(100) not null, "+
                "segundo_apellido varchar(100) not null, " +
                "FOREIGN KEY(pk_autor) REFERENCES autor (pk_autor)" +
                ");";
                */

        //
        for(String query: Config_BD.script_bd){
            base_datos.execSQL(query);
        }
        //base_datos.execSQL(table_autor);
    }
}


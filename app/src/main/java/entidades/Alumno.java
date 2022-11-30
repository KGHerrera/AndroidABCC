package entidades;
import androidx.annotation.NonNull;
import androidx.room.*;

@Entity  //Java Annotations
public class Alumno {

    @NonNull
    @PrimaryKey
    private String nunControl;

    @NonNull
    @ColumnInfo(name = "nombre")
    private String nombre;

    public Alumno() {
    }

    public Alumno(@NonNull String numControl, String nombre) {
        this.nunControl = numControl;
        this.nombre = nombre;
    }

    @NonNull
    public String getNunControl() {
        return nunControl;
    }

    public void setNunControl(@NonNull String nunControl) {
        this.nunControl = nunControl;
    }

    @NonNull
    public String getNombre() {
        return nombre;
    }

    public void setNombre(@NonNull String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nunControl='" + nunControl + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}

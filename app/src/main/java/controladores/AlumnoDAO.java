package controladores;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import entidades.Alumno;

@Dao
public interface AlumnoDAO {

    //Altas-----------------------------------------------------------------------------
    @Insert
    public void agregarAlumno(Alumno a); //agreagr UN SOLO alumno

    @Insert
    public void agregarAlumnos(Alumno...alumnos); //agregar MUCHOS alumnos

    //Bajas-----------------------------------------------------------------------------
    @Delete
    void delete(Alumno a); //borrar sin SQL


    @Query("DELETE FROM alumno WHERE nunControl = :nc")  //borrar con SQL
    int eliminarPorNumeroDeControl(String nc);

    //Cambios -----------------------------------------------------------------------------
    @Query("UPDATE alumno SET nombre= :n WHERE nunControl = :nc")
    int modificarPorNumeroDeControl(String nc, String n);

    //Consultas-----------------------------------------------------------------------------
    @Query("SELECT * FROM alumno")
    List<Alumno> obtenerTodos();

    @Query("SELECT * FROM alumno WHERE nombre LIKE :n")
    List<Alumno> findByNombre(String n);

    @Query("SELECT * FROM alumno WHERE nunControl LIKE :nc")
    List<Alumno> findByNumControl(String nc);

}

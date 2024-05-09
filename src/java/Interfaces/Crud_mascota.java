package Interfaces;


import Modelo.Mascota;
import java.util.List;

public interface Crud_mascota {
 public List ListarMascota();
    public Mascota Obtener(int id);
    public boolean Agregar(Mascota pac);
    public boolean Editar(Mascota pac);    
    public boolean Eliminar(int id);
}

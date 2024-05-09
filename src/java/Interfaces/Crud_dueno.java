package Interfaces;


import Modelo.Dueno;
import java.util.List;

public interface Crud_dueno {
 public List ListarDueno();
    public Dueno Obtener(int id);
    public boolean Agregar(Dueno due);
    public boolean Editar(Dueno due);    
    public boolean Eliminar(int id);
}

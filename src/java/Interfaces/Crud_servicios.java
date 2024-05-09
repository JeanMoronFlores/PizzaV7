package Interfaces;

import Modelo.Servicios;
import java.util.List;

public interface Crud_servicios {
 public List ListarServicios();
    public Servicios Obtener(int id);
    public boolean Agregar(Servicios ser);
    public boolean Editar(Servicios ser);    
    public boolean Eliminar(int id);
}

package Interfaces;

import Modelo.Especialidad;
import java.util.List;

public interface Crud_especialidad {
 public List ListarEspecialidades();
    public Especialidad Obtener(int id);
    public boolean Agregar(Especialidad esp);
    public boolean Editar(Especialidad esp);    
    public boolean Eliminar(int id);
}

package Interfaces;

import Modelo.EstadoCita;
import java.util.List;

public interface Crud_estadocita {
 public List ListarEstadoCita();
    public EstadoCita Obtener(int id);
    public boolean Agregar(EstadoCita est);
    public boolean Editar(EstadoCita est);    
    public boolean Eliminar(int id);
}

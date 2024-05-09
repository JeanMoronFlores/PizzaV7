package Interfaces;

import Modelo.Cita;
import java.util.List;

public interface Crud_cita {
 public List ListarCita();
    public Cita Obtener(int id);
    public boolean Agregar(Cita cit);
    public boolean Editar(Cita cit);    
    public boolean Eliminar(int id);
}

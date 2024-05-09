package Interfaces;

import Modelo.Veterinario;
import java.util.List;

public interface Crud_medico {
 public List ListarMedicos();
    public Veterinario Obtener(int id);
    public boolean Agregar(Veterinario med);
    public boolean Editar(Veterinario med);    
    public boolean Eliminar(int id);
}

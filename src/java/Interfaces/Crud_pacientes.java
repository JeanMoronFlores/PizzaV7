package Interfaces;


import Modelo.Paciente;
import java.util.List;

public interface Crud_pacientes {
 public List ListarPacientes();
    public Paciente Obtener(int id);
    public boolean Agregar(Paciente pac);
    public boolean Editar(Paciente pac);    
    public boolean Eliminar(int id);
}

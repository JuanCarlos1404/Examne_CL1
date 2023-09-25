package repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cibertec.ExamenCL1.Empleado;

public interface RepositorioEmpleado extends JpaRepository<Empleado, Integer> {

    List<Empleado> findByApellidos(String apellidos);

    List<Empleado> findByNombres(String nombres);

    List<Empleado> findByEdad(int edad);

    List<Empleado> findBySexo(char sexo);

    List<Empleado> findBySalario(double salario);

}
package Controlador;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.cibertec.ExamenCL1.Empleado;

import repositorio.RepositorioEmpleado;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    private final RepositorioEmpleado empleadoRepository;

    public EmpleadoController(RepositorioEmpleado empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @PostMapping
    public Empleado crearEmpleado(@RequestBody Empleado empleado) {

     
        if (empleado.getApellidos().isEmpty()) {
            throw new RuntimeException("El campo apellidos es obligatorio");
        }

        if (empleado.getNombres().isEmpty()) {
            throw new RuntimeException("El campo nombres es obligatorio");
        }

        if (empleado.getEdad() < 18) {
            throw new RuntimeException("La edad debe ser mayor o igual a 18");
        }

        if (empleado.getSalario() < 1500 || empleado.getSalario() > 2500) {
            throw new RuntimeException("El salario debe estar entre 1500 y 2500");
        }

 
        return empleadoRepository.save(empleado);

    }

    @GetMapping
    public List<Empleado> listarEmpleados() {
        return empleadoRepository.findAll();
    }
    @GetMapping("/")
    public String index() {
        return "index";
    }

}
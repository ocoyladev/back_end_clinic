package dh.backend.test;
import dh.backend.dao.impl.PacienteEnMemoria;
import dh.backend.model.Domicilio;
import dh.backend.model.Paciente;
import dh.backend.service.PacienteService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PacienteEnMemoriaTest {
    private static PacienteService pacienteService = new PacienteService(new PacienteEnMemoria()) ;

    @Test
    @DisplayName("Testear que un paciente fue guardado")
    void testPacienteGuardado(){
        Paciente paciente = new Paciente("Juan","Ramirez","70790074", LocalDate.of(2024,2,9), new Domicilio("Calle Falsa", 456, "Springfield","Montana"));
        Paciente pacienteDesdeLaMemoria = pacienteService.registrarPaciente(paciente);

        assertNotNull(pacienteDesdeLaMemoria);
    }

    @Test
    @DisplayName("Testear búsqueda paciente por id")
    void testPacientePorId(){
        Paciente paciente = new Paciente("Juan","Ramirez","70790074", LocalDate.of(2024,2,9), new Domicilio("Calle Falsa", 456, "Springfield","Montana"));
        pacienteService.registrarPaciente(paciente);
        Integer id = 1;
        Paciente pacienteEncontrado = pacienteService.buscarPorId(id);

        assertEquals(id, pacienteEncontrado.getId());
    }

    @Test
    @DisplayName("Testear búsqueda todos los pacientes")
    void testBusquedaTodos(){
        Paciente paciente = new Paciente("Juan","Ramirez","70790074", LocalDate.of(2024,2,9), new Domicilio("Calle Falsa", 456, "Springfield","Montana"));
        pacienteService.registrarPaciente(paciente);

        List<Paciente> pacientes = pacienteService.buscarTodos();

        assertEquals(1,pacientes.size());

    }

}

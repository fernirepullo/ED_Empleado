import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class EmpleadoTestParametrizado {

    private String nombre, oficio;
    private String codEmpleado, codDepartamento;
    private int expResult;

    public EmpleadoTestParametrizado(String nombre, String codEmpleado, String oficio, String codDepartamento, int expResult){

        this.nombre = nombre;
        this.codEmpleado = codEmpleado;
        this.oficio = oficio;
        this.codDepartamento = codDepartamento;
        this.expResult = expResult;
    }

    @Parameters
    public static ArrayList <Object[]> datosEmpleado(){

        ArrayList<Object[]> obj = new ArrayList<>();

        //EMPLEADOS VÁLIDOS
        obj.add(new Object[] {"Pepe", "1", "Analista", "12", 2500});
        obj.add(new Object[] {"Luis", "31", "Programador", "01", 2000});
        obj.add(new Object[] {"Marisa", "144", "Diseñador", "55", 1500});
        obj.add(new Object[] {"Marcos", "02", "Programador", "66", 2000});
        
        // EMPLEADOS NO VÁLIDOS
        obj.add(new Object[] {"Paco", "A", "Analista", "21", 2500});
        obj.add(new Object[] {"", "55", "Programador", "29", 2000});
        obj.add(new Object[] {"Pepi", "09", "Diseñador", "E", 1500});
        obj.add(new Object[] {"", "", "", "", 2000});



        return obj;
    }



    @Test
    public void almacenarOficioYSalarioTest() {

        Empleado empleado = new Empleado(this.nombre, this.codEmpleado, this.oficio, this.codDepartamento);

        System.out.println("Almacenar Oficio y Salario");


        try{

            empleado.almacenarOficioYSalario();

            int salario = empleado.getSalario();

            assertEquals(expResult, salario);

        } catch (Exception e){

            System.out.println(e);
        }

    }

    @Test
    public void comprobarNombreTest() {

        Empleado empleado = new Empleado(this.nombre, this.codEmpleado, this.oficio, this.codDepartamento);

        System.out.println("Comprobar nombre");

        try{

            empleado.comprobarNombre();

            assertNotNull(empleado.getNombre());
            assertFalse(empleado.getNombre().isBlank());
            assertFalse(empleado.getNombre().matches("^[0-9]$"));

        } catch (Exception e){

            System.out.println(e);
        }

    }

    @Test
    public void almacenarCodEmpleadoTest() {

        Empleado empleado = new Empleado(this.nombre, this.codEmpleado, this.oficio, this.codDepartamento);

        System.out.println("Comprobar código del empleado");

        try{

            empleado.almacenarCodEmpleado();

            System.out.println(empleado.getCodEmpleado());

            assertTrue(Integer.parseInt(empleado.getCodEmpleado()) > 0);
            assertTrue(empleado.getCodEmpleado().length() <= 3);
            assertFalse(empleado.getCodEmpleado().matches("^[a-zA-Z]$"));

        } catch (Exception e){

            System.out.println(e);
        }


    }

    @Test
    public void comprobarDepartamento() {

        Empleado empleado = new Empleado(this.nombre, this.codEmpleado, this.oficio, this.codDepartamento);

        System.out.println("Comprobar código de departamento");

        try{

            empleado.almacenarDepartamento();

            assertTrue(Integer.parseInt(empleado.getCodDepartamento()) > 0);
            assertTrue(empleado.getCodDepartamento().length() <= 2);
            assertFalse(empleado.getCodDepartamento().matches("^[a-zA-Z]$"));

        } catch (Exception e){

            System.out.println(e);
        }

    }
}

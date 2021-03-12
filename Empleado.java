import java.util.ArrayList;

public class Empleado {

    private String nombre, oficio;
    private int salario;
    private String codEmpleado, codDepartamento;
    private ArrayList <String> listaEmpleados;

    private final String minCodEmpleado = "000";
    private final String minCodDepartamento = "00";

    private final int salarioAnalista = 2500;
    private final int salarioDiseñador = 1500;
    private final int salarioProgramador = 2000;


    public String getNombre(){

        return nombre;
    }

    public String getOficio(){

        return oficio;
    }

    public String getCodEmpleado(){

        return codEmpleado;
    }

    public String getCodDepartamento(){

        return codDepartamento;
    }

    public int getSalario(){

        return salario;
    }

    public ArrayList<String> getListaEmpleados(){

        return listaEmpleados;
    }

    public void setNombre(String nombre){

        this.nombre = nombre;
    }

    public void setCodEmpleado(String codEmpleado) {

        this.codEmpleado = codEmpleado;
    }

    public void setCodDepartamento(String codDepartamento) {

        this.codDepartamento = codDepartamento;
    }

    public void setOficio(String oficio) {

        this.oficio = oficio;
    }

    public void setSalario(int salario) {

        this.salario = salario;
    }

    public Empleado(){

    }

    public Empleado(String nombre, String codEmpleado, String oficio, String codDepartamento){

        this.nombre = nombre;
        this.codEmpleado = codEmpleado;
        this.oficio = oficio;
        this.codDepartamento = codDepartamento;

    }

    @Override
    public String toString() {
        return "Empleado{ " +
                "nombre = '" + nombre + '\'' +
                ", oficio = '" + oficio + '\'' +
                ", codEmpleado = " + codEmpleado +
                ", departamento = " + codDepartamento +
                ", salario = " + salario + '€' +
                '}';
    }

    public void almacenarOficioYSalario(){

        char[] chOficio = oficio.toCharArray();

        if (oficio.isEmpty()){

            System.out.println("Error ER3, el oficio no puede estar vacío");
            System.exit(0);
        }

        else if(Character.isDigit(chOficio.length)){

            System.out.println("Error ER3, el oficio no puede contener un número");
            System.exit(0);
        }

        else {

            oficio = oficio.toUpperCase();

            if (oficio.equals("ANALISTA")){

                setOficio(oficio);
                setSalario(salarioAnalista);
                System.out.println("Oficio y salario almacenado");
            }

            else if(oficio.equals("DISEÑADOR")){

                setOficio(oficio);
                setSalario(salarioDiseñador);
                System.out.println("Oficio y salario almacenado");

            }

            else{

                setOficio(oficio);
                setSalario(salarioProgramador);
                System.out.println("Oficio y salario almacenado");
            }

        }

    }

    public void comprobarNombre(){

        char[] chNombre = nombre.toCharArray();

        if(nombre.isEmpty()){

            System.out.println("Error, el nombre no puede estar vacío");
            System.exit(0);
        }

        else{

            for (int i = 0; i <= chNombre.length; i++){

                if (String.valueOf(chNombre[i]).matches("^[0-9]$")){

                    System.out.println("Error, el nombre no puede contener dígitos");
                    System.exit(0);

                }

                else{

                    setNombre(nombre);
                    System.out.println("Nombre almacenado");
                    break;

                }

            }
        }

    }

    public void almacenarCodEmpleado(){

        char[] charCodeEmpleado = codEmpleado.toCharArray();


        if(codEmpleado.length() == 0){

            System.out.println("Error ER1. El código del empleado no puede estar vacío.");
            System.exit(0);
        }

        else if(codEmpleado.length() > 3){

            System.out.println("Error ER1. El código del empleado no puede ser superior a 3 dígitos.");
            System.exit(0);
        }

        else {

            for (int i = 0; i < charCodeEmpleado.length; i++) {

                if (String.valueOf(charCodeEmpleado[i]).matches("^[a-zA-Z]$")) {

                    System.out.println("Error ER1, el código del empleado solo puede contener dígitos positivos");
                    System.exit(0);

                }

                else {

                    if (codEmpleado.length() == 1){

                        codEmpleado = "00" + codEmpleado;
                    }

                    else if (codEmpleado.length() == 2){

                        codEmpleado = "0" + codEmpleado;
                    }

                    int codEmp = Integer.parseInt(codEmpleado);
                    int minCodEmp = Integer.parseInt(minCodEmpleado);

                    if (codEmp < minCodEmp) {

                        System.out.println("Error ER1. El código del empleado no puede ser menor o igual que cero");
                        System.exit(0);

                    }

                    else {


                        setCodEmpleado(codEmpleado);
                        System.out.println("Código de empleado almacenado");
                        break;
                    }
                }

            }
        }

    }

    public void almacenarDepartamento(){

        char[] chCodDep = codDepartamento.toCharArray();

        if(codDepartamento.length() == 0){

            System.out.println("Error ER2. El código del departamento no puede estar vacío.");
            System.exit(0);
        }

        else if(codDepartamento.length() > 2){

            System.out.println("Error ER2, el código del departamento no puede contenr más de dos dígitos");
            System.exit(0);

        }


        else {

            for (int i = 0; i < chCodDep.length; i++) {

                if (String.valueOf(chCodDep[i]).matches("^[a-zA-Z]$")) {

                    System.out.println("Error ER2. El departamento solo puede estar comprendido por dígitos positivos");
                    System.exit(0);

                }

                if (codDepartamento.length() == 1){

                    codDepartamento = "0" + codDepartamento;
                }

                else{

                    int codDep = Integer.parseInt(codDepartamento);
                    int minCodDep = Integer.parseInt(minCodDepartamento);

                    if (codDep < minCodDep) {

                        System.out.println("Error ER2. El departamento no puede ser inferior o igual a 00");
                        System.exit(0);
                    }


                    else {

                        setCodDepartamento(codDepartamento);
                        System.out.println("Departamento almacenado");
                    }
                }

            }

        }
    }

    public void add(){

        listaEmpleados = new ArrayList<>();

        listaEmpleados.add(toString());

    }

}

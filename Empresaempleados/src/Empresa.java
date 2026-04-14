import java.util.ArrayList;
import java.util.List;

public class Empresa{

    private String nombre;
    private String direccion;
    private int nit;
    private String telefono;
    private List<Empleado> listEmpleados;


    /**
     * Metodo constructor de la clase empresa
     * @param nombre de la empresa
     * @param direccion de la empresa
     * @param nit de la empresa
     * @param telefono de la empresa
     */
    public Empresa(String nombre, String direccion, int nit, String telefono ){
        this.nombre=nombre;
    this.direccion=direccion;
    this.nit=nit;
    this.telefono=telefono;
    this.listEmpleados = new ArrayList<>();
    }

    /**
     * Metodo para burcar un empleado por el numero de documento
     * @param documento del empleado a buscar
     * @return empleado
     */
    public  Empleado buscarEmpleado(String documento) {
        for (Empleado e : listEmpleados) {
            if (e.getDocumento().equals(documento)) {
                return e;
            }
        }
        return null;
    }

    /**
     * Metodo para agregar un nuevo empleado de ventas
     * @param nombre del empleado
     * @param documento del empleado
     * @param edad del empleado
     * @param salarioBase del empleado
     * @param descuentoSalud del empleado
     * @param descuentoPension del empleado
     * @param categoriaEmpleado del empleado
     * @param totalVentas del empleado
     * @param porcentajeComision del empleado
     * @return respuesta
     */
    public String agregarEmpleadoVentas (String nombre, String documento,int edad, float salarioBase,
                                         float descuentoSalud, float descuentoPension, CategoriaEmpleado categoriaEmpleado,float totalVentas,
                                         float porcentajeComision){
        String respuesta = "";
        Empleado e = buscarEmpleado(documento);
        if (e != null) {
            respuesta = "El empleado ya existe";
        } else {
            EmpleadoVentas empleadoV = new EmpleadoVentas(nombre, documento, edad, salarioBase, descuentoSalud, descuentoPension, categoriaEmpleado, totalVentas, porcentajeComision);
            listEmpleados.add(empleadoV);
            respuesta = "El empleado ha sido agregado";
        }
        return respuesta;
    }

    /**
     * Metodo para agregar un nuevo empleado de planta
     * @param nombre del empleado
     * @param documento del empleado
     * @param edad del empleado
     * @param salarioBase del empleado
     * @param descuentoSalud del empleado
     * @param descuentoPension del empleado
     * @param categoriaEmpleado del empleado
     * @param cargo del empleado
     * @param horasExtras del empleado
     * @param valorHoraExtra del empleado
     * @param auxilioTransporte del empleado
     * @return respuesta
     */
    public String agregarEmpleadoPlanta (String nombre, String documento, int edad, float salarioBase,float descuentoSalud, float descuentoPension, CategoriaEmpleado categoriaEmpleado, String cargo, int horasExtras, float valorHoraExtra, float auxilioTransporte){
        String respuesta = "";
        Empleado e = buscarEmpleado(documento);
        if (e != null) {
            respuesta = "El empleado ya existe";
        } else {
            EmpleadoPlanta empleadoP = new EmpleadoPlanta(nombre, documento, edad, salarioBase, descuentoSalud, descuentoPension, categoriaEmpleado, cargo, horasExtras, valorHoraExtra, auxilioTransporte);
            listEmpleados.add(empleadoP);
            respuesta = "El empleado ha sido agregado";
        }
        return respuesta;
    }

    /**
     * Metodo para agregar un nuevo empleado temporal
     * @param nombre del empleado
     * @param documento del empleado
     * @param edad del empleado
     * @param salarioBase del empleado
     * @param descuentoSalud del empleado
     * @param descuentoPension del empleado
     * @param categoriaEmpleado del empleado
     * @param diasTrabajados del empleado
     * @param valorDia del empleado
     * @return respuesta
     */
    public String agregarEmpleadoTemporal (String nombre, String documento, int edad, float salarioBase,float descuentoSalud, float descuentoPension, CategoriaEmpleado categoriaEmpleado, int diasTrabajados, float valorDia){
        String respuesta = "";
        Empleado e = buscarEmpleado(documento);
        if (e != null) {
            respuesta = "El empleado ya existe";
        } else {
            EmpleadoTemporal empleadoT = new EmpleadoTemporal(nombre, documento, edad, salarioBase, descuentoSalud, descuentoPension, categoriaEmpleado, diasTrabajados, valorDia);
            listEmpleados.add(empleadoT);
            respuesta = "El empleado ha sido agregado";
        }
        return respuesta;
    }

    /**
     * Metodo para mostrar a todos los empleados de la empresa
     * @return lista
     */
    public String mostrarEmpleados() {
        String lista = "";

        if (listEmpleados.isEmpty()) {
            return "No hay empleados registrados.";
        }
        for (Empleado e : listEmpleados) {
            lista += e.mostrarInformacion() + "\n";
        }
        return lista;
    }


    /**
     * Metodo para mostar el empleado que gana mas
     * @return empleado
     */
    public Empleado empleadoMayorSalario() {
        if (listEmpleados.isEmpty()) {
            return null;
        }

        Empleado mayor = listEmpleados.get(0);

        for (Empleado e : listEmpleados) {
            if (e.calcularSalarioNeto() > mayor.calcularSalarioNeto()) {
                mayor = e;
            }
        }

        return mayor;
    }

    /**
     * Metodo para calcular la nomina mensual
     * @return nominaMensual
     */
    public float calcularNominaMensual(){
        float nominaMensual = 0;
        for(Empleado e: listEmpleados){
            nominaMensual += e.calcularSalarioNeto();
        }
        return nominaMensual;
    }

    /**
     * Método para mostrar el resumen de pagos
     * @return lista
     */
    public String mostrarResumenPagos() {
        if (listEmpleados.isEmpty()) {
            return "No hay empleados registrados.";
        }

        String lista = "";
        for (Empleado e : listEmpleados) {
            lista += e.generarResumenPago() + "\n";
        }
        return lista;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Empleado> getListEmpleados() {
        return listEmpleados;
    }

    public void setListEmpleados(List<Empleado> listEmpleados) {
        this.listEmpleados = listEmpleados;
    }
}

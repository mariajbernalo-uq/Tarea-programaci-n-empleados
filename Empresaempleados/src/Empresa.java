import java.util.List;

public class Empresa{

    private String nombre;
    private String direccion;
    private int nit;
    private String telefono;
    private List<Empleado> listEmpleados;



    public Empresa(String nombre, String direccion, int nit, String telefono ){
        this.nombre=nombre;
    this.direccion=direccion;
    this.nit=nit;
    this.telefono=telefono;
    }

    public  Empleado buscarEmpleado(String documento) {
        for (Empleado e : listEmpleados) {
            if (e.getDocumento().equals(documento)) {
                return e;
            }
        }
        return null;
    }

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

    public String mostrarEmpleados(){
        String lista="";
        for(Empleado e : listEmpleados){
            lista+=e;
        }
        return lista;
    }


    //Empleado que gana más <------------------------------
    public Empleado empleadoMayorSalario(){
        for(Empleado e : listEmpleados){
            e.getSalarioBase();
        }
    }

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

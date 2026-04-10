import java.util.List;

public abstract class Empleado {
    protected String nombre;
    protected String documento;
    protected int edad;
    protected float salarioBase;
    protected float descuentoSalud;
    protected float descuentoPension;
    private CategoriaEmpleado categoriaEmpleado;
    private List<ResumenPago> listResumenPagos;

    public Empleado(String nombre, String documento, int edad, float salarioBase,float descuentoSalud, float descuentoPension, CategoriaEmpleado categoriaEmpleado){
        this.nombre=nombre;
        this.documento= documento;
        this.edad=edad;
        this.salarioBase=salarioBase;
        this.descuentoSalud=descuentoSalud;
        this.descuentoPension=descuentoPension;
        this.categoriaEmpleado =categoriaEmpleado;
    }

    public String mostrarInformacionEmpleado(Empleado empleado){
        String respuesta="";
        if(empleado==null){
            respuesta="El empleado no existe";
        } else{
            respuesta= "El empleado con nombre:"+ empleado.getNombre()+" "+empleado.getDocumento()+ getEdad()+ getSalarioBase();
        }
        return respuesta;
    }
    public abstract float calcularSalarioBruto();

    public abstract float calcularSalarioNeto();

    public abstract float calcularBonificacionCategoria();
    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public int getEdad() {
        return edad;
    }

    public float getSalarioBase() {
        return salarioBase;
    }

    public float getDescuentoSalud() {
        return descuentoSalud;
    }

    public float getDescuentoPension() {
        return descuentoPension;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSalarioBase(float salarioBase) {
        this.salarioBase = salarioBase;
    }

    public void setDescuentoSalud(float descuentoSalud) {
        this.descuentoSalud = descuentoSalud;
    }

    public void setDescuentoPension(float descuentoPension) {
        this.descuentoPension = descuentoPension;
    }


}


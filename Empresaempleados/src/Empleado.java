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

    /**
     * Metodo constructor de la clase empleado
     * @param nombre del empleado
     * @param documento del empleado
     * @param edad del empleado
     * @param salarioBase del empleado
     * @param descuentoSalud del empleado
     * @param descuentoPension del empleado
     * @param categoriaEmpleado del empleado
     */
    public Empleado(String nombre, String documento, int edad, float salarioBase,float descuentoSalud, float descuentoPension, CategoriaEmpleado categoriaEmpleado) throws Validaciones {
        if (salarioBase < 0) {
            throw new Validaciones("El salario base no puede ser negativo");
        }
        if (descuentoSalud < 0 || descuentoSalud > 100){
            throw new Validaciones("El porcentaje en salud debe ser entre 0 y 100");
        }
        if (descuentoPension < 0 || descuentoPension > 110){
            throw new Validaciones("El porcentaje de pensión debe ser entre 0 y 100");
        }
        this.nombre = nombre;
        this.documento= documento;
        this.edad=edad;
        this.salarioBase=salarioBase;
        this.descuentoSalud=descuentoSalud;
        this.descuentoPension=descuentoPension;
        this.categoriaEmpleado =categoriaEmpleado;
    }

    /**
     * Metodo para mostrar la informacion de un empleado
     * @param empleado datos del empleado
     * @return respuesta
     */
    public String mostrarInformacionEmpleado(Empleado empleado){
        String respuesta="";
        if(empleado==null){
            respuesta="El empleado no existe";
        } else{
            respuesta= "El empleado con nombre:"+ empleado.getNombre()+" "+empleado.getDocumento()+ getEdad()+ getSalarioBase();
        }
        return respuesta;
    }

    /**
     * Metodo abstracto para calcular el salario bruto
     * @return salario bruto
     */
    public abstract float calcularSalarioBruto();

    /**
     * Metodo abstracto para calcular el salario neto
     * @return calcular salario neto
     */
    public abstract float calcularSalarioNeto();

    /**
     * Metodo para calcular la bonificación por categorio de los empleados
     * @return bonificacion
     */
    public float calcularBonificacionCategoria() {
        float bonificacion = 0;
        if (categoriaEmpleado == CategoriaEmpleado.JUNIOR) {
            bonificacion = (float) (salarioBase * 0.05);
        } else if (categoriaEmpleado == CategoriaEmpleado.SEMI_SENIOR) {
            bonificacion = (float) (salarioBase * 0.10);
        } else if (categoriaEmpleado == CategoriaEmpleado.SENIOR) {
            bonificacion = (float) (salarioBase * 0.15);
        }
        return bonificacion;
    }

    /**
     * Metodo para calcular los decuentos de salud
     * @return valorSalus
     */
    public  float calcularDescuentoSalud(){
        float valorSalud = salarioBase * (descuentoSalud / 100);
        return valorSalud;
    }

    /**
     * Metodo para calcular los descuentos de pension
     * @return valorPension
     */
    public float calcularDescuentosPension(){
        float valorPension = salarioBase * (descuentoPension / 100);
        return valorPension;
    }

    /**
     * Metodo para calcular el descuento total del salario bruto de los empleados
     * @return total
     */
    public float calcularDescuentosTotales(){
        float total = calcularDescuentosPension() + calcularDescuentoSalud();
        return total;
    }

    /**
     * Metodo record para el resumen de pago de los empleados
     * @return resumen de pago
     */
    public ResumenPago generarResumenPago() {
        return new ResumenPago(
                this.documento,
                this.nombre,
                this.getClass().getSimpleName(),
                this.calcularSalarioBruto(),
                this.calcularDescuentosTotales(),
                this.calcularSalarioNeto()
        );
    }

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


public class EmpleadoVentas extends Empleado{
    private float totalVentas;
    private float porcentajeComision;

    /**
     * Metodo constructor de la clase empleado ventas
     * @param nombre del empleado de ventas
     * @param documento del empleado de ventas
     * @param edad del empleado de ventas
     * @param salarioBase del empleado de ventas
     * @param descuentoSalud del empleado de ventas
     * @param descuentoPension del empleado de ventas
     * @param categoriaEmpleado del empleado de ventas
     * @param totalVentas del empleado de ventas
     * @param porcentajeComision del empleado de ventas
     */
    public EmpleadoVentas(String nombre, String documento, int edad, float salarioBase,float descuentoSalud, float descuentoPension, CategoriaEmpleado categoriaEmpleado,  float totalVentas, float porcentajeComision) {
        super(nombre,documento, edad, salarioBase, descuentoSalud, descuentoPension, categoriaEmpleado);
        this.totalVentas = totalVentas;
        this.porcentajeComision = porcentajeComision;
    }

    /**
     * Metodo para acalcular el porcentaje de comision de la clase empleado ventas
     * @return comision
     */
    public float calcularComisionVentas(){
        float comision = totalVentas * (porcentajeComision / 100);
        return comision;
    }

    /**
     * Metodo para acalcular el salario bruto de la clase empleado de ventas
     * @return salarioBruto
     */
    @Override
    public float calcularSalarioBruto() {
        float salarioBruto;
        float comision = calcularComisionVentas();
        salarioBruto = salarioBase + comision + calcularBonificacionCategoria();
        return salarioBruto;
    }


    // Getters
    public float getTotalVentas() {
        return totalVentas;
    }

    public float getPorcentajeComision() {
        return porcentajeComision;
    }

    // Setters
    public void setTotalVentas(float totalVentas) {
        this.totalVentas = totalVentas;
    }

    public void setPorcentajeComision(float porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }

}

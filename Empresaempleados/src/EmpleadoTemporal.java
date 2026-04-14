public class EmpleadoTemporal extends Empleado {
    private int diasTrabajados;
    private float valorDia;

    /**
     * Metodo contructor de la clase empleado temporal
     * @param nombre del empleado temporal
     * @param documento del empleado temporal
     * @param edad del empleado temporal
     * @param salarioBase del empleado temporal
     * @param descuentoSalud del empleado temporal
     * @param descuentoPension del empleado temporal
     * @param categoriaEmpleado del empleado temporal
     * @param diasTrabajados del empleado temporal
     * @param valorDia del empleado temporal
     */
    public EmpleadoTemporal(String nombre, String documento, int edad, float salarioBase,float descuentoSalud, float descuentoPension, CategoriaEmpleado categoriaEmpleado, int diasTrabajados, float valorDia) {
        super(nombre,documento, edad, salarioBase, descuentoSalud, descuentoPension, categoriaEmpleado);
        this.diasTrabajados = diasTrabajados;
        this.valorDia = valorDia;
    }

    /**
     * Metodo para acalcular el salario bruto de la clase empleado temporal
     * @return salario bruto
     */
    @Override
    public float calcularSalarioBruto() {
        float bonificacion = calcularBonificacionCategoria();
        float salarioBruto= (diasTrabajados * valorDia) + bonificacion;
        return salarioBruto;
    }

    /**
     * Metodo para acalcular el salario neto de la clase empleado temporal
     * @return salario neto
     */
    @Override
    public float calcularSalarioNeto() {
        float bruto = calcularSalarioBruto();
        float descuentos = calcularDescuentosTotales();
        float salarioNeto = bruto - descuentos;
        return salarioNeto;
    }

    // Getters
    public int getDiasTrabajados() {
        return diasTrabajados;
    }

    public float getValorDia() {
        return valorDia;
    }

    // Setters
    public void setDiasTrabajados(int diasTrabajados) {
        this.diasTrabajados = diasTrabajados;
    }

    public void setValorDia(float valorDia) {
        this.valorDia = valorDia;
    }

}

public class EmpleadoVentas extends Empleado{
    private float totalVentas;
    private float porcentajeComision;

    // Constructor
    public EmpleadoVentas(String nombre, String documento, int edad, float salarioBase,float descuentoSalud, float descuentoPension, CategoriaEmpleado categoriaEmpleado,  float totalVentas, float porcentajeComision) {
        super(nombre,documento, edad, salarioBase, descuentoSalud, descuentoPension, categoriaEmpleado);
        this.totalVentas = totalVentas;
        this.porcentajeComision = porcentajeComision;
    }

    // Salario Bruto
    @Override
    public float calcularSalarioBruto() {
        float salarioBruto= (salarioBase-descuentoSalud)-(descuentoPension);
        return salarioBruto;
    }
    // Salario Neto
    @Override
    public float calcularSalarioNeto() {
        float bruto = calcularSalarioBruto();
        return (bruto)+(totalVentas*porcentajeComision);
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

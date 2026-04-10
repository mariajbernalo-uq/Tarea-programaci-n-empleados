public class EmpleadoTemporal extends Empleado {
    private int diasTrabajados;
    private float valorDia;

    // Constructor
    public EmpleadoTemporal(String nombre, String documento, int edad, float salarioBase,float descuentoSalud, float descuentoPension, CategoriaEmpleado categoriaEmpleado, int diasTrabajados, float valorDia) {
        super(nombre,documento, edad, salarioBase, descuentoSalud, descuentoPension, categoriaEmpleado);
        this.diasTrabajados = diasTrabajados;
        this.valorDia = valorDia;
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
        return (bruto)+(diasTrabajados*valorDia);
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

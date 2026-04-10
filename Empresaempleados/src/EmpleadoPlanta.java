public class EmpleadoPlanta extends Empleado{
    private String cargo;
    private int horasExtras;
    private float valorHoraExtra;
    private float auxilioTransporte;

    // Constructor
    public EmpleadoPlanta(String nombre, String documento, int edad, float salarioBase,float descuentoSalud, float descuentoPension, CategoriaEmpleado categoriaEmpleado, String cargo, int horasExtras, float valorHoraExtra, float auxilioTransporte) {
        super(nombre,documento, edad, salarioBase, descuentoSalud, descuentoPension, categoriaEmpleado);
        this.cargo = cargo;
        this.horasExtras = horasExtras;
        this.valorHoraExtra = valorHoraExtra;
        this.auxilioTransporte = auxilioTransporte;
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
        return (bruto + valorHoraExtra) * horasExtras;
    }

    // Getters
    public String getCargo() {
        return cargo;
    }

    public int getHorasExtras() {
        return horasExtras;
    }

    public float getValorHoraExtra() {
        return valorHoraExtra;
    }

    public float getAuxilioTransporte() {
        return auxilioTransporte;
    }

    // Setters
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setHorasExtras(int horasExtras) {
        this.horasExtras = horasExtras;
    }

    public void setValorHoraExtra(float valorHoraExtra) {
        this.valorHoraExtra = valorHoraExtra;
    }

    public void setAuxilioTransporte(float auxilioTransporte) {
        this.auxilioTransporte = auxilioTransporte;
    }

}


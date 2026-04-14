public class EmpleadoPlanta extends Empleado{
    private String cargo;
    private int horasExtras;
    private float valorHoraExtra;
    private float auxilioTransporte;

    /**
     * Metodo constructor de la clase Empleado planta
     * @param nombre del empleado planta
     * @param documento del empleado planta
     * @param edad del empleado planta
     * @param salarioBase del empleado planta
     * @param descuentoSalud del empleado planta
     * @param descuentoPension del empleado planta
     * @param categoriaEmpleado del empleado planta
     * @param cargo del empleado planta
     * @param horasExtras del empleado planta
     * @param valorHoraExtra del empleado planta
     * @param auxilioTransporte del empleado planta
     */
    public EmpleadoPlanta(String nombre, String documento, int edad, float salarioBase,
                          float descuentoSalud, float descuentoPension, CategoriaEmpleado categoriaEmpleado,
                          String cargo, int horasExtras, float valorHoraExtra, float auxilioTransporte) {
        super(nombre, documento, edad, salarioBase, descuentoSalud, descuentoPension, categoriaEmpleado);

        if (horasExtras < 0) {
            throw new IllegalArgumentException("Las horas extra no pueden ser negativas");
        }

        if (valorHoraExtra < 0) {
            throw new IllegalArgumentException("El valor de la hora extra no puede ser negativo");
        }

        if (auxilioTransporte < 0) {
            throw new IllegalArgumentException("El auxilio de transporte no puede ser negativo");
        }

        this.cargo = cargo;
        this.horasExtras = horasExtras;
        this.valorHoraExtra = valorHoraExtra;
        this.auxilioTransporte = auxilioTransporte;
    }

    /**
     * Metodo para acalcular el salario bruto de la clase empleado planta
     * @return salarioBruto
     */
    @Override
    public float calcularSalarioBruto() {
        float salarioBruto;
        salarioBruto = salarioBase + auxilioTransporte + calcularBonificacionCategoria() + (horasExtras * valorHoraExtra);
        return salarioBruto;
    }


    //Getters
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
        if (horasExtras < 0) {
            throw new IllegalArgumentException("Las horas extra no pueden ser negativas");
        }
        this.horasExtras = horasExtras;
    }

    public void setValorHoraExtra(float valorHoraExtra) {
        if (valorHoraExtra < 0) {
            throw new IllegalArgumentException("El valor de la hora extra no puede ser negativo");
        }
        this.valorHoraExtra = valorHoraExtra;
    }

    public void setAuxilioTransporte(float auxilioTransporte) {
        this.auxilioTransporte = auxilioTransporte;
    }

}


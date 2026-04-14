import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Empresa empresa = new Empresa("Empresa AMX", "Centro N14", 123456789, "123456778");

        int opcion;

        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(
                        "===== MENÚ PRINCIPAL =====\n" +
                                "1. Agregar empleado de planta\n" +
                                "2. Agregar empleado de ventas\n" +
                                "3. Agregar empleado temporal\n" +
                                "4. Mostrar empleados\n" +
                                "5. Buscar empleado\n" +
                                "6. Mayor salario\n" +
                                "7. Nómina total\n" +
                                "8. Resumen de pagos\n" +
                                "9. Salir\n\n" +
                                "Seleccione una opción:"
                ));

                switch (opcion) {
                    case 1:
                        agregarEmpleadoPlanta(empresa);
                        break;
                    case 2:
                        agregarEmpleadoVentas(empresa);
                        break;
                    case 3:
                        agregarEmpleadoTemporal(empresa);
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, empresa.mostrarEmpleados());
                        break;
                    case 5:
                        buscarEmpleadoPorDocumento(empresa);
                        break;
                    case 6:
                        mostrarEmpleadoMayorSalario(empresa);
                        break;
                    case 7:
                        JOptionPane.showMessageDialog(null,
                                "Nómina total: " + empresa.calcularNominaMensual());
                        break;
                    case 8:
                        JOptionPane.showMessageDialog(null,
                                empresa.mostrarResumenPagos());
                        break;
                    case 9:
                        JOptionPane.showMessageDialog(null, "Saliendo...");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción inválida");
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número válido");
                opcion = 0;
            }

        } while (opcion != 9);
    }

    public static void agregarEmpleadoPlanta(Empresa empresa) {
        try {
            String nombre = JOptionPane.showInputDialog("Nombre:");
            String documento = JOptionPane.showInputDialog("Documento:");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad:"));
            float salarioBase = Float.parseFloat(JOptionPane.showInputDialog("Salario base:"));
            float descuentoSalud = Float.parseFloat(JOptionPane.showInputDialog("Descuento salud (%):"));
            float descuentoPension = Float.parseFloat(JOptionPane.showInputDialog("Descuento pensión (%):"));

            CategoriaEmpleado categoria = leerCategoria();

            String cargo = JOptionPane.showInputDialog("Cargo:");
            int horasExtras = Integer.parseInt(JOptionPane.showInputDialog("Horas extras:"));
            float valorHoraExtra = Float.parseFloat(JOptionPane.showInputDialog("Valor hora extra:"));
            float auxilio = Float.parseFloat(JOptionPane.showInputDialog("Auxilio transporte:"));

            String respuesta = empresa.agregarEmpleadoPlanta(
                    nombre, documento, edad, salarioBase,
                    descuentoSalud, descuentoPension, categoria,
                    cargo, horasExtras, valorHoraExtra, auxilio
            );

            JOptionPane.showMessageDialog(null, respuesta);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: valor numérico inválido");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public static void agregarEmpleadoVentas(Empresa empresa) {
        try {
            String nombre = JOptionPane.showInputDialog("Nombre:");
            String documento = JOptionPane.showInputDialog("Documento:");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad:"));
            float salarioBase = Float.parseFloat(JOptionPane.showInputDialog("Salario base:"));
            float descuentoSalud = Float.parseFloat(JOptionPane.showInputDialog("Descuento salud (%):"));
            float descuentoPension = Float.parseFloat(JOptionPane.showInputDialog("Descuento pensión (%):"));

            CategoriaEmpleado categoria = leerCategoria();

            float totalVentas = Float.parseFloat(JOptionPane.showInputDialog("Total ventas:"));
            float porcentajeComision = Float.parseFloat(JOptionPane.showInputDialog("Porcentaje comisión:"));

            String respuesta = empresa.agregarEmpleadoVentas(
                    nombre, documento, edad, salarioBase,
                    descuentoSalud, descuentoPension, categoria,
                    totalVentas, porcentajeComision
            );

            JOptionPane.showMessageDialog(null, respuesta);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: valor numérico inválido");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public static void agregarEmpleadoTemporal(Empresa empresa) {
        try {
            String nombre = JOptionPane.showInputDialog("Nombre:");
            String documento = JOptionPane.showInputDialog("Documento:");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad:"));
            float salarioBase = Float.parseFloat(JOptionPane.showInputDialog("Salario base:"));
            float descuentoSalud = Float.parseFloat(JOptionPane.showInputDialog("Descuento salud (%):"));
            float descuentoPension = Float.parseFloat(JOptionPane.showInputDialog("Descuento pensión (%):"));

            CategoriaEmpleado categoria = leerCategoria();

            int diasTrabajados = Integer.parseInt(JOptionPane.showInputDialog("Días trabajados:"));
            float valorDia = Float.parseFloat(JOptionPane.showInputDialog("Valor por día:"));

            String respuesta = empresa.agregarEmpleadoTemporal(
                    nombre, documento, edad, salarioBase,
                    descuentoSalud, descuentoPension, categoria,
                    diasTrabajados, valorDia
            );

            JOptionPane.showMessageDialog(null, respuesta);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: valor numérico inválido");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public static CategoriaEmpleado leerCategoria() {
        while (true) {
            try {
                int opcion = Integer.parseInt(JOptionPane.showInputDialog(
                        "Seleccione categoría:\n" +
                                "1. JUNIOR\n" +
                                "2. SEMI_SENIOR\n" +
                                "3. SENIOR"
                ));

                switch (opcion) {
                    case 1:
                        return CategoriaEmpleado.JUNIOR;
                    case 2:
                        return CategoriaEmpleado.SEMI_SENIOR;
                    case 3:
                        return CategoriaEmpleado.SENIOR;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción inválida");
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número válido");
            }
        }
    }

    public static void buscarEmpleadoPorDocumento(Empresa empresa) {
        String documento = JOptionPane.showInputDialog("Ingrese documento:");

        Empleado e = empresa.buscarEmpleado(documento);

        if (e != null) {
            JOptionPane.showMessageDialog(null, e.mostrarInformacion());
        } else {
            JOptionPane.showMessageDialog(null, "Empleado no encontrado");
        }
    }

    public static void mostrarEmpleadoMayorSalario(Empresa empresa) {
        Empleado mayor = empresa.empleadoMayorSalario();

        if (mayor != null) {
            JOptionPane.showMessageDialog(null,
                    mayor.mostrarInformacion() +
                            "\nSalario Neto: " + mayor.calcularSalarioNeto());
        } else {
            JOptionPane.showMessageDialog(null, "No hay empleados");
        }
    }
}
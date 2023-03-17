package co.edu.uniquindio.biblioteca.model;

import java.util.ArrayList;

public class Prestamo {
    private String fecha;
    private double total;
    private int tiempoEntrega;
    private String codio;
    private ArrayList<DetallePrestamo> listaDetallePrestamo;
    private Empleado empleadoPrestamo;

    /**
     * Este es constructor de la clase Prestamo
     * @param fecha
     * @param total
     * @param tiempoEntrega
     * @param codio
     */
    public Prestamo(String fecha, double total, int tiempoEntrega, String codio) {
        super();
        this.fecha = fecha;
        this.total = total;
        this.tiempoEntrega = tiempoEntrega;
        this.codio = codio;
        this.listaDetallePrestamo = new ArrayList<DetallePrestamo>();
    }

    public Empleado getEmpleadoPrestamo() {
        return empleadoPrestamo;
    }



    public void setEmpleadoPrestamo(Empleado empleadoPrestamo) {
        this.empleadoPrestamo = empleadoPrestamo;
    }



    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public int getTiempoEntrega() {
        return tiempoEntrega;
    }
    public void setTiempoEntrega(int tiempoEntrega) {
        this.tiempoEntrega = tiempoEntrega;
    }
    public String getCodio() {
        return codio;
    }
    public void setCodio(String codio) {
        this.codio = codio;
    }
    public ArrayList<DetallePrestamo> getListaDetallePrestamo() {
        return listaDetallePrestamo;
    }
    public void setListaDetallePrestamo(ArrayList<DetallePrestamo> listaDetallePrestamo) {
        this.listaDetallePrestamo = listaDetallePrestamo;
    }

    public boolean verificarTotalAutor(String autor, double valor) {
        boolean cumple = false;

        boolean totalVerificado = false;
        boolean autorVerificado = false;

	totalVerificado = verificarTota(valor);
    autorVerificado = verificarAutor(autor);
		if(totalVerificado == true && autorVerificado == true){
			cumple = true;
		}

        return cumple;
    }

    private boolean verificarTota(double valor) {
        return false;
    }

    private boolean verificarAutor(String autor) {
        return false;
    }


    /**
     *
     * @param isbn
     * @return
     */
    public boolean cumpleIsbn(String isbn) {

        for (DetallePrestamo detallePrestamo : listaDetallePrestamo) {
            if(detallePrestamo.cumpleIsbn(isbn)){
                return true;
            }
        }
        return false;
    }


    public boolean cumpleIsbny(String isbn) {

        boolean cumple = false;
        for (DetallePrestamo detallePrestamo : listaDetallePrestamo) {
            if(detallePrestamo.getCantidad() > 10){
                return true;
            }
        }
        return cumple;
    }

    public boolean cumpleIsbnx(String isbn) {

        boolean cumple = false;
        for (DetallePrestamo detallePrestamo : listaDetallePrestamo) {
            if(detallePrestamo.getCantidad() > 10){
                return true;
            }
        }
        return cumple;
    }



    public boolean cumpleLibro(String titulo, int limiteInferior, int limiteSuperior, int aniosExperiencia) {

        for (DetallePrestamo detallePrestamo : listaDetallePrestamo) {
            if(detallePrestamo.cumpleLibro(titulo,limiteInferior,limiteSuperior)){
                return true;
            }
        }
        return false;
    }



    public int obtenerCantidadTipo(Tipo tipo) {
        int cantidad = 0;
        for (DetallePrestamo detallePrestamo : listaDetallePrestamo) {
            if(detallePrestamo.cumpleTipo(tipo)){
                cantidad += detallePrestamo.getCantidad();
            }
        }
        return cantidad;
    }

    /**
     * Retorna una lista de libros prestados segun los parametros ingresados
     * @param lI
     * @param lS
     * @param tipo
     * @return
     * @throws PrestamoException
     */
    public ArrayList<Libro> getLibrosPrestadosTotalTipo(int lI, int lS, Tipo tipo) throws PrestamoException {
        ArrayList <Libro> listaLibros = new ArrayList<Libro>();

        if (total > lI && total < lS){
            for (DetallePrestamo dPrestamo: listaDetallePrestamo){
                if(dPrestamo.cumpleTipo(tipo)) listaLibros.add(dPrestamo.getLibro());
            } return listaLibros;
        } throw new PrestamoException("No se econtraron los libros segun los parametros dados");
    }

    /**
     * Verifica si el prestamo cumple con el mismo autor y la cantidad de unidades es minimo de 10
     * @param autor
     * @return
     */
    public boolean verificarCantidadAutor(String autor) {
        for (DetallePrestamo dPrestamo: getListaDetallePrestamo()){
            if (dPrestamo.verificarAutorLibro(autor) && dPrestamo.verificarCantidadMayor10()){
                return true;
            }
        }
        return false;
    }
}

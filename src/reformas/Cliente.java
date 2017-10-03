package reformas;

import java.util.ArrayList;


public class Cliente {
    
    private String nombre;
    private String apellido;
    private int telefono;
    private boolean fidelidad;
    public ArrayList<Presupuesto> presupuestos;
    
    public Cliente() {
    }
    

    public Cliente(String nombre, String apellido, int telefono, boolean fidelidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.fidelidad = fidelidad;
        presupuestos = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public boolean isFidelidad() {
        return fidelidad;
    }

    public void setFidelidad(boolean fidelidad) {
        this.fidelidad = fidelidad;
    }

    public ArrayList<Presupuesto> getPresupuestos() {
        return presupuestos;
    }

    public void setPresupuestos(ArrayList<Presupuesto> presupuestos) {
        this.presupuestos = presupuestos;
    }

    @Override
    public String toString() {
        return "Cliente => " + " nombre = " + nombre + 
                " / apellido = " + apellido + 
                " / telefono = " + telefono + 
                " / fidelidad = " + fidelidad + 
                " / nº presupuestos = " + presupuestos.size() + " *** ";
    }
    
    
    
    
    
    

}

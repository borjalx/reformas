package reformas;


public class Presupuesto {
    
    private int numeroPresupuesto;
    private String concepto;
    private double precioNeto;
    private int estado;
    
    
    public Presupuesto(){
    }

    public Presupuesto(int numeroPresupuesto, String concepto, double precioNeto, int estado) {
        this.numeroPresupuesto = numeroPresupuesto;
        this.concepto = concepto;
        this.precioNeto = precioNeto;
        this.estado = estado;
    }

    public int getNumeroPresupuesto() {
        return numeroPresupuesto;
    }

    public void setNumeroPresupuesto(int numeroPresupuesto) {
        this.numeroPresupuesto = numeroPresupuesto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getPrecioNeto() {
        return precioNeto;
    }

    public void setPrecioNeto(int precioNeto) {
        this.precioNeto = precioNeto;
    }


    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }


    @Override
    public String toString() {
        
        String estadon = "";
        if(estado == 1){
            estadon = "Pendiente";
        }else if(estado == 2){
            estadon = "Aceptado";
        }else if(estado == 3){
            estadon = "Rechazado";
        }
        
        
        return "*** Presupuesto -> " + " numeroPresupuesto = " + numeroPresupuesto +
                "/ concepto =" + concepto +
                "/ precioNeto = " + precioNeto +
                "/ estado = ( " + estado + " ) " + estadon + " *** ";
    }
    
    
}

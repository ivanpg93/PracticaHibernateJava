/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cole
 */
@Entity
@Table(name = "missio")
public class Missio implements TesteableEntity, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idArchivoArcaico;

    @Column(length = 100000, columnDefinition = "LONGTEXT")
    private String infoAventura;

    @Column
    private float poderMinimo;

    @Column
    private Date fechaColapso;

    @Column
    private boolean realizado;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "missio_aeronau",
            joinColumns = @JoinColumn(name = "missio_id"),
            inverseJoinColumns = @JoinColumn(name = "aeronau_id"))
    private List<Aeronau> aeronaus;

    public Missio(int idArchivoArcaico, String infoAventura, float poderMinimo, Date fechaColapso, boolean realizado) {
        this.idArchivoArcaico = idArchivoArcaico;
        this.infoAventura = infoAventura;
        this.poderMinimo = poderMinimo;
        this.fechaColapso = fechaColapso;
        this.realizado = realizado;
    }

    public Missio(String infoAventura, float poderMinimo, Date fechaColapso, boolean realizado) {
        this.infoAventura = infoAventura;
        this.poderMinimo = poderMinimo;
        this.fechaColapso = fechaColapso;
        this.realizado = realizado;
    }

    public Missio() {
    }

    public int getIdArchivoArcaico() {
        return idArchivoArcaico;
    }

    public void setIdArchivoArcaico(int idArchivoArcaico) {
        this.idArchivoArcaico = idArchivoArcaico;
    }

    public String getInfoAventura() {
        return infoAventura;
    }

    public void setInfoAventura(String infoAventura) {
        this.infoAventura = infoAventura;
    }

    public float getPoderMinimo() {
        return poderMinimo;
    }

    public void setPoderMinimo(float poderMinimo) {
        this.poderMinimo = poderMinimo;
    }

    public Date getFechaColapso() {
        return fechaColapso;
    }

    public void setFechaColapso(Date fechaColapso) {
        this.fechaColapso = fechaColapso;
    }

    public boolean isRealizado() {
        return realizado;
    }

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }

    public List<Aeronau> getAeronaus() {
        if(aeronaus == null){
            aeronaus = new ArrayList<Aeronau>();
        }
        return aeronaus;
    }

    public void setAeronaus(List<Aeronau> aeronaus) {
        this.aeronaus = aeronaus;
    }

    @Override
    public Integer getAtributIdentificador() {
        return getIdArchivoArcaico();
    }

    @Override
    public String getAtributString() {
        return getInfoAventura();
    }

    @Override
    public Float getAtributFloat() {
        return getPoderMinimo();
    }

    @Override
    public Date getAtributDate() {
        return getFechaColapso();
    }

    @Override
    public Boolean getAtributBoolean() {
        return isRealizado();
    }

    @Override
    public void setAtributString(String s) {
        setInfoAventura(s);
    }

    @Override
    public void setAtributFloat(Float f) {
        setPoderMinimo(f);
    }

    @Override
    public void setAtributDate(Date d) {
        setFechaColapso(d);
    }

    @Override
    public void setAtributBoolean(Boolean b) {
        setRealizado(b);
    }

    @Override
    public String toString() {
        return "Missio{" + "idArchivoArcaico=" + idArchivoArcaico + ", infoAventura=" + infoAventura + ", poderMinimo=" + poderMinimo + ", fechaColapso=" + fechaColapso + ", realizado=" + realizado + '}';
    }

    public String toStringWithObjects(String objectString) {
        String aeronausString = "\n\taeronaus: {\n";

        for (Aeronau aeronau : aeronaus) {
            aeronausString += "\t\t"+aeronau.toString() + "\n";
        }
        aeronausString += "\t}\n";
        return "Missio{" + "idArchivoArcaico=" + idArchivoArcaico + ", infoAventura=" + infoAventura + ", poderMinimo=" + poderMinimo + ", fechaColapso=" + fechaColapso + ", realizado=" + realizado + "," + aeronausString +'}';
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentcarproject.models;

import java.sql.Date;

/**
 *
 * @author vinicius
 */
public class Aluguel {
    
    public Cliente cliente = new Cliente();
    public Veiculos veiculo = new Veiculos();
    
    private int id;
    private Date data;
    private Date dataentrega;
    private int numDiaria;
    private float valor;
    private String metodoPag;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Date getDataentrega() {
        return dataentrega;
    }

    public void setDataentrega(Date dataentrega) {
        this.dataentrega = dataentrega;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getNumDiaria() {
        return numDiaria;
    }

    public void setNumDiaria(int numDiaria) {
        this.numDiaria = numDiaria;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getMetodoPag() {
        return metodoPag;
    }

    public void setMetodoPag(String metodoPag) {
        this.metodoPag = metodoPag;
    }
    
}

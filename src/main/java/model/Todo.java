package model;

import java.sql.Date;
import java.sql.Time;

public class Todo {
    private int id;
    private String nome;
    private String descricao;
    private Date data;
    private Time hora;
    private boolean isok;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public boolean isIsok() {
        return isok;
    }

    public void setIsok(boolean isok) {
        this.isok = isok;
    }
}

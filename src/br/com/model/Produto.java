package br.com.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author ronaldo neto
 */
public class Produto {

    private String os;
    private String produto;
    private String descricao;
    private String fornecedor;
    private String unidadeMedida;
    private String categoria;
    private String medida;
    private LocalDateTime data;

    public Produto() {
        //Construtor vázio.
    }

    /*
     *Construtor com todos os campos
     *
     *@param os Código da OS (Ordem de serviço).
     *@param produto Nome do produto.
     *@param unidadeMedida Tipo de medida do produto.
     *@param medida Valor disponivel.
     *@param categoria Categoria do produto.
     *@param descricao Descrição do produto.
     *@param data Data de entrada, ou saída do produto.
     *@param horaCadastro Hora do cadastro do produto.
     *@param fornecedor Fornecedor do produto.
     *
     */
    public Produto(String os, String produto, String unidadeMedida, String medida, String categoria, String descricao, LocalDateTime data, String forncedor) {

        this.os = os;
        this.produto = produto;
        this.unidadeMedida = unidadeMedida;
        this.medida = medida;
        this.categoria = categoria;
        this.descricao = descricao;
        this.data = data;
        this.fornecedor = fornecedor;
    }
    
    //Getters e Setters
    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
       this.medida = medida;
    }
     public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }
    
    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    /**
     * 
     * Representação textual da classe Produto.
     * 
     * 
     * @return String com os detalhes do produto.
     */
    @Override
    public String toString() {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        
        
        return String.format("OS: %s | PRODUTO: %s | CATEGORIA: %s | UNIDADE_MEDIDA: %s | MEDIDA: %s | DATA: %s  ", 
            os, produto, categoria, unidadeMedida, medida, data.format(formatter));
    }

}  

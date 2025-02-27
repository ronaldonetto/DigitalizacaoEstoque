package br.com.model;

import java.time.LocalDateTime;

/**
 *
 * @author ronaldo neto
 */
public class Produto {

    private int os;
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
    public Produto(int os, String produto, String unidadeMedida, String medida, String categoria, String descricao, LocalDateTime data, String forncedor) {

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
    public int getOs() {
        return os;
    }

    public void setOs(int os) {
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
        return String.format("OS: %d | Produto: %s | Categoria: %s | UnidadeMedida: %s | Medida: %.2f m²", 
            os, produto, categoria, unidadeMedida, medida);
    }

}  

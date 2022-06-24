package com.br.barbeariabo.enumerator;

public enum TipoServico {

    CORTE("Corte", 15.00),
	BARBA("Barba", 17.00),
	CORTE_BARBA("Corte e Barba", 25.00),
	DESENHO("Desenho", 30.00),
	LUZES("Luzes", 70.00),
	ALISAMENTO("Alisamento", 50.00),
	PINTURA("Pintura", 40.00);


    TipoServico(String desc, double v){
        this.description = desc;
        this.valorServico = v;
    }

    private String description;
    private Double valorServico;

    public String getDescription() {
        return this.description;
    }
    public Double getValorServico(){return this.valorServico;}

}

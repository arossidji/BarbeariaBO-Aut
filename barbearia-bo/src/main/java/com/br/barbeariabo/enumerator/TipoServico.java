package com.br.barbeariabo.enumerator;

public enum TipoServico {

    CORTE("Corte"),
	BARBA("Barba"),
	CORTE_BARBA("Corte e Barba"),
	DESENHO("Desenho"),
	LUZES("Luzes"),
	ALISAMENTO("Alisamento"),
	PINTURA("Pintura");


    TipoServico(String desc){
        this.description = desc;
    }

    private String description;

    public String getDescription() {
        return this.description;
    }

}

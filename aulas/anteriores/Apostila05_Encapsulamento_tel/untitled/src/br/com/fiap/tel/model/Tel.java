package br.com.fiap.tel.model;

public class Tel {

    private String ddd;
    private String numero;

    public String getTelefoneFormatado() {
        return formatarTel(ddd, numero);
    }

    private String formatarTel(String ddd, String numero) {
        return "(" + ddd + ")" + numero;
    }

}

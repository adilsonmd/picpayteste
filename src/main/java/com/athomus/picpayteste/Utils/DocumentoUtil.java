package com.athomus.picpayteste.Utils;

public class DocumentoUtil {

    private static final int TAMANHO_CPF = 11;
    private static final int TAMANHO_CNPJ = 14;

    private static String removerEspeciais(String str) throws NullPointerException {
        if (StringUtils.isEmpty(str)) {
            throw new NullPointerException("String nula");
        }

        str = str.replace(".", "");
        str = str.replace("-", "");
        str = str.replace("/", "");
        return str;
    }
    public static boolean isCpfValido(String cpf) throws NullPointerException {
        cpf = removerEspeciais(cpf);

        if (cpf.length() != TAMANHO_CPF) {
            return false;
        }

        if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") /* .... */) {
            return false;
        }

        // Algoritmo para validar os CPFs

        return true;
    }

    public static boolean isCnpjValido(String cnpj) throws NullPointerException {
        cnpj = removerEspeciais(cnpj);

        if (cnpj.length() != TAMANHO_CNPJ) {
            return false;
        }

        if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") || cnpj.equals("22222222222222")) {
            return false;
        }
        // Algoritmo para validar os CNPJs
        return true;
    }
}

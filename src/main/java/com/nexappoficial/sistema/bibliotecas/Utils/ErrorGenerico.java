package com.nexappoficial.sistema.bibliotecas.Utils;

import java.util.List;

public class ErrorGenerico {

    public static boolean isNullOrEmpty(Object str) {
        return str == null || "".equals(str);
    }

    public static boolean isNullOrEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }


}

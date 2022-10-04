package br.com.viana.spring3praticaintegradora3.util;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NumberGenerator {
    private int next = 3;
    private final static NumberGenerator instancia = new NumberGenerator();

    public static NumberGenerator getInstance() {
        return instancia;
    }

    public int getNext() {
        return ++next;
    }
}

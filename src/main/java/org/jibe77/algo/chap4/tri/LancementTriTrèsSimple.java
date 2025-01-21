package org.jibe77.algo.chap4.tri;

import org.jibe77.algo.chap4.tri.impl.TriTrèsSimple;

import java.util.Arrays;

public class LancementTriTrèsSimple {

    public static void main(String[] args) {
        String[] parameters = new String[] {"2", "1", "1", "2", "2", "1", "1", "1", "2", "2", "1"};

        TriTrèsSimple triTrèsSimple = new TriTrèsSimple();
        triTrèsSimple.tri(parameters);

        System.out.println(Arrays.toString(parameters));
    }
}

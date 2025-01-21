package org.jibe77.algo.chap6.chemin.dijkstra;

import java.util.Map;
import java.util.Objects;

public class Result {
    public Map<String, Double> plusCourt;
    public Map<String, String> pred;

    public Result(Map<String, Double> plusCourt, Map<String, String> pred) {
        this.plusCourt = plusCourt;
        this.pred = pred;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        else if (!(o instanceof Result)) {return false;}
        Result result = (Result) o;
        return plusCourt.equals(result.plusCourt) &&
                pred.equals(result.pred);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plusCourt, pred);
    }
}

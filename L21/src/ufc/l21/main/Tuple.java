package ufc.l21.main

import java.util.TreeSet;

public class Tuple <E extends TreeSet, K extends Enum<K>> {
    private E treeSet;
    private K result;


    public void setTreeSet(E treeSet) {
        this.treeSet = treeSet;
    }

    public void setResult(K result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "treeSet=" + treeSet +
                ", result=" + result +
                '}';
    }
}

package textgame;

import java.util.*;

public class TransformationManager {
    private Map<String, Set<Transformation>> transformations;

    public TransformationManager() {
        transformations = new HashMap<String, Set<Transformation>>();
    }

    public void addTransformation(Transformation t) {
        for (String type : t.getInput()) {
            Set<Transformation> ts = transformations.get(type);
            if (ts == null) {
                ts = new HashSet<Transformation>();
                transformations.put(type, ts);
            }
            ts.add(t);
        }
    }

    public Set<Transformation> getTransformations(List<String> input) {
        Set<Transformation> res = new HashSet<Transformation>(transformations.get(input.get(0)));

        for (int i = 1; i < res.size(); ++i) {
            res.retainAll(transformations.get(input.get(1)));
        }

        return res;
    }
}

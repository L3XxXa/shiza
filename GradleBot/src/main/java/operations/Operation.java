package operations;

import java.util.ArrayList;

public interface Operation {
    double init(ArrayList<Double> arrayList);
    int getArity();
}

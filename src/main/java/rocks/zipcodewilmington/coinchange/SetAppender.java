package rocks.zipcodewilmington.coinchange;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author leon on 8/7/18.
 */
public class SetAppender<ObjectType> {
    private final Set<ObjectType> set;

    public SetAppender() {
        this(new HashSet<>());
    }

    public SetAppender(Set<ObjectType> set) {
        this.set = set;
    }

    public SetAppender add(ObjectType... values) {
        set.addAll(Arrays.asList(values));
        return this;
    }

    public Set<ObjectType> get() {
        return set;
    }
}

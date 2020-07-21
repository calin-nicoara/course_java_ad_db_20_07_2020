package ro.esolacad.javaad.lab;


import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class ListNoIndexOutOfBounds<T> extends ListDecorator<T> {

//    final Supplier<T> supplier;

    private final Function<Integer, T> mapFunction;
    public ListNoIndexOutOfBounds(final List<T> innerList, final Function<Integer, T> mapFunction
//                                  final Supplier<T> supplier
    ) {
        super(innerList);
        this.mapFunction = mapFunction;
    }

    @Override
    @Deprecated
    public T get(final int index) {
        while(index >= size()) {
            add(mapFunction.apply(size()));
        }

        return super.get(index);
    }
}

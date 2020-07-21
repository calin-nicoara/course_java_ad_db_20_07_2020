package ro.esolacad.javaad.lab;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public abstract class ListDecorator<T> implements List<T> {

    private final List<T> inner;

    public ListDecorator(final List<T> innerList) {
        this.inner = innerList;
    }

    @Override
    public int size() {
        return inner.size();
    }

    @Override
    public boolean isEmpty() {
        return inner.isEmpty();
    }

    @Override
    public boolean contains(final Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(final T1[] a) {
        return null;
    }

    @Override
    public boolean add(final T t) {
        return inner.add(t);
    }

    @Override
    public boolean remove(final Object o) {
        return inner.remove(o);
    }

    @Override
    public boolean containsAll(final Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(final Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(final int index, final Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(final Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(final Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(final int index) {
        return inner.get(index);
    }

    @Override
    public T set(final int index, final T element) {
        return null;
    }

    @Override
    public void add(final int index, final T element) {

    }

    @Override
    public T remove(final int index) {
        return null;
    }

    @Override
    public int indexOf(final Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(final Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(final int index) {
        return null;
    }

    @Override
    public List<T> subList(final int fromIndex, final int toIndex) {
        return null;
    }
}

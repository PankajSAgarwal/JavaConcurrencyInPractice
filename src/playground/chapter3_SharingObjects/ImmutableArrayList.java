package playground.chapter3_SharingObjects;

import java.util.Iterator;

public class ImmutableArrayList<E> implements Iterable<E> {
    private final Object[] elements;
    public ImmutableArrayList() {
        this.elements = new Object[0];
    }

    private ImmutableArrayList(Object[] elements) {
        this.elements = elements;
    }

    public int size() {return elements.length;}

    public ImmutableArrayList<E> add(E o){
        Object[] new_elements = new Object[elements.length + 1];
        System.arraycopy(elements,0,new_elements,0,elements.length);
        new_elements[new_elements.length - 1] = o;
        return new ImmutableArrayList<E>(new_elements);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int pos = 0;
            @Override
            public boolean hasNext() {
                return pos < elements.length;
            }

            @Override
            public E next() {
                return (E) elements[pos++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}

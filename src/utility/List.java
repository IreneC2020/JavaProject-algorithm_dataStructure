package utility;

public interface List<E> {
    // since this is interface , so default public abstract
    boolean     add(E item);
    void        add(int index, E item);
    void        clear();
    boolean     contains(E item);
    E           get(int index);
    int         indexOf(E item);
    boolean     isEmpty();
    Iterator<E> iterator();
    E           remove(int index);
    boolean     remove(E item);
    E           set(int index, E item);
    int         size();
}

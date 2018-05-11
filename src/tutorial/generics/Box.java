package tutorial.generics;

public class Box<T> implements Comparable<T> {

    private T obj;

    Box (T t) { this.obj = t; }
    Box () {}

    public T get() { return obj; }
    public void set(T obj) { this.obj = obj; }

    public <U extends Number> void inspect(U u) {
        System.out.println("T: " + obj.getClass().getName());
        System.out.println("U: " + u.getClass().getName());
    }

//    TODO: Maybe implement something?
    @Override
    public int compareTo(T o) {
        return 0;
    }
}

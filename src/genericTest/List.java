package genericTest;

public abstract class List<T> {

    public abstract void add(T objects);

    public abstract T get(int index);

    public abstract int size();

    public abstract void remove(int index);

    public void run(T req) {
    }

}

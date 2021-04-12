package lab6.io;

public interface IO<T> {
    public T[] read(String fileName);
    public boolean write(String fileName, T[] objects);
}

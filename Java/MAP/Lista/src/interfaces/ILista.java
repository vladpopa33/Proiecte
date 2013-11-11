package interfaces;
public interface ILista<T> {

	public abstract void add(T i);

	public abstract T element(int i);

	public abstract void delete(int i);

	public abstract int size();

	public abstract boolean vida();

	public abstract int get_urm(int i);

	public abstract int get_prim();

}
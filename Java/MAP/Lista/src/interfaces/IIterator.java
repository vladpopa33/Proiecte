package interfaces;
public interface IIterator<T> {

	public abstract void next();

	public abstract T val();

	public abstract boolean isValid();

}
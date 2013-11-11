package repository;
import java.util.List;

import model.CD;

public interface IRepository {

	/* (non-Javadoc)
	 * @see repository.IRepository#Read()
	 */
	public abstract void Read() throws RepositoryException;

	/* (non-Javadoc)
	 * @see repository.IRepository#Save(java.util.List)
	 */
	public abstract void Save(List<CD> l) throws RepositoryException;

	/* (non-Javadoc)
	 * @see repository.IRepository#Add(model.Ciocolata)
	 */
	public abstract void Add(CD p) throws RepositoryException;

	/* (non-Javadoc)
	 * @see repository.IRepository#GetPlanta(int)
	 */
	public abstract void Sort(int i);
	public abstract CD GetCD(int pozitie);

	/* (non-Javadoc)
	 * @see repository.IRepository#FindAll()
	 */
	public abstract List<CD> FindAll();
	public abstract Repository Search(CD nou);

}
package repository;

import java.util.*;
import model.Ciocolata;

public class Repository implements IRepository{
	private List<Ciocolata> l;

	/* (non-Javadoc)
	 * @see repository.IRepository#Read()
	 */
	@Override
	public void Read() {
	
	}

	/* (non-Javadoc)
	 * @see repository.IRepository#Save(java.util.List)
	 */
	@Override
	public void Save(List<Ciocolata> l) {
		this.l = l;
	}

	/* (non-Javadoc)
	 * @see repository.IRepository#Add(model.Ciocolata)
	 */
	@Override
	public void Add(Ciocolata p) {
		l.add(p);
	}
	
	/* (non-Javadoc)
	 * @see repository.IRepository#GetPlanta(int)
	 */
	@Override
	public Ciocolata GetCioco(int pozitie) {
		return l.get(pozitie);
	}

	/* (non-Javadoc)
	 * @see repository.IRepository#FindAll()
	 */
	@Override
	public List<Ciocolata> FindAll() {
		return l;
	}
}

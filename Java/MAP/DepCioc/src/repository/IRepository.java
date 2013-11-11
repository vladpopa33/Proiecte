package repository;

import java.util.List;

import model.Ciocolata;

public interface IRepository {

	public abstract void Read() throws RepositoryException;

	public abstract void Save(List<Ciocolata> l) throws RepositoryException;

	public abstract void Add(Ciocolata p) throws RepositoryException;

	public abstract Ciocolata GetCioco(int pozitie);

	public abstract List<Ciocolata> FindAll();

}
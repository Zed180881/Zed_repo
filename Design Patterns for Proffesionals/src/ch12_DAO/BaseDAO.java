package ch12_DAO;

public interface BaseDAO<E, K> {
	public void create(E entity);

	public Movie retrieve(K id);

	public void update(E entity);

	public void delete(K id);
}
package za.ac.cput.repository;

//Generic Repository interface

@Deprecated //This interface will not be used, will be removed in future.

public interface IRepository<T,ID>
{
  T create(T t);
  T read(ID id);
  T update(T t);
  boolean delete(ID id);
}

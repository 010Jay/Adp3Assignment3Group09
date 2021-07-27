package za.ac.cput.service;

//Generic Service Interface

public interface IService<T, ID> {

    T create(T t);

    T read(ID id);

    T update(T t);

    boolean delete(ID id);

}

package ua.lviv.lgs.shared;

import java.util.List;

public interface AbstractCRUD <T> {
	T create(T t);
	T read(Integer i);
	T update(T t);
	void delete(T t);
	List<T> readAll();
}

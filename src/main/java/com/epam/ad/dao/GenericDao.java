package com.epam.ad.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Askar on 06.08.2014.
 */
public interface GenericDao<T, PK extends Serializable> {
    /** Создает новую запись и соответствующий ей объект */
    public T create() throws SQLException,AbstractJDBCDao.PersistException;
    /** Создает новую запись, соответствующую объекту object */
    public T persist(T object) throws SQLException, AbstractJDBCDao.PersistException;
    /** Возвращает объект соответствующий записи с первичным ключом key или null */
    public T getByPK(PK key) throws SQLException,AbstractJDBCDao.PersistException;
    /** Сохраняет состояние объекта group в базе данных */
    public void update(T object) throws SQLException, AbstractJDBCDao.PersistException;
    /** Удаляет запись об объекте из базы данных */
    public void delete(T object) throws SQLException, AbstractJDBCDao.PersistException;
    /** Возвращает список объектов соответствующих всем записям в базе данных */
    public List<T> getAll() throws SQLException,AbstractJDBCDao.PersistException;
}


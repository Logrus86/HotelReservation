package com.epam.ad.dao;

import java.io.Serializable;

/**
 * Created by Askar on 06.08.2014.
 */
public interface Identified<PK extends Serializable> {
    /** Возвращает идентификатор объекта */
    public PK getId();
}

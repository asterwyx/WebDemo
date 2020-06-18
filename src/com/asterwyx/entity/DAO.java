package com.asterwyx.entity;

import java.util.List;

public interface DAO<T> {
    int insert(T toIns);
    int update(T toUpd);
    int delete(T toDel);
    List<T> selectAll();
    boolean selectByPriKey(T toSrh);
}

package com.xmcc.wx_sell.repository.imp;

import com.xmcc.wx_sell.repository.BatchDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.transaction.Transactional;

public class BatchDaoImp<T> implements BatchDao<T> {
    @PersistenceContext
    protected EntityManager em;

    @Transactional
    @Override
    public void batchInsert(List<T> list) {
        long length = list.size();
        for (int i = 0; i <length; i++) {
            em.persist(list.get(i));
            if (i % 100 == 0||i==length-1) {//每100条执行一次写入数据库操作
                em.flush();
                em.clear();
            }
        }

    }
}

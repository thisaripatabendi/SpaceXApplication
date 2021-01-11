package com.cloud.SpaceXApplication.component;

import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DemoData implements ApplicationRunner {

    @Autowired
    private EntityManager entityManager;

    Query query;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        query = entityManager.createNativeQuery("SELECT COUNT(*) FROM satellite");
        BigInteger result = (BigInteger) query.getSingleResult();
        if (result.intValue() <= 1) {
            query = entityManager.createNativeQuery("INSERT INTO satellite (name, status, health) VALUES ('ST_Raz', 'attached', true), ('ST_Wims', 'detached', true), " +
                    "('ST_Kris', 'attached', true), ('ST_Noviz', 'detached', true), ('ST_Luna', 'attached', true), ('ST_Gal', 'detached', true), ('ST_Hony', 'attached', true), ('ST_Laury', 'detached', false);");
            query.executeUpdate();
        }
    }
}
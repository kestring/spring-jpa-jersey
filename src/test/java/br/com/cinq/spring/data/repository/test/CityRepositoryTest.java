package br.com.cinq.spring.data.repository.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.IntegrationTest;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.cinq.spring.data.sample.application.Application;
import br.com.cinq.spring.data.sample.entity.City;
import br.com.cinq.spring.data.sample.entity.Country;
import br.com.cinq.spring.data.sample.repository.CityRepository;

/**
 * Eye candy: implements a sample in using JpaRespositories
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Application.class)
//@WebIntegrationTest(randomPort = true)
//@IntegrationTest("server.port=9000")
@SpringBootTest(classes = Application.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("unit")
public class CityRepositoryTest {

    @Autowired
    private CityRepository dao;

    @Test
    public void testQueryPerson() {

        Assert.assertNotNull(dao);
        System.out.println("TESTE");
        Assert.assertTrue(dao.count()>0);
        dao.findAll();
        Country country = new Country();
        country.setId(3); // Should be France

        List<City> list = dao.findByCountry(country);

        Assert.assertEquals(2, list.size());
    }
}

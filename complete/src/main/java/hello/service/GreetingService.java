package hello.service;

import hello.model.Greeting;

import java.util.Collection;

/**
 * Created by abidur.rahman on 05/08/2016.
 */
public interface GreetingService {

    Collection<Greeting> findAll();

    Greeting findOne(Long id);

    Greeting create(Greeting greeting);

    Greeting update(Greeting greeting);

    void delete(Long id);

}

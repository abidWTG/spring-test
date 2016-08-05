package hello.service;

import hello.model.Greeting;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by abidur.rahman on 05/08/2016.
 */
@Service
public class GreetingServiceBean implements GreetingService {

    static {
        Greeting g1 = new Greeting();
        g1.setText("Hello World!");
        save(g1);

        Greeting g2 = new Greeting();
        g2.setText("Hola Mundo!");
        save(g2);
    }

    private static Long nextId;
    private static Map<Long, Greeting> greetingMap;

    private static Greeting save(Greeting greeting) {
        if (greetingMap == null) {
            greetingMap = new HashMap<Long, Greeting>();
            nextId = new Long(1);
        }
        if (greeting.getId() != null) {
            Greeting oldGreeting = greetingMap.get(greeting.getId());
            if (oldGreeting == null) {
                return null;
            }
            greetingMap.remove(greeting.getId());
            greetingMap.put(greeting.getId(), greeting);
            return greeting;
        }
        greeting.setId(nextId);
        nextId++;
        greetingMap.put(greeting.getId(), greeting);
        return greeting;
    }

    private static boolean remove(Long id) {
        Greeting deleteGreeting = greetingMap.remove(id);
        if (deleteGreeting == null) {
            return false;
        }

        return true;
    }

    @Override
    public Collection<Greeting> findAll() {
        Collection<Greeting> greetings = greetingMap.values();
        return greetings;
    }

    @Override
    public Greeting findOne(Long id) {
        Greeting greeting = greetingMap.get(id);
        return greeting;
    }

    @Override
    public Greeting create(Greeting greeting) {
        Greeting createGreeting = save(greeting);
        return createGreeting;
    }

    @Override
    public Greeting update(Greeting greeting) {
        Greeting updateGreeting = save(greeting);
        return updateGreeting;
    }

    @Override
    public void delete(Long id) {
        remove(id);
    }
}

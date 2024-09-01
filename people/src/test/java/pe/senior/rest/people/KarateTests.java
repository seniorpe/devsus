package pe.senior.rest.people;

import com.intuit.karate.junit5.Karate;

public class KarateTests {
    @Karate.Test
    Karate testAll() {
        return Karate.run("classpath:features/clientes.feature").relativeTo(getClass());
    }
}

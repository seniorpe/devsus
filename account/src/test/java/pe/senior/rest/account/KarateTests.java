package pe.senior.rest.account;

import com.intuit.karate.junit5.Karate;

public class KarateTests {
    @Karate.Test
    Karate testAll() {
        return Karate.run(
                "classpath:features/cuentas.feature",
                "classpath:features/cuentas-jose-lema.feature",
                "classpath:features/movimientos.feature"
        ).relativeTo(getClass());
    }
}

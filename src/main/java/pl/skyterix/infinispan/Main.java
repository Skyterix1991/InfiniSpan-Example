package pl.skyterix.infinispan;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.skyterix.infinispan.domain.Person;
import pl.skyterix.infinispan.utils.CacheStorage;

@Component
public class Main implements CommandLineRunner {

    private final CacheStorage cacheStorage;

    public Main(CacheStorage cacheStorage) {
        this.cacheStorage = cacheStorage;
    }

    @Override
    public void run(String... args) {

        // Initialize example values
        Person person = new Person(1);

        cacheStorage.put("put", person);
        cacheStorage.putString("putString", "Example string");
        cacheStorage.putBoolean("putBoolean", true);
        cacheStorage.putDouble("putDouble", 3.14);
        cacheStorage.putInteger("putInteger", 16);
        cacheStorage.putLong("putLong", 2019L);

        // Retrieve example values
        System.out.println(((Person) cacheStorage.retrieve("put", new Person(2))).getId());
        System.out.println(cacheStorage.retrieveString("putString", "Value of that key not found"));
        System.out.println(cacheStorage.retrieveBoolean("putBoolean", false));
        System.out.println(cacheStorage.retrieveDouble("putDouble", 0.2));
        System.out.println(cacheStorage.retrieveInteger("putInteger", 16));
        System.out.println(cacheStorage.retrieveLong("putLong", 2020L));

        System.out.println();

        // Retrieve non existing values
        System.out.println(cacheStorage.retrieveString("?", "Value of that key not found"));
        System.out.println(cacheStorage.retrieveBoolean("?", false));
    }
}

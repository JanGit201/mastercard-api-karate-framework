package runners;

import com.intuit.karate.junit5.Karate;

public class TestRunner {
    
    @Karate.Test
    Karate runAllTests() {
        // Points to the folder containing your feature files
        return Karate.run("classpath:features").relativeTo(getClass());
    }
}
package UnitTests.FavoriteTechPreProcessor01222024;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static com.example.model.KeyPhrasePuller.FavoriteTechPreprocessor.pickFavoriteTechWords;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FavoriteTechPreprocessorTest {
    @Test
    @Order(1)
    void t() {
        String s = pickFavoriteTechWords("java c#");
        assert (s.equals("java "));

        String s2 = pickFavoriteTechWords("csharp c++");
        assert (s2.equals("csharp "));

        String s3 = pickFavoriteTechWords("ada c++");
        assert (s3.equals(" c++"));

        // I will have no resume that claims C or ADA, or cobalt, or fortran, or any other dinosaur
    }
}
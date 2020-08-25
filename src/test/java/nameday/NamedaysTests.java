package nameday;

import static org.junit.jupiter.api.Assertions.*;

import java.time.*;
import java.util.*;
import namedayapi.*;
import org.junit.jupiter.api.*;

@SuppressWarnings("boxing")
public class NamedaysTests {

    @Test
    public void testGetNamedays() {
        var result = NamedayApi.getNamedays(Month.JULY, 15, Country.USA).join();

        assertEquals(List.of("Baldwin", "Don", "Donald", "Donalda", "Donna", "Donnell", "Donnie", "Dunn", "Dunne", "Uriel"), result);
    }

    @Test
    public void testNameSearch() {
        var result = NamedayApi.searchForName("John", Country.USA).join();

        assertEquals(List.of(24), result.get(Month.JUNE));
        assertEquals(List.of(11), result.get(Month.NOVEMBER));
    }
}
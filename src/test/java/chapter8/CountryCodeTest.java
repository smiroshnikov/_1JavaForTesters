package chapter8;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountryCodeTest {
    @Test
    public void doesCountryMatch() {
        assertEquals("United Kingdom", shortCode("UK"));
        assertEquals("SWEDEN", shortCode("SE"));
        assertEquals("United States", shortCode("USA"));
        assertEquals("United States", shortCode("usA"));


    }

    private String shortCode(String country) {
        String fullCountryName;
        switch (country.toUpperCase()) {
            case "UK": {
                fullCountryName = "United Kingdom";
                break;
            }
            case "US":
            case "USA": {
                fullCountryName = "United States";
                break;
            }
            case "FR": {
                fullCountryName = "FRANCE";
                break;
            }
            case "SE": {
                fullCountryName = "SWEDEN";
                break;
            }
            default: {
                fullCountryName = "Rest of the World";
                break;
            }
        }
        return fullCountryName;

    }
}

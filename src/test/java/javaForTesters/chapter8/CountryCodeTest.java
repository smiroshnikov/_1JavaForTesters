package javaForTesters.chapter8;

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

    @Test
    public void canConvertIntToString() {
        assertEquals("One", convertMe(1));
        assertEquals("Two", convertMe(2));
        assertEquals("Too big", convertMe(13));
        assertEquals("Too small", convertMe(0));
        assertEquals("Too big", convertMe(0b111));

    }

    private String convertMe(int number) {
        String output ;
        switch (number) {
            case (1): {
                output = "One";
                break;
            }
            case (2): {
                output = "Two";
                break;
            }
            case (3): {
                output = "Three";
                break;
            }
            case (4): {
                output = "Four";
                break;
            }
            default: {
                if (number < 1) {
                    output = "Too small";
                } else {
                    output = "Too big";
                }
            }
        }
        return output;
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

package chapter15;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StringsPart2 {

    @Test
    public void penisReplacementTest() {
        String fella = "Hello fella fella fella fella";
        assertThat(fella.replace("fella", "penis"), is("Hello penis penis penis penis"));
        String numbers = "1,2,3,4,5";
        System.out.println(numbers.replaceAll("[0-9]", "penis"));
        // removing whitespaces
        String trim = "    hey trim me ";
        System.out.println(trim.trim());
        // This is a very handy method to use when tidying up input data, or data read from files
        assertThat(trim.trim().length(), is(11));
        String digits = "012345679";
        System.out.println(digits.substring(5, 8));
        String template = "The value %d was used !";
        int value = 4;
        System.out.println(String.format(template, value));
        String weirdText = "%2$s %4$s very %3$d large %1$s";
        System.out.println(String.format(weirdText, "Bob", "ran", 6, "game"));
        String normalText = "%s %s towards %d large %s";
        System.out.println(String.format(normalText, "Bob", "ran", 6, "onions"));
    }

    @Test
    public void splittingIpAddress() {
        String fullIP = "https://192.168.1.1:8080";
        System.out.println(fullIP.substring(8));
        String ipList = "192.168.10.10,192.168.12.48,192.168.13.157,192.166.187.132";
        String[] addresses = ipList.split(",");
        for (String address :
                addresses) {
            System.out.println(address);
        }

    }

    @Test
    public void csvSplit() {
        //I frequently use split to parse simple CSV, or tab delimited files. I’ve also used it to parse
        //HTML and XML, without bringing in other libraries.
        String csvFile = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,17,123,23,4,5,6,7," +
                "8,3,23,5,6,7,8,0,534,345,5,5,-67,-56,7,-0.345,8,3,23,5,6,7,8,0,534,345,5," +
                "5,-67,-56,7,-0.345,8,3,23,5,6,7,8,0,534,345,5,5,-67,-56,7,-0.345,8,3,23,5,6,7," +
                "8,0,534,345,5,5,-67,-56,7,-0.345,8,3,23,5,6,7,8,0,534,345,5,5,-67,-56,7,-0.345";
        String[] measurements = csvFile.split(",");
        for (String m :
                measurements) {
            System.out.println(m);
        }
    }

    @Test
    public void workingWithStringBuilder() {
        StringBuilder builder = new StringBuilder();
        System.out.println(builder.append("hey there ").replace(4, 9, "Sergei  Miroshnikov !").delete(24, 26));
        StringBuilder sb = new StringBuilder();
        assertThat(sb.capacity(), is(16));
        sb.append("12345678123456781232342378462783647823648726347892649218734891237");
        System.out.println(sb.capacity());
        StringBuilder sblen = new StringBuilder(1024);
        assertThat(sblen.toString().length(), is(0));
        sblen.ensureCapacity(4056);
        for (int i = 0; i < sblen.capacity() - 4000; i++) {
            sblen.append(0);
        }
        System.out.println(sblen.toString());
        System.out.printf("current capacity is %d %n", sblen.capacity());
        sblen.trimToSize();
        System.out.printf("current capacity is %d %n", sblen.capacity());
        char[] ca = {' ', '=', '<', '№', '3'};
        sblen.append(ca);
        System.out.printf("current capacity is %d %n", sblen.capacity());
        //assertEquals(" =<№3", sblen.toString());
        sblen.insert(0, "START_TAG#");
        assertThat(sblen.toString().startsWith("START_TAG#"), is(true));
    }

    @Test
    public void reverseName() {
        StringBuilder builder = new StringBuilder("Sergei Miroshnikov!");
        System.out.println(builder.reverse().toString());
    }

}

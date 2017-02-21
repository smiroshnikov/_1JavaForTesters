package playground1.linkedLists;

/**
 * Created by Iidwuurliik on 2/21/2017.
 */
public class Suko implements Comparable<Suko> {
    String scuko;
    String izdevaetsya;
    String ivalid;

    public Suko(String scuko, String izdevaetsya, String ivalid) {
        this.scuko = scuko;
        this.izdevaetsya = izdevaetsya;
        this.ivalid = ivalid;
    }


    @Override
    public int compareTo(Suko o) {
        return scuko.length() + izdevaetsya.length() + ivalid.length() - (o.scuko.length()
                + o.izdevaetsya.length() + o.ivalid.length());

    }
}

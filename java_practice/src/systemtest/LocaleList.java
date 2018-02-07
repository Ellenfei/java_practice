package systemtest;

import java.util.Locale;

/**
 * Created by ye on 2016/11/25.
 */
public class LocaleList {
    public static void main (String [] args) {
        Locale [] locales = Locale.getAvailableLocales();
        for (int i = 0; i<locales.length; i++) {
            System.out.println(locales[i].getDisplayCountry()+"="+locales[i].getCountry()+" "
                    +locales[i].getDisplayLanguage()+"="+locales[i].getLanguage());
        }
    }
}

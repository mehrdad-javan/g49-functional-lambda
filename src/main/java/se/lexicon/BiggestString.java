package se.lexicon;

public class BiggestString implements DoStringStuff {
    @Override
    public String operate(String s1, String s2) {
        /*if (s1.length() >= s2.length()){
            return s1;
        } else {
            return s2;
        }*/
        return (s1.length() >= s2.length()) ? s1 : s2;
    }

}

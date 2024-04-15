package se.lexicon;

public class ConcatStringOperator implements DoStringStuff {

    @Override
    public String operate(String s1, String s2) {
        return s1 + s2;
    }

}

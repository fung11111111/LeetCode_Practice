package javaBasic.desingPattern.structuralPattern.NewFacade;

public class StringConverter implements ConverterFacade {
    private static StringConverter converter;

    public StringConverter() {
    }

    public static StringConverter getConverter() {
        if (converter == null)
            converter = new StringConverter();
        return converter;
    }

    @Override
    public <T> int convertToInt(T t) {
        return Integer.parseInt((String) t);
    }

    @Override
    public <T> double convertToDouble(T t) {
        return Double.parseDouble((String) t);
    }

    @Override
    public <T> short convertToShort(T t) {
        return Short.parseShort((String) t);
    }
}

package javaBasic.desingPattern.structuralPattern.NewFacade;

import java.nio.ByteBuffer;

public class BytesConverter implements ConverterFacade {
    private static BytesConverter converter;

    public BytesConverter() {
    }

    public static BytesConverter getConverter() {
        if (converter == null)
            converter = new BytesConverter();
        return converter;
    }

    @Override
    public <T> int convertToInt(T t) {
        return ByteBuffer.wrap((byte[]) t).getInt();
    }

    @Override
    public <T> double convertToDouble(T t) {
        return ByteBuffer.wrap((byte[]) t).getDouble();
    }

    @Override
    public <T> short convertToShort(T t) {
        return ByteBuffer.wrap((byte[]) t).getShort();
    }


}

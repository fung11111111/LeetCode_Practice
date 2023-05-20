package javaBasic.desingPattern.structuralPattern.NewFacade;

public interface ConverterFacade {

    <T> int convertToInt(T t);
    <T> double convertToDouble(T t);
    <T> short convertToShort(T t);
  ;
}

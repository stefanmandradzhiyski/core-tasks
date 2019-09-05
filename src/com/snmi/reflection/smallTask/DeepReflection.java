package com.snmi.reflection.smallTask;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Utility class Deep Reflection which function is to copy two similar objects with reflection
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class DeepReflection {

    /**
     * Default constructor
     */
    private DeepReflection() {}

    /**
     * Main method of Deep Reflection which copy all fields from source object to destination object with reflection
     * @param sourceObject take the source object
     * @param destinationObject take the destination object
     * @param deepObject take the inner object which is part of source and destination object
     */
    public static void copy(Object sourceObject, Object destinationObject, Object deepObject) {
        Class<?> sourceObjectClass = sourceObject.getClass();
        Class<?> destinationObjectClass = destinationObject.getClass();

        Field[] sourceObjectFields = sourceObjectClass.getDeclaredFields();
        Field[] destinationObjectFields = destinationObjectClass.getDeclaredFields();

        for (Field sourceField : sourceObjectFields) {
            for (Field destinationField : destinationObjectFields) {
                if (isFieldEqual(sourceField, destinationField)) {
                    deepReflection(sourceField, destinationField, sourceObject, destinationObject, deepObject);
                }
            }
        }
    }

    /**
     * Deep reflection method
     * @param sourceField take the source fields
     * @param destinationField take the destination fields
     * @param sourceObject take the source object
     * @param destinationObject take the destination object
     * @param deepObject take the inner object which is part of source and destination object
     */
    private static void deepReflection(Field sourceField, Field destinationField, Object sourceObject, Object destinationObject, Object deepObject) {
        sourceField.setAccessible(true);
        destinationField.setAccessible(true);
        try {
            Class<?> deepObjectClass = deepObject.getClass();
            if (destinationField.getType().equals(deepObjectClass)) {
                Constructor<?> deepObjectConstructor = deepObjectClass.getDeclaredConstructor();
                Object newObject = deepObjectConstructor.newInstance();
                destinationField.set(destinationObject, newObject);
            } else {
                destinationField.set(destinationObject, sourceField.get(sourceObject));
            }
        } catch (IllegalAccessException | NoSuchMethodException | InstantiationException | InvocationTargetException e){
            e.printStackTrace();
        }
    }

    /**
     * Check if fields between both objects are equal by type and name
     * @param sourceField take the source fields
     * @param destinationField take the destination fields
     * @return boolean result
     */
    private static boolean isFieldEqual(Field sourceField, Field destinationField) {
        return  sourceField.getName().equals(destinationField.getName()) &&
                sourceField.getType() == destinationField.getType();
    }

}

package com.snmi.reflection.bigTask.reflectionManager;

import com.snmi.reflection.bigTask.administrator.Administrator;
import com.snmi.reflection.bigTask.developers.Developer;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Reflection manager will clone all similar fields between two objects.
 * The clone method will do the job for you. You just need to set the source and destination objects.
 */
public class ReflectionManager {

    /**
     * Class constants
     */
    private static final String setMethod = "set";
    private static final String getMethod = "get";

    /**
     * Lists which hold the necessary data
     */
    private static List<Field> allSimilarFields = new ArrayList<>();
    private static List<Method> allSetMethods = new ArrayList<>();
    private static List<Method> allGetMethods = new ArrayList<>();

    /**
     * Clean three lists
     */
    private static void cleanLists() {
        allSimilarFields.clear();
        allSetMethods.clear();
        allGetMethods.clear();
    }

    /**
     * Main method of Reflection Manager.
     * First clean all lists;
     * After that take classes of both objects;
     * Fill two arrays of Field with objects declared fields;
     * Find the similar fields between both objects;
     * Find the similar set and get methods between both objects;
     * At the end set values to all similar fields.
     * @param sourceObject take the source object which fields values will be clone
     * @param destinationObject take the destination object which fields values will be set by source object
     */
    public static void clone(Object sourceObject, Object destinationObject) {
        cleanLists();

        Class<?> sourceClass = null;
        if (sourceObject instanceof Administrator) {
            sourceClass = sourceObject.getClass();
        } else if (sourceObject instanceof Developer) {
            sourceClass = sourceObject.getClass().getSuperclass();
        }

        Class<?> destinationClass = null;
        if (destinationObject instanceof Administrator) {
            destinationClass = destinationObject.getClass();
        } else if (destinationObject instanceof Developer) {
            destinationClass = destinationObject.getClass().getSuperclass();
        }

        Field[] sourceClassFields = sourceClass.getDeclaredFields();
        Field[] destinationClassFields = destinationClass.getDeclaredFields();

        findSimilarFields(sourceClassFields, destinationClassFields);
        allSetMethods = findSimilarMethods(setMethod, destinationClass);
        allGetMethods = findSimilarMethods(getMethod, sourceClass);
        setValues(sourceObject, destinationObject);
    }

    /**
     * Check if both fields are equal by modifier, type and name
     * @param sourceField take the source object
     * @param destinationField take the destination object
     * @return equal if the specific field exists in both objects
     */
    private static boolean isFieldEqual(Field sourceField, Field destinationField) {
        return  sourceField.getName().equals(destinationField.getName()) &&
                sourceField.getType() == destinationField.getType() &&
                sourceField.getModifiers() == destinationField.getModifiers();
    }


    /**
     * Find all similar fields between both objects and save them to the list
     * @param sourceClassFields take the source object
     * @param destinationClassFields take the destination object
     */
    private static void findSimilarFields(Field[] sourceClassFields, Field[] destinationClassFields) {
        for (Field sourceField : sourceClassFields) {
            int modifier = sourceField.getModifiers();
            if (!Modifier.isFinal(modifier)) {
                for (Field destinationField : destinationClassFields) {
                    if (isFieldEqual(sourceField, destinationField)) {
                        allSimilarFields.add(sourceField);
                    }
                }
            }
        }
    }

    /**
     * Common method to find set or get methods in both objects
     * @param methodAction take the action of method
     * @param methodsFromClass take the class which methods will be checked
     */
    private static List<Method> findSimilarMethods(String methodAction, Class methodsFromClass) {
        List<Method> allSpecificMethods = new ArrayList<>();
        Method[] classMethods = methodsFromClass.getDeclaredMethods();
        for (Method method : classMethods) {
            for (Field field : allSimilarFields) {
                String methodFullName = method.getName();
                String fieldName = field.getName();
                if (methodFullName.equalsIgnoreCase(methodAction + fieldName)) {
                    allSpecificMethods.add(method);
                }
            }
        }

        return allSpecificMethods;
    }

    /**
     * Set all similar fields between both objects with values
     * @param sourceObject take the source object
     * @param destinationObject take the destination object
     */
    private static void setValues(Object sourceObject, Object destinationObject) {
        for (Method setMethod : allSetMethods) {
            for (Method getMethod : allGetMethods) {
                String setMethodShortName = setMethod.getName().substring(2);
                String getMethodShortName = getMethod.getName().substring(2);
                if (setMethodShortName.equalsIgnoreCase(getMethodShortName)) {
                    try {
                        Object returnedValue = getMethod.invoke(sourceObject);
                        setMethod.invoke(destinationObject, returnedValue);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

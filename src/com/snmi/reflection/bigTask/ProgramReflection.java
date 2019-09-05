package com.snmi.reflection.bigTask;

import com.snmi.reflection.bigTask.administrator.Administrator;
import com.snmi.reflection.bigTask.developers.Developer;
import com.snmi.reflection.bigTask.inputHelper.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Program can be used to create different custom objects by reflection and deep copy
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class ProgramReflection {

    /**
     * Class constants
     */
    private static final transient Logger LOGGER = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);

    private static final String SOURCE = "Source:";
    private static final String REFLECTED = "Reflected:";
    private static final String DEEP_COPIED = "Deep copied after changes:";
    private static final String DEEP_COPY_ERROR = "Error occur when the user tried to create a deep copy";

    /**
     * Class variables
     */
    private static Administrator sourceAdministrator = null;
    private static Developer sourceDeveloper = null;
    private static Administrator reflectedAdministrator = null;
    private static Developer reflectedDeveloper = null;
    private static Administrator deepCopiedAdministrator = null;
    private static Developer deepCopiedDeveloper = null;

    public static void main(String[] args) {
        LOGGER.setLevel(Level.FINER);
        Scanner console = new Scanner(System.in);

        createSource(console);
        createDestination(console);

        if (reflectedAdministrator == null && reflectedDeveloper != null) {
            TechAreaSetter.setTechArea(console, reflectedDeveloper);
        }

        deepCopier(console);
        ExperienceChanger.changeExperience(console, deepCopiedAdministrator, deepCopiedDeveloper);
        presentChangedCopiedObject();
    }

    /**
     * Create source object
     * @param console take console input
     */
    private static void createSource(Scanner console) {
        Object sourceObject = SourceCreator.createSourceObject(console);
        if (sourceObject instanceof Administrator) {
            sourceAdministrator = (Administrator) sourceObject;
            presentAdministratorObject(sourceAdministrator);
        } else if (sourceObject instanceof Developer) {
            sourceDeveloper = (Developer) sourceObject;
            presentDeveloperObject(sourceDeveloper);
        }
    }

    /**
     * Create destination object
     * @param console take console input
     */
    private static void createDestination(Scanner console) {
        Object destinationObject = DestinationCreator.createDestinationObject(console, sourceAdministrator, sourceDeveloper);
        if (destinationObject instanceof Administrator) {
            reflectedAdministrator = (Administrator) destinationObject;
            presentAdministratorObject(reflectedAdministrator);
        } else if (destinationObject instanceof Developer) {
            reflectedDeveloper = (Developer) destinationObject;
            presentDeveloperObject(reflectedDeveloper);
        }
    }

    /**
     * Make deep copy of custom object
     * @param console take console input
     */
    private static void deepCopier(Scanner console) {
        try {
            Object deepCopiedObject = DeepCopier.deepCopy(console, sourceAdministrator, sourceDeveloper,
                    reflectedAdministrator, reflectedDeveloper);
            if (deepCopiedObject instanceof Administrator) {
                deepCopiedAdministrator = (Administrator) deepCopiedObject;
                presentAdministratorObject(deepCopiedAdministrator);
            } else if (deepCopiedObject instanceof Developer) {
                deepCopiedDeveloper = (Developer) deepCopiedObject;
                presentDeveloperObject(deepCopiedDeveloper);
            }
        } catch (CloneNotSupportedException e) {
            LOGGER.log(Level.FINE, DEEP_COPY_ERROR);
            e.printStackTrace();
        }
    }

    /**
     * Present different object
     */
    private static void presentAdministratorObject(Administrator administrator) {
        administrator.presentMyself();
        administrator.toDo();
    }

    private static void presentDeveloperObject(Developer developer) {
        developer.presentMyself();
        developer.createModule();
        developer.toDo();
    }

    private static void presentChangedCopiedObject() {
        System.out.println(SOURCE);
        if (sourceAdministrator != null) {
            sourceAdministrator.presentMyself();
        } else {
            sourceDeveloper.presentMyself();
        }

        System.out.println(REFLECTED);
        if (reflectedAdministrator != null) {
            reflectedAdministrator.presentMyself();
        } else {
            reflectedDeveloper.presentMyself();
        }

        System.out.println(DEEP_COPIED);
        if (deepCopiedAdministrator != null) {
            deepCopiedAdministrator.presentMyself();
        } else if (deepCopiedDeveloper != null) {
            deepCopiedDeveloper.presentMyself();
        }
    }
}

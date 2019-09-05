package com.snmi.reflection.bigTask.inputHelper;

import com.snmi.reflection.bigTask.developers.Developer;
import com.snmi.reflection.bigTask.global.TechArea;
import java.util.Scanner;

/**
 * TechAreaSetter can be used to set a Tech Area of reflected object
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class TechAreaSetter {

    /**
     * Class constants
     */
    private static final String NO = "no";
    private static final String YES = "yes";
    private static final String CHOOSE_TECH_AREA = "What tech area will he be? (JAVA / C / C++ / C# / PHP / Python): ";
    private static final String ADD_TECH_AREA = "Do you want to add tech area for the developer? (Yes / No): ";

    /**
     * Main method of TechAreaSetter which can be used to set a specific tech area of developer object
     * @param console take the user input
     * @param reflectedDeveloper take the reflected Developer object
     */
    public static void setTechArea(Scanner console, Developer reflectedDeveloper) {
        String yesOrNo = InputHelper.validateStringInput(console, ADD_TECH_AREA, YES, NO);

        if (yesOrNo.equalsIgnoreCase(YES)) {
            String techArea = InputHelper.inputValidTechArea(console, CHOOSE_TECH_AREA);
            switch (techArea) {
                case InputHelper.JAVA: reflectedDeveloper.setTechArea(TechArea.JAVA); break;
                case InputHelper.C: reflectedDeveloper.setTechArea(TechArea.C); break;
                case InputHelper.C_PLUS_PLUS: reflectedDeveloper.setTechArea(TechArea.CPlusPlus); break;
                case InputHelper.C_SHARP: reflectedDeveloper.setTechArea(TechArea.CSharp); break;
                case InputHelper.PHP: reflectedDeveloper.setTechArea(TechArea.PHP); break;
                case InputHelper.PYTHON: reflectedDeveloper.setTechArea(TechArea.Python); break;
            }
        }
    }
}

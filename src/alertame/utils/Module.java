/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package alertame.utils;

import java.lang.reflect.Field;

/**
 *
 * @author RomeroGomes
 */
public class Module {
    
    //atualizar valores atraves da tabela mdl_modules
    
    public static final int ASSIGNMENT = 1;
    public static final int CHAT = 2;
    public static final int CHOICE = 3;
    public static final int DATA = 4;
    public static final int FORUM = 5;
    public static final int GLOSSARY = 6;
    public static final int HOTPOT = 7;
    public static final int JOURNAL = 8;
    public static final int LABEL = 9;
    public static final int LAMS = 10;
    public static final int LESSON = 11;
    public static final int QUIZ = 12;
    public static final int RESOURCE = 13;
    public static final int SCORM = 14;
    public static final int SURVEY = 15;
    public static final int WIKI = 16;
    public static final int WORKSHOP = 17;
    public static final int ALERTAME = 18;
    public static final int VISIBLE = 1;
    public static final int INVISIBLE = 0;
    
    public static int getModuloID (String nomeModulo) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("nomeModulo: "+nomeModulo);
        Field declaredField = Module.class.getDeclaredField(nomeModulo);
        int ID = declaredField.getInt(nomeModulo);
        System.out.println("ID Modulo: "+ID);
        return ID;
    }
    
}

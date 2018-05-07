package com.java.api;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.java.api.UseCase.UseCases;

/**
 *����ע�⣺
 * 
 * */
public class UserCaseTest {
public static void main(String[] args) {
     List<Integer> useCases = new ArrayList<Integer>();
     Collections.addAll(useCases, 47, 48, 49, 50);
     trackUseCases(useCases, PasswordUtils.class);
}
public static void trackUseCases(List<Integer> useCases, Class<?> cl) {
    for (Method m : cl.getDeclaredMethods()) {
        //���ע��Ķ���
        UseCases uc = m.getAnnotation(UseCases.class);
        if (uc != null) {
            System.out.println("Found Use Case:" + uc.id() + " "
                        + uc.description());
            useCases.remove(new Integer(uc.id()));
        }
    }
    for (int i : useCases) {
        System.out.println("Warning: Missing use case-" + i);
    }
}
}
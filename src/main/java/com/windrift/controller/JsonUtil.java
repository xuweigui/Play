package com.windrift.controller;

import com.windrift.model.entity.Employees;

import java.util.List;

/**
 * Created by gary on 5/06/14.
 */
public class JsonUtil {

    public static String getJsonForUserList(List<Employees> employees) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Employees e : employees) {
            sb.append("{");
            sb.append("\"empNo\":\"").append(e.getEmpNo()).append("\",")
                    .append("\"firstName\":\"").append(e.getFirstName()).append("\",")
                    .append("\"lastName\":\"").append(e.getLastName()).append("\",")
                    .append("\"gender\":\"").append(e.getGender()).append("\",")
                    .append("\"title\":\"").append(e.getCurrentTitle().getTitle()).append("\",")
                    .append("\"hireDate\":\"").append(e.getHireDate()).append("\"");
            sb.append("},");
        }
        sb.append("]");
        return sb.toString();
    }

}

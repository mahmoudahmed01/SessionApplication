package org.diveinoracle.session.view;

import java.util.HashMap;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

public class MyBean {
    public MyBean() {
    }
    
    String studentName;

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }
    

    public void onClickSaveDataBtn(ActionEvent actionEvent) {
        // Add event code here...
        SessionUtil.storeOnSession("studentName", studentName);
        
        //Map 
        Map studentAsMap = new HashMap<String,String>();
        studentAsMap.put("Name", studentName);
        SessionUtil.storeOnSession("studentAsMap", studentAsMap);
        
        //Array of String
        String[] students = { "0)" + studentName ,
                              "1)" + studentName};
        SessionUtil.storeOnSession("studentAsArray", students);
        
                        
        //Class Object
        Student student = new Student(studentName);
        SessionUtil.storeOnSession("studentAsObj", student);
        
        
    }

    public void onClickReadDataBtn(ActionEvent actionEvent) {
        // Add event code here...
        String studentName = (String)SessionUtil.getFromSession("studentName");
        Map studentAsMap = (Map) SessionUtil.getFromSession("studentAsMap");
        String[] studentAsArray = (String [])SessionUtil.getFromSession("studentAsArray");
        Student studentAsObj = (Student) SessionUtil.getFromSession("studentAsObj");
        
        String msgText = " Map student name is " + studentAsMap.get("Name") +
                         " , Student in Array [0] " + studentAsArray[0] +
                         " , Student in Class Object " + studentAsObj.getStudentName();
        
        FacesMessage facesMsg = new FacesMessage(msgText);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }
}

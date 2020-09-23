package org.diveinoracle.session.view;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

public class MyBean {
    public MyBean() {
    }
    
    String studentName;
    String studentAge;

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentAge(String studentClass) {
        this.studentAge = studentClass;
    }

    public String getStudentAge() {
        return studentAge;
    }
    

    public void onClickSaveDataBtn(ActionEvent actionEvent) {
        // Add event code here...
        
        SessionUtil.storeOnSession("studentName", studentName);
        SessionUtil.storeOnSession("studentAge", studentAge);
        
    }

    public void onClickReadDataBtn(ActionEvent actionEvent) {
        // Add event code here...
        String studentName = (String)SessionUtil.getFromSession("studentName");
        String studentAge = (String) SessionUtil.getFromSession("studentAge");
        
        String msgText  = studentName + " is " + studentAge + " YO";

        FacesMessage facesMsg = new FacesMessage(msgText);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }
}

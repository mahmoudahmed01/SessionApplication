package org.diveinoracle.session.view;

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
        
    }

    public void onClickReadDataBtn(ActionEvent actionEvent) {
        // Add event code here...
        String studentName = (String)SessionUtil.getFromSession("studentName");
        
        String msgText  =  "Student Name in Session is " + studentName ;

        FacesMessage facesMsg = new FacesMessage(msgText);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }
}

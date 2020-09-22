package org.diveinoracle.session.view;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

public class MyBean {
    public MyBean() {
    }
    
    String studentName;
    String studentClass;

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void onClickSaveDataBtn(ActionEvent actionEvent) {
        // Add event code here...
        
        SessionUtil.storeOnSession("studentName", this.getStudentName());
        SessionUtil.storeOnSession("studentClass", this.getStudentClass());
        
    }

    public void onClickReadDataBtn(ActionEvent actionEvent) {
        // Add event code here...
        String studentName = (String)SessionUtil.getFromSession("studentName");
        String studentClass = (String) SessionUtil.getFromSession("studentClass");
        
        String msgText  = studentName + " is in class " + studentClass;

        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "My Message", msgText);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }
}

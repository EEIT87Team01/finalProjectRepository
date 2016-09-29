package iii.runninglife.globalservice;

import javax.persistence.ParameterMode;

import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.procedure.ProcedureOutputs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class StoredProcedure {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public StoredProcedure() {super();}
	public StoredProcedure(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
	public SessionFactory getSessionFactory() {return sessionFactory;}
	public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
	
	public void main(String[] args) {
		System.out.println(getRecordID());
	}
	  
    public String getRecordID(){
        ProcedureCall call = sessionFactory.getCurrentSession().createStoredProcedureCall("getRecordID");
        call.registerParameter0(1, String.class,ParameterMode.OUT);
        ProcedureOutputs outputs = call.getOutputs();
        String recordID = (String)outputs.getOutputParameterValue(1);
 
        return recordID;
    }
}

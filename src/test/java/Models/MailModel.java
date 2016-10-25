package Models;

public class MailModel{

	public String recepient;
	public String subj;
	public String body;
	
	
	public MailModel(String recepient, String subj, String body) {
		this.recepient = recepient;
		this.subj = subj;
		this.body = body;
	}


	public Boolean compareTo(MailModel o) {
		if (subj.equals(o.subj)) return true;
		else return false;
		  
	
	}
}

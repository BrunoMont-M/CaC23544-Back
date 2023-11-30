package ar.com.codoacodo.interfaces;

public class SMSLogger implements ILogger {
	
	private String number;

	public SMSLogger() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void log() {
		System.out.println("Enviando sms al: " + getNumber());

	}
	
	public void setNumber(String number) { 
		this.number = number;
	}
	
	public String getNumber() {
		return this.number;
	}

}

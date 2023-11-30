package ar.com.codoacodo.interfaces;

public class FSLogger implements ILogger {

//	Al implementar el metodo log estamos sobreescribiendo
	@Override
	public void log() {
		System.out.println("Grabando en c:/bla");
	}
}
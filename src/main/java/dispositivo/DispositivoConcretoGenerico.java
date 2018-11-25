package dispositivo;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("Generico")
public class DispositivoConcretoGenerico extends DispositivoConcreto{
	
	public void encenderSegunConcreto() {
		/*Deber�a cada concreto posta hacer su magia*/
		this.encender();
	}
	public void apagarSegunConcreto() {
		/*Deber�a cada concreto hacer su magia*/
		this.apagar();
	}
	public void ponerEnAhorroDeEnergiaSegunConcreto() {
		/*Deber�a cada concreto hacer su magia*/
		this.ponerEnAhorroDeEnergia();
	}
	public void sacarDeAhorroDeEnergiaSegunConcreto() {
		/*Deber�a cada concreto hacer su magia*/
		this.sacarDeAhorroDeEnergia();
	}

}

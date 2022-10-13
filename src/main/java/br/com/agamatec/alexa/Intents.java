package br.com.agamatec.alexa;

public enum Intents {
	MELHORES_JOGADORES_INTENT("MelhoresJogadoresIntent");
	
	private String intentName;

	private Intents(String intentName) {
		this.intentName = intentName;
	}

	public String getIntentName() {
		return intentName;
	}
}

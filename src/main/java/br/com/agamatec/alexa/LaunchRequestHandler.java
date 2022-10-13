package br.com.agamatec.alexa;

import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

public class LaunchRequestHandler implements RequestHandler {

	private static final String GREETING_SPEECH_TEXT = "Bem-vindo ao FIFA Voice. A enciclopédia do Modo Carreira FIFA";

	public boolean canHandle(HandlerInput input) {
		return input.matches(Predicates.requestType(LaunchRequest.class));
	}

	public Optional<Response> handle(HandlerInput input) {
		String greetingSpeech = GREETING_SPEECH_TEXT;
		return input.getResponseBuilder().withSpeech(greetingSpeech).withReprompt(greetingSpeech).build();
	}

}

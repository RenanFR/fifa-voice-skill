package br.com.agamatec.alexa;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

import org.springframework.web.util.UriComponentsBuilder;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.request.Predicates;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.agamatec.alexa.model.Player;
import lombok.extern.java.Log;

@Log
public class MelhoresJogadoresIntentHandler implements RequestHandler {

	private static final String AGAMA_LOAD_BALANCER_DNS = "http://agama-469974389.sa-east-1.elb.amazonaws.com/";
	private static final String PLAYERS_ENDPOINT = "players";

	public boolean canHandle(HandlerInput input) {
		return input.matches(Predicates.intentName(Intents.MELHORES_JOGADORES_INTENT.getIntentName()));
	}

	public Optional<Response> handle(HandlerInput input) {
		final StringBuilder bestPlayersSpeech = new StringBuilder();
		ObjectMapper objectMapper = new ObjectMapper();
		HttpClient httpClient = HttpClient.newBuilder().build();
		IntentRequest intentRequest = (IntentRequest) input.getRequestEnvelope().getRequest();
		Optional<Slot> quantidadeSlot = Optional.ofNullable(intentRequest.getIntent().getSlots().get("quantidade"));

		try {
			Integer amountOfPlayers = quantidadeSlot.isPresent() && Optional.ofNullable(quantidadeSlot.get()).isPresent()
					&& Optional.ofNullable(quantidadeSlot.get().getValue()).isPresent()
							? Integer.parseInt(quantidadeSlot.get().getValue())
							: 5;
			log.info("Buscando " + amountOfPlayers + " jogadores");
			URI fifaVoiceBackendURI = UriComponentsBuilder.fromHttpUrl(AGAMA_LOAD_BALANCER_DNS).path(PLAYERS_ENDPOINT)
					.queryParam("amountOfPlayers", amountOfPlayers).build().toUri();
			log.info("URI: " + fifaVoiceBackendURI.toString());
			HttpRequest request = HttpRequest.newBuilder().uri(fifaVoiceBackendURI).GET().build();
			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
			List<Player> players = objectMapper.readValue(response.body(), new TypeReference<List<Player>>() {
			});
			players.forEach(player -> {
				bestPlayersSpeech.append(player.getName());
				bestPlayersSpeech.append(",");
			});
			log.info("Texto da lista de jogadores: " + bestPlayersSpeech.toString());
		} catch (Exception e) {
			log.severe(e.getMessage());
		}

		return input.getResponseBuilder()
				.withSimpleCard("Aqui a lista dos melhores jogadores:", bestPlayersSpeech.toString())
				.withSpeech(bestPlayersSpeech.toString()).build();
	}

}

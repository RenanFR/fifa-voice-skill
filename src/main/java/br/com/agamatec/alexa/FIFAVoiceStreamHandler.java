package br.com.agamatec.alexa;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;

public class FIFAVoiceStreamHandler extends SkillStreamHandler {

	private static Skill getSkill() {
		return Skills.standard().addRequestHandlers(new MelhoresJogadoresIntentHandler(), new LaunchRequestHandler()).build();
	}

	public FIFAVoiceStreamHandler() {
		super(getSkill());
	}
}

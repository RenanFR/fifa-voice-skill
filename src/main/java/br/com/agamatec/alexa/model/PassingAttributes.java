package br.com.agamatec.alexa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PassingAttributes {
	public int vision;
	
	public int crossing;
	
	public int freeKickAccuracy;
	
	public int shortPassing;
	
	public int longPassing;
	
	public int curve;
}

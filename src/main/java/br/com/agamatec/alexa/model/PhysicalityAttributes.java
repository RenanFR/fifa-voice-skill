package br.com.agamatec.alexa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhysicalityAttributes {
	public int jumping;
	
	public int stamina;
	
	public int strength;
	
	public int aggression;
}

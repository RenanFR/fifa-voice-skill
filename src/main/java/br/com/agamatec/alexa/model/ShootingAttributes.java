package br.com.agamatec.alexa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShootingAttributes {
	public int positioning;
	
	public int finishing;
	
	public int shotPower;
	
	public int longShots;
	
	public int volleys;
	
	public int penalties;
}

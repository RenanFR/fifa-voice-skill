package br.com.agamatec.alexa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DribblingAttributes {
	public int agility;
	
	public int balance;
	
	public int reactions;
	
	public int ballControl;
	
	public int dribbling;
	
	public int composure;
}

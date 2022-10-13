package br.com.agamatec.alexa.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(of = { "name", "height", "age", "position", "rating" })
public class Player {
	
	public int id;

	public int resourceId;

	public int resourceBaseId;

	public int futBinId;

	public String futWizId;

	public String firstName;

	public String lastName;

	public String name;

	public String commonName;

	public int height;

	public int weight;

	public String birthDate;

	public int age;

	public int league;

	public int nation;

	public int club;

	public int rarity;

	public String position;

	public int skillMoves;

	public int weakFoot;

	public String foot;

	public String attackWorkRate;

	public String defenseWorkRate;

	public int totalStats;

	public int totalStatsInGame;

	public String color;

	public int rating;

	public int ratingAverage;

	public int pace;

	public int shooting;

	public int passing;

	public int dribbling;

	public int defending;

	public int physicality;

	public PaceAttributes paceAttributes;

	public ShootingAttributes shootingAttributes;

	public PassingAttributes passingAttributes;

	public DribblingAttributes dribblingAttributes;

	public DefendingAttributes defendingAttributes;

	public PhysicalityAttributes physicalityAttributes;

	public GoalkeeperAttributes goalkeeperAttributes;
	
	@JsonIgnore
	public List<Object> traits;

	@JsonIgnore
	public List<Object> specialities;

}

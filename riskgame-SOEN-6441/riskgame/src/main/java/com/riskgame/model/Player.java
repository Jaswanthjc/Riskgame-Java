package com.riskgame.model;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.riskgame.strategy.StrategyInterface;

import lombok.Getter;
import lombok.Setter;

/**
 * Player class manages information of players and their territories.
 * 
 * Two annotations (Getter, Setter) you can see on the top of the class are
 * lombok dependencies to automatically generate getter, setter in the code.
 * 
 * @author <a href="mailto:z_tel@encs.concordia.ca">Zankhanaben Patel</a>
 * @author <a href="mailto:ko_pate@encs.concordia.ca">Koshaben Patel</a>
 *         documentation added
 * @see PlayerTerritory
 */

@Getter
@Setter
@JsonIgnoreProperties
public class Player {
	/**
	 * Stores the id of player
	 */
	private int playerId;

	/**
	 * Stores the name of player
	 */
	private String playerName;

	/**
	 * The number of army owns by a player
	 */
	private int armyOwns;

	/**
	 * The number of army of playerReinforceArmy
	 */
	private int playerReinforceArmy;

	/**
	 * List of Territories owns by player
	 */
	private List<PlayerTerritory> playerterritories = new ArrayList<PlayerTerritory>();

	/**
	 * List of cards owned by player
	 */
	private List<RiskCard> cardListOwnedByPlayer = new ArrayList<RiskCard>();

	/**
	 * How many times player has exchanged the cards
	 */
	private int exchangeCount;

	/**
	 * type of player (human or computer)
	 */
	private String playerType;

	/**
	 * Name of strategy player is playing
	 */
	private String strategyName;

	/**
	 * Strategy representation of the player (different player strategy will have
	 * different reinforcement, attack and fortification.
	 */
	
	@JsonIgnore
	private StrategyInterface strategy;

	/**
	 * This method will minus reinforcement army from player's total army
	 * 
	 * @param armyToPlace
	 */
	public void placeReinforcement(int armyToPlace) {

		this.playerReinforceArmy = this.playerReinforceArmy - armyToPlace;
	}

	/**
	 * This method is used to execute player's reinforce, attack, fortification
	 * method
	 * 
	 * @param methodName    Like REINFORCE, ATTACK, FORTIFY
	 * @param gamePlayPhase GamePlayPhase Object
	 * @return updated GamePlayPhase object
	 */
	public GamePlayPhase executeStrategy(String methodName, GamePlayPhase gamePlayPhase) {
		if (methodName.equalsIgnoreCase("REINFORCEMENT")) {
			this.strategy.reinforce(gamePlayPhase);
		} else if (methodName.equalsIgnoreCase("ATTACK")) {
			this.strategy.attack(gamePlayPhase);
		} else if (methodName.equalsIgnoreCase("FORTIFICATION")) {
			this.strategy.fortify(gamePlayPhase);
		}

		return gamePlayPhase;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\n Player [playerId=" + playerId + ", playerName=" + playerName + ", armyOwns=" + armyOwns
				+ ", playerReinforceArmy=" + playerReinforceArmy + ", playerterritories=" + playerterritories
				+ ", cardListOwnedByPlayer=" + cardListOwnedByPlayer + ", exchangeCount=" + exchangeCount
				 + ", playerType=" + playerType + ", strategyName="
				+ strategyName +"]" +"\n";
	}

}

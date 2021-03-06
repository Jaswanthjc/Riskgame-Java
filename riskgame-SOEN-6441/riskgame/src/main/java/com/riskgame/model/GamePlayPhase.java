/**
 * 
 */
package com.riskgame.model;

import java.util.List;
import java.util.Observable;
import java.util.concurrent.Exchanger;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * This class represents the state of the game on different point of time.
 * 
 * Two annotations (Getter, Setter) you can see on the top of the class are
 * lombok dependencies to automatically generate getter, setter in the code.
 *
 * @author <a href="mailto:j_banawa@encs.concordia.ca">Jaswanth Banawathu</a>
 * @author <a href="mailto:p_thumma@encs.concordia.ca">Piyush Thummar</a>
 *         documenation added
 * @see Player
 */
@Getter
@Setter
@JsonIgnoreProperties
public class GamePlayPhase {

	/**
	 * It'll manage list of player in that particlaur state of game
	 */
	private List<Player> playerList;

	/**
	 * It'll store name of game phase i.e. startUp, reinforcement etc.
	 */
	private String gamePhase;

	/**
	 * name of the map file
	 */
	private String fileName;

	/**
	 * List of total risk cards
	 */
	private List<RiskCard> riskCardList;

	/**
	 * Winner player name
	 */
	private String winner;

	/**
	 * Total number of games in tournament
	 */
	private int numberOfGames;

	/**
	 * number of turn in one game
	 */
	private int maxNumberOfTurns;

	/**
	 * game play phase id (unique)
	 */
	private int gamePlayPhaseId;

	/**
	 * entire map information
	 */
	private RiskMap riskMap;

	/**
	 * current player id who is playing the game
	 */
	private int currentPlayerId;

	/**
	 * current status of game
	 */
	private String status;

	/**
	 * current player riskcardExchane will store in this model
	 */
	private RiskCardExchange riskCardExchange;

	/**
	 * action of the User like Start Game, Start tournament or previously Load game
	 */
	private String action;

	/**
	 * totalCountries per map
	 */
	private int totalCountries;

	private String phaseView;
	private String playerdomination;
	private String territoryList;
	private String adjacentTerritory;
	private String cardExchangeView;
	private String consollog;

	private int playerIndex;
	private String playerName;
	private Player currentPlayer;
	private boolean countryConquredInSingleAttack;

	private boolean attackphaseEnded;
	private boolean allOutTerritoryConqured;
	private boolean fortificationStarted;
	private int attackerDice;
	private int defenderDice;

	private Player defenderPlayer;
	private String fromCountryAttack;
	private String toCountryAttack;

	private boolean exchangeRequired;

	private boolean attackFire;

	private boolean attackMove;

	private List<RiskCard> cardList;

	private String currentPhase;

	private boolean gamewin;

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GamePlayPhase \n [playerList=" + playerList + ", gamePhase=" + gamePhase + ", fileName=" + fileName
				+ ", riskCardList=" + riskCardList + ", winner=" + winner + ", numberOfGames=" + numberOfGames
				+ ", maxNumberOfTurns=" + maxNumberOfTurns + ", gamePlayPhaseId=" + gamePlayPhaseId + ", riskMap="
				+ riskMap + ", currentPlayerId=" + currentPlayerId + ", status=" + status + ", riskCardExchange="
				+ riskCardExchange + "totalCountries=" + totalCountries + "]" + "\n";
	}

}

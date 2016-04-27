package client;

import java.util.List;
import java.util.Random;
import fifa.client.Info;
import fifa.client.InfoSoapType;
import fifa.client.TPlayersWithCards;

public class FIFAServiceClient {
	private static final FIFAServiceClient INSTANCE = new FIFAServiceClient();
	private InfoSoapType port;

	private FIFAServiceClient() {
		Info service = new Info();
		port = service.getInfoSoap();
	}

	public List<String> getCities() {
		return port.cities().getString();
	}

	public String getRandomTeamName() {
		int countTeams = port.teams().getTTeamInfo().size();
		Random random = new Random();
		int num = random.nextInt(countTeams);
		return port.teams().getTTeamInfo().get(num).getSName();
	}

	public int getRedCards(String teamName) {
		int countCards = 0;
		List<TPlayersWithCards> playersWithRedCards = port.allPlayersWithRedCards(true, false).getTPlayersWithCards();
		for (TPlayersWithCards player : playersWithRedCards) {
			if (teamName.equals(player.getSTeamName())) {
				countCards += player.getIRedCards();
			}
		}
		return countCards;
	}

	public int getYellowCards(String teamName) {
		int countCards = 0;
		List<TPlayersWithCards> playersWithYellowCards = port.allPlayersWithYellowCards(true, false)
				.getTPlayersWithCards();
		for (TPlayersWithCards player : playersWithYellowCards) {
			if (teamName.equals(player.getSTeamName())) {
				countCards += player.getIYellowCards();
			}
		}
		return countCards;
	}

	public static FIFAServiceClient getInstacne() {
		return INSTANCE;
	}

	public static void main(String[] args) {
		String teamName = FIFAServiceClient.getInstacne().getRandomTeamName();
		System.out.println("Team Name: " + teamName);
		System.out.println("Red Cards: " + FIFAServiceClient.getInstacne().getRedCards(teamName));
		System.out.println("Yellow Cards: " + FIFAServiceClient.getInstacne().getYellowCards(teamName));
	}
}

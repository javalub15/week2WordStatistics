package com.cagara;

import com.cagara.dto.Statistics;
import com.cagara.service.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WordApplication {

	public static void main(String[] args) {
		String URL = "http://www.gutenberg.org/files/1342/1342-0.txt";
		String content = ConnectionService.getContent(URL);
		TextService textService = new TextServiceImpl();
		WordStatisticService wordStatisticService = new WordStatisticServiceImpl(textService);
		AlphabetStatisticService alphabetStatisticService = new AlphabetStatisticServiceImpl();
		StatisticService statisticService = new StatisticServiceImpl(textService, wordStatisticService, alphabetStatisticService);

		Statistics statistics = statisticService.calculateStatistics(content);
		statistics.printStatistics();
	}


}

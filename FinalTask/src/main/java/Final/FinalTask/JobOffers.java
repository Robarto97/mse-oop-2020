package Final.FinalTask;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * @author Robart Petrov
 *
 */
public class JobOffers implements Runnable {
	private String jobUrl;

	/**
	 * @param jobUrl
	 */
	public JobOffers(String jobUrl) {
		this.jobUrl = jobUrl;
	}

	public void run() {
		try {
			Document document = Jsoup.connect(jobUrl).get();
			Elements name = document.select("body > table:nth-child(4) > tbody > tr > td > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(2) > td > b");
			System.out.println(name.text());

			Elements link = document.select("head > link:nth-child(9)");
			System.out.println(link.text());

			Elements position = document.select("body > table:nth-child(4) > tbody > tr > td > table > tbody > tr:nth-child(5) > td > table > tbody > tr:nth-child(1) > td > h1");
			System.out.println(position.text());
			
			Elements place = document.select("body > table:nth-child(4) > tbody > tr > td > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(3) > td");
			System.out.println(place.text());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

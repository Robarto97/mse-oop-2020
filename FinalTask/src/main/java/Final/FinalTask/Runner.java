package Final.FinalTask;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * @author Robart Petrov
 *
 */
public class Runner {
    /**
     * @param args
     * @throws IOException
     */
    public static void main( String[] args ) throws IOException {
		for (int i = 0; i < 30; i += 15) {
			Document document = Jsoup.connect("https://www.jobs.bg/front_job_search.php?frompage=0").get();
			Elements select = document.select(".joblink");
			select.forEach(element -> {
				String attr = element.attr("href");
				String jobUrl = "https://www.jobs.bg/" + attr;
				JobOffers jobs = new JobOffers(jobUrl);
				Thread thread = new Thread(jobs);
				thread.start();
			});
		}
		System.out.println();
    }
}

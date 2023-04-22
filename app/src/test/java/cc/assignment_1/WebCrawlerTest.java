package cc.assignment_1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jsoup.nodes.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class WebCrawlerTest {
    @Nested
    protected class Example {

        private WebCrawler webCrawler;

        @BeforeEach
        protected void beforeEach() {
            ExecutorService executor = Executors.newCachedThreadPool();
            this.webCrawler = new WebCrawler(executor, "https://example.com/", 2);
        }

        @Test
        @DisplayName("Basic call to getReport()")
        protected void testCrawl() {
            Document report = this.webCrawler.getReport();
            MarkdownConverter converter = new MarkdownConverter(report);
            System.out.println(converter.convertDocument());
        }
    }
}

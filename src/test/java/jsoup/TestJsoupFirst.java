package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class TestJsoupFirst {

    @Test
    public void testUrl() throws IOException {
        Document document = Jsoup.parse(new URL("http://yutin.vip:666"), 5000);

        System.out.println(document.getElementsByTag("img"));

      //  Document document = Jsoup.parse(in);//inputStream

        Element eID = document.getElementById("ID");
        Elements eTag = document.getElementsByTag("Tag");
        Elements eClass = document.getElementsByClass("className");
        Elements eAttr = document.getElementsByAttribute("属性");
    }
}

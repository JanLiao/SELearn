package football;

import football.model.Match;
import football.over.OverFootball;
import football.over.QiuTanOverFootball;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.List;

public class FootballRead {
    private static final String FOOTBALL_URL = "http://bf.win007.com/football/Over_20201127.htm";

    private static void parseHTML() throws IOException {
        String html = HttpClient.doGet(FOOTBALL_URL);
        Document document =  Jsoup.parse(new URL(FOOTBALL_URL).openStream(), "GBK", FOOTBALL_URL);
        /**
         * 下面是Jsoup展现自我的平台
         */
        // 6.Jsoup解析html
//        Document document = Jsoup.parse(html, "GBK");
        //像js一样，通过class 获取列表下的所有博客
        Elements postItems = document.select("table");
//        System.out.println(postItems.size());
        //循环处理每篇博客
        for (Element postItem : postItems) {
            System.out.println(postItem);
        }
    }

    public static void main(String[] args) throws IOException {
//        parseHTML();
        String date = "20201127";
        OverFootball matchs = new QiuTanOverFootball();
        List<Match> matchList = matchs.queryMatchsByDate(date);
    }
}

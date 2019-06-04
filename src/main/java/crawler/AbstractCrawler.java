package crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCrawler {
    static int totalPage = 500;

    public void launch(int page,int city,FileOutputStream fis) throws IOException {
        String tempUrl = getUrl();

        tempUrl = tempUrl.replace("$",""+ page).replace("#",""+city);
        Document doc = Jsoup.connect(tempUrl).get();

        Elements container = doc.getElementsByClass("m_srchList");

        Document containerDoc = Jsoup.parse(container.toString());

        Elements trEle = containerDoc.select("tr");

        List<org.bson.Document> documentList = new ArrayList<org.bson.Document>();

        for (Element clearfixli : trEle){
            Document clearfixliDoc = Jsoup.parse(clearfixli.toString());
            Elements name = clearfixliDoc.select(".ma_h1");  //选择器的形式


            fis.write((name.text() +"\r\n").getBytes());
            System.out.println(name.text());  //分类
        }
    }

    abstract String getUrl();
}

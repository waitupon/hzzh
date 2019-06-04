package crawler.industry;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractIndustryCrawler {
    static int totalPage = 500;

    public void launch(int page,int industry,FileOutputStream fis) throws IOException {
        String tempUrl = getUrl();
        String industryStr = "";
        if(Integer.valueOf(industry) <10){
            industryStr = "0" + industry;
        }
        tempUrl = tempUrl.replace("$",""+ page).replace("#",industryStr);
        Document doc = Jsoup.connect(tempUrl).get();

        Elements container = doc.getElementsByClass("m_srchList");

        Document containerDoc = Jsoup.parse(container.toString());

        Elements trEle = containerDoc.select("tr");

        List<org.bson.Document> documentList = new ArrayList<org.bson.Document>();

        for (Element clearfixli : trEle){
            Document clearfixliDoc = Jsoup.parse(clearfixli.toString());
            Elements name = clearfixliDoc.select(".ma_h1");  //选择器的形式

            if(name.text().length()<=4){
                continue;
            }
            fis.write((name.text() +"\r\n").getBytes());
            System.out.println(name.text());  //分类
        }
    }

    abstract String getUrl();
}

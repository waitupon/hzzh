package crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import utils.MongodbUtils;
import utils.ProvinceDic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChinaZCrawler {

    static String url = "https://www.qichacha.com/gongsi_area.shtml?prov=AH&city=#&p=$";

    static int totalPage = 500;



    public void launch(int page,int city,FileOutputStream fis) throws IOException {
        String tempUrl = url;

        tempUrl = tempUrl.replace("$",""+ page).replace("#",""+city);
        Document doc = Jsoup.connect(tempUrl).get();

        Elements container = doc.getElementsByClass("m_srchList");

        Document containerDoc = Jsoup.parse(container.toString());

        Elements trEle = containerDoc.select("tr");

        List<org.bson.Document> documentList = new ArrayList<org.bson.Document>();

        for (Element clearfixli : trEle){
            Document clearfixliDoc = Jsoup.parse(clearfixli.toString());
            Elements name = clearfixliDoc.select(".ma_h1");  //选择器的形式


//            org.bson.Document d = new org.bson.Document();
//            d.append("name",name.text());
//            documentList.add(d);
            if(name.text().length()<=4){
                continue;
            }
            fis.write((name.text() +"\r\n").getBytes());
            System.out.println(name.text());  //分类
        }
//        if(documentList.size()>0){
//            MongodbUtils.saveList(documentList);
//        }
    }

    public static void main(String[] args) throws IOException {
        ChinaZCrawler chinaZCrawler = new ChinaZCrawler();
          int city = 340100;
//        ProvinceDic dic = new ProvinceDic();
//        String[] sx = dic.getSx();
        FileOutputStream fis = new FileOutputStream("/Users/wenhao/pro/AH.txt");
        for(int c = city;c<=341800; c+=100){
            if(c==340900){
                continue;
            }
            for(int i=1; i<=totalPage;i++){
                chinaZCrawler.launch(i,c,fis);
            }
        }

        fis.close();


    }
}

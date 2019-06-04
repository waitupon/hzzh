package crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BJQichachaCrawler extends AbstractCrawler
{

    @Override
    String getUrl() {
        return "https://www.qichacha.com/gongsi_area.shtml?prov=BJ&city=#&p=$";
    }

    public static void main(String[] args) throws IOException {
        BJQichachaCrawler chinaZCrawler = new BJQichachaCrawler();
        int city = 110101;
        FileOutputStream fis = new FileOutputStream("/Users/wenhao/pro/BJ.txt");
        List<Integer>except = new ArrayList<>();
        except.add(110103);
        except.add(110104);
        except.add(110110);
        for(int c = city;c<=110119; c++){
            if(except.contains(c)){
                continue;
            }
            for(int i=1; i<=totalPage;i++){
                chinaZCrawler.launch(i,c,fis);
            }
        }

        fis.close();


    }
}

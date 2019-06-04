package crawler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TJQichachaCrawler extends AbstractCrawler
{

    @Override
    String getUrl() {
        return "https://www.qichacha.com/gongsi_area.shtml?prov=TJ&city=#&p=$";
    }

    public static void main(String[] args) throws IOException {
        TJQichachaCrawler chinaZCrawler = new TJQichachaCrawler();
        int city = 120101;
        FileOutputStream fis = new FileOutputStream("/Users/wenhao/pro/TJ.txt");
        List<Integer>except = new ArrayList<>();

        for(int c = city;c<=120106; c++){
            if(except.contains(c)){
                continue;
            }
            for(int i=1; i<=totalPage;i++){
                chinaZCrawler.launch(i,c,fis);
            }
        }

        city = 120110;

        for(int c = city;c<=120119; c++){
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

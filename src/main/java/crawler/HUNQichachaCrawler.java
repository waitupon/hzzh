package crawler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HUNQichachaCrawler extends AbstractCrawler
{

    @Override
    String getUrl() {
        return "https://www.qichacha.com/gongsi_area.shtml?prov=HUN&city=#&p=$";
    }

    public static void main(String[] args) throws IOException {
        HUNQichachaCrawler chinaZCrawler = new HUNQichachaCrawler();
        int city = 430100;
        FileOutputStream fis = new FileOutputStream("/Users/wenhao/pro/HUN.txt");
        List<Integer>except = new ArrayList<>();
        except.add(420400);
        for(int c = city;c<=431300; c+=100){
            if(except.contains(c)){
                continue;
            }
            for(int i=1; i<=totalPage;i++){
                chinaZCrawler.launch(i,c,fis);
            }
        }

        for(int i=1; i<=totalPage;i++){
            chinaZCrawler.launch(i,433100,fis);
        }


        fis.close();


    }
}

package crawler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HUBQichachaCrawler extends AbstractCrawler
{

    @Override
    String getUrl() {
        return "https://www.qichacha.com/gongsi_area.shtml?prov=HUB&city=#&p=$";
    }

    public static void main(String[] args) throws IOException {
        HUBQichachaCrawler chinaZCrawler = new HUBQichachaCrawler();
        int city = 420100;
        FileOutputStream fis = new FileOutputStream("/Users/wenhao/pro/HUB.txt");
        List<Integer>except = new ArrayList<>();
        except.add(420400);
        for(int c = city;c<=421300; c+=100){
            if(except.contains(c)){
                continue;
            }
            for(int i=1; i<=totalPage;i++){
                chinaZCrawler.launch(i,c,fis);
            }
        }

        for(int i=1; i<=totalPage;i++){
            chinaZCrawler.launch(i,422800,fis);
        }

        for(int i=1; i<=totalPage;i++){
            chinaZCrawler.launch(i,429000,fis);
        }
        fis.close();


    }
}

package crawler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NMGQichachaCrawler extends AbstractCrawler
{

    @Override
    String getUrl() {
        return "https://www.qichacha.com/gongsi_area.shtml?prov=NMG&city=#&p=$";
    }

    public static void main(String[] args) throws IOException {
        NMGQichachaCrawler chinaZCrawler = new NMGQichachaCrawler();
        int city = 150100;
        FileOutputStream fis = new FileOutputStream("/Users/wenhao/pro/NMG.txt");
        List<Integer>except = new ArrayList<>();
        for(int c = city;c<=150900; c+=100){
            if(except.contains(c)){
                continue;
            }
            for(int i=1; i<=totalPage;i++){
                chinaZCrawler.launch(i,c,fis);
            }
        }
        for(int i=1; i<=totalPage;i++){
            chinaZCrawler.launch(i,152200,fis);
        }

        for(int i=1; i<=totalPage;i++){
            chinaZCrawler.launch(i,152500,fis);
        }

        for(int i=1; i<=totalPage;i++){
            chinaZCrawler.launch(i,152900,fis);
        }
        fis.close();


    }
}

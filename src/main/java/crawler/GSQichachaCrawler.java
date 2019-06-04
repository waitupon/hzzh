package crawler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GSQichachaCrawler extends AbstractCrawler
{

    @Override
    String getUrl() {
        return "https://www.qichacha.com/gongsi_area.shtml?prov=GS&city=#&p=$";
    }

    public static void main(String[] args) throws IOException {
        GSQichachaCrawler chinaZCrawler = new GSQichachaCrawler();
        int city = 620100;
        FileOutputStream fis = new FileOutputStream("/Users/wenhao/pro/GS.txt");
        List<Integer>except = new ArrayList<>();
        for(int c = city;c<=621200; c+=100){
            if(except.contains(c)){
                continue;
            }
            for(int i=1; i<=totalPage;i++){
                chinaZCrawler.launch(i,c,fis);
            }
        }

        city = 622900;

        for(int c = city;c<=623000; c+=100){
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

package crawler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SXQichachaCrawler extends AbstractCrawler
{

    @Override
    String getUrl() {
        return "https://www.qichacha.com/gongsi_area.shtml?prov=SX&city=#&p=$";
    }

    public static void main(String[] args) throws IOException {
        SXQichachaCrawler chinaZCrawler = new SXQichachaCrawler();
        int city = 140100;
        FileOutputStream fis = new FileOutputStream("/Users/wenhao/pro/SX.txt");
        List<Integer>except = new ArrayList<>();
        for(int c = city;c<=141100; c+=100){
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

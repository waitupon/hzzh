package crawler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HLJQichachaCrawler extends AbstractCrawler
{

    @Override
    String getUrl() {
        return "https://www.qichacha.com/gongsi_area.shtml?prov=HLJ&city=#&p=$";
    }

    public static void main(String[] args) throws IOException {
        HLJQichachaCrawler chinaZCrawler = new HLJQichachaCrawler();
        int city = 230100;
        FileOutputStream fis = new FileOutputStream("/Users/wenhao/pro/HLJ.txt");
        List<Integer>except = new ArrayList<>();

        for(int c = city;c<=231200; c+=100){
            if(except.contains(c)){
                continue;
            }
            for(int i=1; i<=totalPage;i++){
                chinaZCrawler.launch(i,c,fis);
            }
        }

        for(int i=1; i<=totalPage;i++){
            chinaZCrawler.launch(i,232700,fis);
        }
        fis.close();


    }
}

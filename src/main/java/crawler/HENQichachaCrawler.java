package crawler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HENQichachaCrawler extends AbstractCrawler
{

    @Override
    String getUrl() {
        return "https://www.qichacha.com/gongsi_area.shtml?prov=HEN&city=#&p=$";
    }

    public static void main(String[] args) throws IOException {
        HENQichachaCrawler chinaZCrawler = new HENQichachaCrawler();
        int city = 410100;
        FileOutputStream fis = new FileOutputStream("/Users/wenhao/pro/HEN.txt");
        List<Integer>except = new ArrayList<>();

        for(int c = city;c<=411700; c+=100){
            if(except.contains(c)){
                continue;
            }
            for(int i=1; i<=totalPage;i++){
                chinaZCrawler.launch(i,c,fis);
            }
        }

        for(int i=1; i<=totalPage;i++){
            chinaZCrawler.launch(i,419000,fis);
        }
        fis.close();


    }
}

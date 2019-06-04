package crawler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QHQichachaCrawler extends AbstractCrawler
{

    @Override
    String getUrl() {
        return "https://www.qichacha.com/gongsi_area.shtml?prov=QH&city=#&p=$";
    }

    public static void main(String[] args) throws IOException {
        QHQichachaCrawler chinaZCrawler = new QHQichachaCrawler();
        int city = 630100;
        FileOutputStream fis = new FileOutputStream("/Users/wenhao/pro/QH.txt");
        List<Integer>except = new ArrayList<>();
        except.add(632400);
        for(int c = city;c<=630200; c+=100){
            if(except.contains(c)){
                continue;
            }
            for(int i=1; i<=totalPage;i++){
                chinaZCrawler.launch(i,c,fis);
            }
        }

        city = 632200;
        for(int c = city;c<=632800; c+=100){
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

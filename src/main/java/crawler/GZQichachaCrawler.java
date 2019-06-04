package crawler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GZQichachaCrawler extends AbstractCrawler
{

    @Override
    String getUrl() {
        return "https://www.qichacha.com/gongsi_area.shtml?prov=GZ&city=#&p=$";
    }

    public static void main(String[] args) throws IOException {
        GZQichachaCrawler chinaZCrawler = new GZQichachaCrawler();
        int city = 520100;
        FileOutputStream fis = new FileOutputStream("/Users/wenhao/pro/GZ.txt");
        List<Integer>except = new ArrayList<>();
        except.add(522400);
        except.add(522500);
        for(int c = city;c<=520600; c+=100){
            if(except.contains(c)){
                continue;
            }
            for(int i=1; i<=totalPage;i++){
                chinaZCrawler.launch(i,c,fis);
            }
        }

        city = 522300;

        for(int c = city;c<=522700; c+=100){
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

package crawler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GDQichachaCrawler extends AbstractCrawler
{

    @Override
    String getUrl() {
        return "https://www.qichacha.com/gongsi_area.shtml?prov=GD&city=#&p=$";
    }

    public static void main(String[] args) throws IOException {
        GDQichachaCrawler chinaZCrawler = new GDQichachaCrawler();
        int city = 440100;
        FileOutputStream fis = new FileOutputStream("/Users/wenhao/pro/GD.txt");
        List<Integer>except = new ArrayList<>();
        except.add(441000);
        except.add(441100);
        for(int c = city;c<=442000; c+=100){
            if(except.contains(c)){
                continue;
            }
            for(int i=1; i<=totalPage;i++){
                chinaZCrawler.launch(i,c,fis);
            }
        }

        city = 445100;

        for(int c = city;c<=445300; c+=100){
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

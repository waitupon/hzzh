package crawler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SCQichachaCrawler extends AbstractCrawler
{

    @Override
    String getUrl() {
        return "https://www.qichacha.com/gongsi_area.shtml?prov=SC&city=#&p=$";
    }

    public static void main(String[] args) throws IOException {
        SCQichachaCrawler chinaZCrawler = new SCQichachaCrawler();
        int city = 510100;
        FileOutputStream fis = new FileOutputStream("/Users/wenhao/pro/SC.txt");
        List<Integer>except = new ArrayList<>();
        except.add(510200);
        except.add(511200);
        for(int c = city;c<=512000; c+=100){
            if(except.contains(c)){
                continue;
            }
            for(int i=1; i<=totalPage;i++){
                chinaZCrawler.launch(i,c,fis);
            }
        }

        city = 513200;

        for(int c = city;c<=513400; c+=100){
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

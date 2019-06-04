package crawler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XJQichachaCrawler extends AbstractCrawler
{

    @Override
    String getUrl() {
        return "https://www.qichacha.com/gongsi_area.shtml?prov=XJ&city=#&p=$";
    }

    public static void main(String[] args) throws IOException {
        XJQichachaCrawler chinaZCrawler = new XJQichachaCrawler();
        int city = 650100;
        FileOutputStream fis = new FileOutputStream("/Users/wenhao/pro/XJ.txt");
        List<Integer>except = new ArrayList<>();
        except.add(650300);
        except.add(654100);
        for(int c = city;c<=650500; c+=100){
            if(except.contains(c)){
                continue;
            }
            for(int i=1; i<=totalPage;i++){
                chinaZCrawler.launch(i,c,fis);
            }
        }

        for(int i=1; i<=totalPage;i++){
            chinaZCrawler.launch(i,652300,fis);
        }
        city = 652700;

        for(int c = city;c<=653200; c+=100){
            if(except.contains(c)){
                continue;
            }
            for(int i=1; i<=totalPage;i++){
                chinaZCrawler.launch(i,c,fis);
            }
        }

        city = 654000;

        for(int c = city;c<=654300; c+=100){
            if(except.contains(c)){
                continue;
            }
            for(int i=1; i<=totalPage;i++){
                chinaZCrawler.launch(i,c,fis);
            }
        }

        for(int i=1; i<=totalPage;i++){
            chinaZCrawler.launch(i,659000,fis);
        }
        fis.close();


    }
}

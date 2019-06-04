package crawler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SHQichachaCrawler extends AbstractCrawler
{

    @Override
    String getUrl() {
        return "https://www.qichacha.com/gongsi_area.shtml?prov=SH&city=#&p=$";
    }

    public static void main(String[] args) throws IOException {
        SHQichachaCrawler chinaZCrawler = new SHQichachaCrawler();
        int city = 310101;
        FileOutputStream fis = new FileOutputStream("/Users/wenhao/pro/SH.txt");
        List<Integer>except = new ArrayList<>();
        except.add(310102);
        except.add(310103);
        except.add(310108);
        except.add(310111);
        except.add(310119);
        for(int c = city;c<=371700; c++){
            if(except.contains(c)){
                continue;
            }
            for(int i=1; i<=totalPage;i++){
                chinaZCrawler.launch(i,c,fis);
            }
        }
        for(int i=1; i<=totalPage;i++){
            chinaZCrawler.launch(i,310151,fis);
        }


        fis.close();


    }
}

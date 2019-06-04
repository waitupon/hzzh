package crawler.industry;

import crawler.AbstractCrawler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AQichachaCrawler extends AbstractIndustryCrawler
{

    @Override
    public String getUrl() {
        return "https://www.qichacha.com/gongsi_industry.shtml?industryCode=A&subIndustryCode=#&p=$";
    }

    public static void main(String[] args) throws IOException {
        AQichachaCrawler chinaZCrawler = new AQichachaCrawler();
        int industry = 1;
        FileOutputStream fis = new FileOutputStream("/Users/wenhao/industry/A.txt");
        List<Integer>except = new ArrayList<>();
        for(int c = industry;c<=5; c++){
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

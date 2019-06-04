package crawler.industry;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IQichachaCrawler extends AbstractIndustryCrawler
{

    @Override
    public String getUrl() {
        return "https://www.qichacha.com/gongsi_industry.shtml?industryCode=I&subIndustryCode=#&p=$";
    }

    public static void main(String[] args) throws IOException {
        IQichachaCrawler chinaZCrawler = new IQichachaCrawler();
        int industry = 63;
        FileOutputStream fis = new FileOutputStream("/Users/wenhao/industry/I.txt");
        List<Integer>except = new ArrayList<>();
        for(int c = industry;c<=65; c++){
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

public class Parser2
{
    public String[] sentenceParser(String query)
    {
        String querysplit[] = query.split("is ");
        String words[] = querysplit[0].split(" ");
        String credits[] = querysplit[1].split(" ");

        String[] output = new String[]{words[0],words[1],words[2],credits[0]};

        return output;
    }

    public String[] questionParser(String query)
    {
        String words[] ={};
        String credits[] ={};
        String output[] = new String[]{};
        if(query.contains("how much"))
        {
            if(query.contains("is"))
            {
                words = query.split("is ");
                credits = words[1].split(" ");
                output = new String[]{credits[0],credits[1],credits[2],credits[3]};
                return output;
            }
            else
            {
                output = new String[]{"I have no idea what you are talking about"};
                return output;
            }

        }
        else if(query.contains("how many"))
        {
            words = query.split("is ");
            credits = words[1].split(" ");
            output = new String[]{credits[0],credits[1],credits[2]};
            return output;
        }
        return null;
    }
}

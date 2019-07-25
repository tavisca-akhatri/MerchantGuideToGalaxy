public class Parser1
{
    public String[] parse(String query)
    {
        String split[] = query.split("is ");
        String split1[] = split[0].split(" ");
        String split2[] = split[1].split(" ");
        String[] output = new String[]{split1[0],split1[1],split1[2],split2[0]};

        return output;
    }

    public String[] parse1(String query)
    {
        String queryonsplit[] ={};
        String queryonsplit1[] ={};
        String output[] = new String[]{};
        if(query.contains("how much"))
        {
            if(query.contains("is"))
            {
                queryonsplit = query.split("is ");
                queryonsplit1 = queryonsplit[1].split(" ");
                output = new String[]{queryonsplit1[0],queryonsplit1[1],queryonsplit1[2],queryonsplit1[3]};
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
            queryonsplit = query.split("is ");
            queryonsplit1 = queryonsplit[1].split(" ");
            output = new String[]{queryonsplit1[0],queryonsplit1[1],queryonsplit1[2]};
            return output;
        }
        return null;
    }
}

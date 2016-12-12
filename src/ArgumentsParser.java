/**
 * Created by Jan on 05.12.2016.
 */
public class ArgumentsParser {
    private String filePath;
    private String partToRead;
    private int[] range;

    public ArgumentsParser(String [] arguments) throws Exception{
        filePath = arguments[0];
        partToRead = arguments[1];

        if(partToRead.equals("articles")){
            range = new int[2];
            try {
                range[0] = Integer.parseInt(arguments[2]);
                range[1] = Integer.parseInt(arguments[3]);
            }
            catch (Exception e){
                throw new Exception("not enough paramters or letters instead of numbers");
            }
        }




        else{
            range = new int[1];

            try {
                range[0] = Integer.parseInt(arguments[2]);
            }
            catch (Exception e){
                throw new Exception("not enough paramters or letters instead of numbers");
            }
        }
    }

    public String toRead() throws Exception{
        if(!partToRead.equals("chapter")&& !partToRead.equals("article")&&  !partToRead.equals("articles")){
            throw new Exception("Theres no such part of constitution");
        }
        return partToRead;
    }

    public int[] getRange(){
        return range;
    }
    public String getFilePath(){
        return filePath;
    }

}

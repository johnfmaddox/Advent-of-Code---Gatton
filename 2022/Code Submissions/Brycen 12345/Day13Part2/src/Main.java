import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        final String fileName = "Day13Part2/Data13.txt";
        File input = new File(fileName);
        try {
            Scanner in = new Scanner(input);
            String line = "";
            List<Packet> packetList = new ArrayList<>();
            int ans = 1;
            int indices = 1;
            while (in.hasNext()) {
                line = in.nextLine();
                Packet one = new Packet(line);
                packetList.add(one);
                line = in.nextLine();
                Packet two = new Packet(line);
                packetList.add(two);
                line = in.nextLine();
                indices++;
            }
            packetList.add(new Packet("[[2]]"));
            packetList.add(new Packet("[[6]]"));

            packetList.sort((p1, p2) -> p1.comp(p2));
            Collections.reverse(packetList);
            //System.out.println(packetList);
            for(int i = 0; i < packetList.size(); i++) {
                if(packetList.get(i).packet.equals("[[2]]") || packetList.get(i).packet.equals("[[6]]")) {
                    int position = i + 1;
                    ans = ans * position;
                }
            }
            System.out.println(ans);
        }
        catch(Exception ex) {
            System.out.println("error" + ex.getMessage());
        }
    }
}
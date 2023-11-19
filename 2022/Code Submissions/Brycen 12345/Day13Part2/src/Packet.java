import java.util.ArrayList;
import java.util.List;

public class Packet {
    String packet;
    boolean isInt = true;
    List<Packet> within = new ArrayList<>();
    int packetVal;
    public Packet(String packet) {
        this.packet = packet;
        if (!packet.startsWith("[")) {
            packetVal = Integer.parseInt(packet);
        } else {
            list(packet);
        }
    }
    public void list(String packet) {
        isInt = false;
        int depth = 0;
        String temp = "";
        packet = packet.substring(1, packet.length() -1);
        for(String str : packet.split("")) {
            if(str.equals(",") && depth == 0) {
                within.add(new Packet(temp));
                temp = "";
            } else {
                if(str.equals("[")) {
                    depth += 1;
                    temp += str;
                } else if(str.equals("]")) {
                    depth -= 1;
                    temp += str;
                } else {
                    temp += str;
                }
            }
        }
        if(!temp.equals("")) {
            within.add(new Packet(temp));
        }
    }
    public int comp(Packet another) {
        int loop = Math.min(this.within.size(), another.within.size());
        if(this.isInt && another.isInt) {
            return another.packetVal - this.packetVal;
        }
        if(!this.isInt && !another.isInt) {
            for(int i = 0; i < loop; i++) {
                int res = this.within.get(i).comp(another.within.get(i));
                if(res != 0) {
                    return res;
                }
            }
            return another.within.size() - this.within.size();
        }
        Packet tempOne = null;
        Packet tempTwo = null;
        if(this.isInt) {
            tempOne = new Packet("[" + this.packetVal + "]");
        } else {
            tempOne = this;
        }
        if(another.isInt) {
            tempTwo = new Packet("[" + another.packetVal + "]");
        } else {
            tempTwo = another;
        }
        return tempOne.comp(tempTwo);
    }

}

package brainstorming;

import java.util.stream.Stream;

public class IPDecodeAndEncode {
    private long l;
    public static void main(String[] args) {
        IPDecodeAndEncode testDmeo = new IPDecodeAndEncode();
        testDmeo.decode("192.168.2.1");
        System.out.println(testDmeo.l);
        System.out.println(testDmeo.encode(3232236033L));
    }


    public IPDecodeAndEncode() {
        this.l = 0L;
    }

    public void decode(String ipStrs){
        this.l = 0L;
        Stream.of(ipStrs.split("\\.")).forEach(this::ipUp);
    }

    private final void ipUp(final String ipStr){
        long sum = Long.parseLong(ipStr);
        l = (l << 8) + Long.parseLong(ipStr);
    }

    public String encode(long ipNo){
        StringBuffer sb = new StringBuffer();
        while (ipNo != 0){
            if (ipNo >>> 8 == 0){
                sb.insert(0, ipNo & 255);
            }else {
                sb.insert(0, "." + (ipNo & 255));
            }
            ipNo = ipNo >>> 8;
        }
        return sb.toString();
    }
}

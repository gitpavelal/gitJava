import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        ObjectOutputStream out  = new ObjectOutputStream(buff);

        out.writeObject("HELLO");
        out.flush();
        out.close();

        byte[] rawData = buff.toByteArray();

        ObjectInput in = new ObjectInputStream(new ByteArrayInputStream(rawData));
        String sreB = ((String) in.readObject());

        System.out.println(sreB);

    }
}

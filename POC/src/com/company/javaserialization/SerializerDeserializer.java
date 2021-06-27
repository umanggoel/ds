package com.company.javaserialization;

import com.company.javaserialization.serialized.User;

import java.io.*;

public class SerializerDeserializer {

//    public void deserialize(com.company.javaserialization.serialized.User user) throws IOException {
//        FileOutputStream fileOutputStream
//                = new FileOutputStream("yourfile2.txt");
//        ObjectOutputStream objectOutputStream
//                = new ObjectOutputStream(fileOutputStream);
//        objectOutputStream.writeObject(user);
//        objectOutputStream.flush();
//        objectOutputStream.close();
//    }

    public byte[] deserialize2(com.company.javaserialization.serialized.User user) throws IOException {
        ByteArrayOutputStream fileOutputStream
                = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream
                = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(user);
        objectOutputStream.flush();
        return fileOutputStream.toByteArray();
    }

//    public com.company.javaserialization.serialized.User serialize() throws IOException, ClassNotFoundException {
//        FileInputStream fileInputStream
//                = new FileInputStream("yourfile2.txt");
//        ObjectInputStream objectInputStream
//                = new ObjectInputStream(fileInputStream);
//        com.company.javaserialization.serialized.User user = (User) objectInputStream.readObject();
//        objectInputStream.close();
//        return user;
//    }


    public User serialize2(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream fileInputStream
                = new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream
                = new ObjectInputStream(fileInputStream);
        User user = (User) objectInputStream.readObject();
        objectInputStream.close();
        return user;
    }

}

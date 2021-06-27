package com.company.javaserialization;

import com.company.javaserialization.serialized.User;

import java.io.IOException;

public class Solution {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        com.company.javaserialization.serialized.User u = new User();
        u.setAge1(12);
        u.setHeight(13);

        SerializerDeserializer  serializerDeserializer = new SerializerDeserializer();
       // serializerDeserializer.deserialize(u);
       // System.out.println(serializerDeserializer.serialize().toString());

        byte[]  bytes = serializerDeserializer.deserialize2(u);
        System.out.println(serializerDeserializer.serialize2(bytes).toString());
    }
}

package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class IOData {
	   public static Object readOb(String path) {
	        try {
	            FileInputStream fis = new FileInputStream(path);///khọi tạo đối tượng
	            Object object;
	            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
	                object = ois.readObject();// dọc object
	                ois.close();///đóng luồng
	            }
	            return object;
	        } catch (IOException | ClassNotFoundException e) {
	        }
	        return null;
	    }
	    public static void writeOb(String path, Object obj) {
	        try {
	            FileOutputStream fos = new FileOutputStream(path);//Khởi tạo đối tượng
	            try (ObjectOutput oos = new ObjectOutputStream(fos)) {
	                oos.writeObject(obj);//ghi nội dung objcet
	                oos.close();//đóng luồng
	            }
	        } catch (IOException e) {
	        }

	    }
}

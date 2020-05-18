package com.toy.io;

import com.miui.global.kit.util.JSONUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonNode;

public class Application {
    public static void main(String[] args) {

        String mongo = readFile("/Users/tany/Code/Personal/Exercise/io/src/main/resources/mongodb.txt");
        String es = readFile("/Users/tany/Code/Personal/Exercise/io/src/main/resources/es.txt");

        if (StringUtils.isNotBlank(es)) {
            es = es.replace("\n", "");
        }
        String[] mongoDocs = mongo.split("\n");

        try {
            JsonNode esNodes = JSONUtils.toJsonNode(es);

            Set<String> esSet = new HashSet<String>();
            Set<String> mongoSet = new HashSet<String>();

            List<String> repeatAble = new ArrayList<String>();
            Set<String> expla = new HashSet<String>();

            JsonNode realData = esNodes.get("hits").get("hits");
            for (JsonNode node : realData) {
                if(!esSet.add(node.get("_source").get("docid").asText())){
                    repeatAble.add(node.get("_source").get("docid").asText());
                    expla.add(node.get("_source").get("docid").asText());
                }
            }

            for (String item : mongoDocs) {
                mongoSet.add(item);
            }

            System.out.println(esSet);
        } catch (Exception e) {
            System.out.println("log");
        }
    }

    public static String readFile(String fileName) {
        File file = new File(fileName);
        Reader reader = null;
        try {
            System.out.println("以字符为单位读取文件内容，一次读多个字节：");
            // 一次读多个字符
            char[] tempchars = new char[30];
            int charread = 0;
            reader = new InputStreamReader(new FileInputStream(fileName));
            // 读入多个字符到字符数组中，charread为一次读取字符数
            List<String> middleResult = new ArrayList<String>();
            while ((charread = reader.read(tempchars)) != -1) {
                // 同样屏蔽掉\r不显示
                if ((charread == tempchars.length)
                        && (tempchars[tempchars.length - 1] != '\r')) {
                    middleResult.add(String.valueOf(tempchars));
                } else {

                    for (int i = 0; i < charread; i++) {
                        if (tempchars[i] == '\r') {
                            continue;
                        } else {
                            middleResult.add(String.valueOf(tempchars[i]));
                        }
                    }
                }
            }

            StringBuffer result = new StringBuffer();
            for (String item : middleResult) {
                result.append(item);
            }
            return result.toString();
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return "";
    }
}

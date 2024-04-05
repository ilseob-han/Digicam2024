

import java.io.*;
import java.nio.file.*;
import java.util.stream.Stream;

public class MergeJavaFilesInDirectory {
    public static void main(String[] args) {
        String directoryPath = "C:\\Users\\BIT\\Documents\\MiniProject1"; // 蹂묓빀??Java ?뚯씪?ㅼ씠 ?덈뒗 ?붾젆?좊━ 寃쎈줈
        String outputFilePath = "C:\\Users\\BIT\\Documents\\MiniProject1\\merged\\MergedJavaFiles.java"; // 蹂묓빀???뚯씪??異쒕젰 寃쎈줈 諛??대쫫

        // 異쒕젰 ?뚯씪???꾪븳 PrintWriter ?앹꽦
        try (PrintWriter out = new PrintWriter(outputFilePath)) {
            // 吏?뺣맂 ?붾젆?좊━ ?댁쓽 紐⑤뱺 ?뚯씪??由ъ뒪?몄뾽
            try (Stream<Path> paths = Files.walk(Paths.get(directoryPath))) {
                paths.filter(Files::isRegularFile) // ?붾젆?좊━媛 ?꾨땶 ?뚯씪留??꾪꽣留?
                     .filter(path -> path.toString().endsWith(".java")) // .java ?뚯씪留??꾪꽣留?
                     .forEach(path -> {
                         // 媛?Java ?뚯씪???댁슜???쎄퀬 異쒕젰 ?뚯씪???곌린
                         try (Stream<String> stream = Files.lines(path)) {
                             out.println("// ?뚯씪: " + path.getFileName());
                             stream.forEach(out::println);
                             out.println(); // ?뚯씪 媛?援щ텇???꾪빐 鍮?以?異붽?
                         } catch (IOException e) {
                             e.printStackTrace();
                         }
                     });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


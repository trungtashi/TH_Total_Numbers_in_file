import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadFileExample {
    public static void main(String[] args) {
        System.out.println("Nhập đường dẫn file: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        ReadFileExample readFileExample = new ReadFileExample();
        readFileExample.readFileText(path);
    }
    public void readFileText(String filePath){
        try{
//            Đọc file theo đường dẫn
            File file = new File(filePath);
//            Kiểm tra nếu file không tồn tại thì ném ra ngoại lệ
            if(!file.exists()){
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            int sum = 0;
            while((line = br.readLine()) != null){
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            br.close();
//            In ra màn hình tổng các  nguyên trong file
            System.out.println("Tổng = " + sum);
        }
        catch (Exception e){
//             TH file không tồn tại hoặc nội dung file có lỗi thì sẽ hiển thị thông báo lỗi
            System.out.println("File không tô tại hoặc nội dung có lỗi");
        }
    }
}

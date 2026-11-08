# Bài 10 - The Broken Pipeline

Đây là trạng thái **đã sửa** của mã mẫu (không nộp pipeline đỏ làm trạng thái cuối). Chạy `./run.sh`; CI `push`/`pull_request` chạy `mvn -B clean verify` và upload JAR.

## Đọc lỗi và sửa từ mẫu đề

1. `pom.xml`, các thẻ đóng ở dependency/plugin (bản đề trang 6-7): ví dụ `</ groupId>` và `</ artifactId>` có khoảng trắng **sau dấu /**, không hợp lệ theo XML, làm POM không parse được. Sửa thành `</groupId>`, `</artifactId>`. Lưu ý: khoảng trắng **trước dấu >** trong `<maven.compiler.source >` tự nó vẫn hợp lệ XML; chỉ chuẩn hóa cách viết cho dễ đọc.
2. `pom.xml`, dependency Logback (trang 6): version `9.9.9` không tồn tại; sau khi POM hợp lệ, Maven báo không resolve được artifact. Đổi thành `1.4.11`.
3. `.github/workflows/ci.yml`, bản đề trang 7: sai thụt lề `uses`, `with`, `- name` và thiếu `actions/checkout`; workflow không được GitHub parse hoặc build không có source. Căn YAML đúng và thêm checkout. Đồng thời nâng Surefire từ `2.12.4` lên `3.5.4` vì bản cũ không chạy đúng JUnit Jupiter 5; bật `failIfNoTests` để không âm thầm bỏ qua test.

## Lỗi thứ tư tự tạo để kiểm chứng

Sau khi pipeline đã xanh, trong `src/test/java/com/lab/ShippingCalculatorTest.java`, tạm đổi giá trị mong đợi của `standardShipping` từ `15000.0` thành `16000.0`. Commit/push để log ghi rõ expected/actual và trạng thái đỏ, rồi khôi phục `15000.0`, commit/push để xanh. **Phải dùng log và ảnh GitHub Actions thật**; file zip không thể tự tạo chứng cứ về các lần push chưa thực hiện. Nên sửa lần lượt từng lỗi, lưu log của mỗi lần thử và ghi lại đúng dòng nguồn tương ứng.

# Product Discount Calculator

Bài tập Java Web dùng JSP + Servlet xử lý form POST.

## Chức năng

Nhập Product Description, List Price, Discount Percent và nhấn Calculate Discount. Servlet tại `/display-discount` tính:

- Discount Amount = List Price × Discount Percent × 0.01
- Discount Price = List Price − Discount Amount

Ứng dụng kiểm tra dữ liệu và hiển thị kết quả.

## Chạy với Java 17 và Tomcat 10.1+

```bash
mvn clean package
```

Chép `target/product-discount-calculator.war` vào thư mục `webapps` của Tomcat, khởi động Tomcat và truy cập http://localhost:8080/product-discount-calculator/

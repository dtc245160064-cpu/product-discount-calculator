package com.codegym;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;

@WebServlet(name = "DiscountServlet", urlPatterns = "/display-discount")
public class DiscountServlet extends HttpServlet {
    private static String escapeHtml(String value) {
        return value.replace("&", "&amp;").replace("<", "&lt;")
                .replace(">", "&gt;").replace("\"", "&quot;").replace("'", "&#39;");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html><html lang='en'><head><meta charset='UTF-8'><title>Discount Result</title></head>");
            out.println("<body style='font-family:Arial,sans-serif;text-align:center;margin-top:80px'>");
            try {
                String description = request.getParameter("description");
                if (description == null || description.isBlank()) throw new IllegalArgumentException();
                BigDecimal price = new BigDecimal(request.getParameter("listPrice"));
                BigDecimal percent = new BigDecimal(request.getParameter("discountPercent"));
                if (price.signum() < 0 || percent.signum() < 0 || percent.compareTo(BigDecimal.valueOf(100)) > 0) {
                    throw new IllegalArgumentException();
                }
                BigDecimal amount = price.multiply(percent).multiply(new BigDecimal("0.01"));
                BigDecimal finalPrice = price.subtract(amount);
                out.println("<h2>Product Discount Result</h2>");
                out.println("<p>Product Description: " + escapeHtml(description) + "</p>");
                out.println("<p>List Price: " + price.setScale(2, RoundingMode.HALF_UP) + "</p>");
                out.println("<p>Discount Percent: " + percent.stripTrailingZeros().toPlainString() + "%</p>");
                out.println("<p>Discount Amount: " + amount.setScale(2, RoundingMode.HALF_UP) + "</p>");
                out.println("<h3>Discount Price: " + finalPrice.setScale(2, RoundingMode.HALF_UP) + "</h3>");
            } catch (NullPointerException | IllegalArgumentException e) {
                out.println("<h2 style='color:#b91c1c'>Invalid input. Please enter valid product information.</h2>");
            }
            out.println("<p><a href='index.jsp'>Back to calculator</a></p></body></html>");
        }
    }
}
